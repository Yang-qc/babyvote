package com.babyvote.work.service.impl;

import com.babyvote.common.constants.ResultCodeEnum;
import com.babyvote.common.exception.ExceptionThrowOut;
import com.babyvote.common.request.TRepaymentQuery;
import com.babyvote.common.util.SystemLimitConst;
import com.babyvote.model.domain.*;
import com.babyvote.work.mapper.TRepaymentDetailMapper;
import com.babyvote.work.mapper.TRepaymentMapper;
import com.babyvote.work.pojo.TRepaymentDetailVo;
import com.babyvote.work.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

/**
 * 还款服务实现类
 * @author 宝贝投项目组
 * @since 2020-02-12
 * @return 杨
 */
@Service
@Transactional
public class TRepaymentServiceImpl extends ServiceImpl<TRepaymentMapper, TRepayment> implements TRepaymentService {
    @Autowired
    private TUserWalletService tUserWalletService;
    @Autowired
    private TAccountFlowService tAccountFlowService;
    @Autowired
    private TRepaymentDetailService tRepaymentDetailService;

    @Autowired
    private TRepaymentDetailMapper tRepaymentDetailMapper;

    @Autowired
    private TBidService tBidService;

    /**
     * 还款分页查询
     * @param pageParam
     * @param tRepaymentQuery
     * @return 杨
     */
    @Override
    public void getByBorrowId(Page<TRepayment> pageParam, TRepaymentQuery tRepaymentQuery) {
        QueryWrapper<TRepayment> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        //获取开始日期
        Date beginDate = tRepaymentQuery.getCreateTime();
        //获取结束日期
        Date endDate = tRepaymentQuery.getDeadline();
        //获取用户id
        String userId = tRepaymentQuery.getUserId();
        //获取还款状态
        Integer borrowStates = tRepaymentQuery.getState();
        //条件查询
        if (!StringUtils.isEmpty(beginDate)) {
            queryWrapper.eq("create_time", beginDate);
        }
        if (!StringUtils.isEmpty(endDate)) {
            queryWrapper.eq("deadline", endDate);
        }
        if (!StringUtils.isEmpty(userId)) {
            queryWrapper.eq("borrow_id", userId);
        }
        if (!StringUtils.isEmpty(borrowStates)) {
            queryWrapper.eq("state", borrowStates);
        }
        baseMapper.selectPage(pageParam, queryWrapper);
    }

    /**
     * 还款
     * @param id
     * @param userId
     * @return 杨
     */
    @Override
    public void repay(String id, String userId) {
        //1、获取还款条件
        TRepayment tRepayment = baseMapper.selectById(id);
        //获取用户钱包信息
        TUserWallet userWallet = tUserWalletService.findByUserId(userId);
        //本期还款总金额
        Long totalAmount = tRepayment.getTotalAmount();
        //账户余额
        Long availableAmount = userWallet.getAvailableAmount();
        //查询用户钱包余额是否大于还款金额
        if(totalAmount>availableAmount){
            ExceptionThrowOut.cast(ResultCodeEnum.INSUFFICIENT_ACCOUNT_BALANCE);
        }
        //2、执行还款流程
        //增加账户剩余信用额度=剩余信用额度+本次还款总额
        Long residualCreditLine=userWallet.getResidualCreditLine()+tRepayment.getPrincipal();
        userWallet.setResidualCreditLine(residualCreditLine);
        //减少账户余额
        Long money=availableAmount-totalAmount;
        userWallet.setAvailableAmount(money);
        //减少账户待还金额
        Long repaidAmount=userWallet.getRepaidAmount()-totalAmount;
        userWallet.setRepaidAmount(repaidAmount);
        //修改借款人账户钱包
        tUserWalletService.updataTUserWallet(userWallet);
        //生成还款流水
        TAccountFlow accountFlow = new TAccountFlow();
        accountFlow.setAccountId(userId);//账户id
        accountFlow.setAmount(tRepayment.getTotalAmount());//金额
        accountFlow.setFlowType(1);//资金流水类型
        accountFlow.setAvailableAmount(money);//变化后的可用金额
        accountFlow.setFreezeAmount(userWallet.getFreezeAmount());//变化后的冻结金额
        accountFlow.setRemark("["+tRepayment.getBorrowTitle()+"]还款成功，本次还款金额："+tRepayment.getTotalAmount()+"元。");
        //调用生成流水方法
        tAccountFlowService.insertTAccountFlow(accountFlow);
        //还款成功，给投资人添加收款明细
        addDetail(tRepayment);
        //更新相关投资人收益
        eidtByUser(tRepayment);
        //获取当前系统时间
        Date date=new Date();
        //判断系统当时时间是否超过还款截至时间
        if(date.getTime()>tRepayment.getDeadline().getTime()){
            //修改为逾期已还
            tRepayment.setState(4);
        }else{
            //修改为已还
            tRepayment.setState(3);
        }
        //修改还款状态
        baseMapper.updateById(tRepayment);
    }

    /**
     * 更新投资用户收益明细
     * @param tRepayment
     * @return 杨
     */
    public void eidtByUser(TRepayment tRepayment) {
        //查询所有相关投资人信息，          获取的值需要重新测试
        QueryWrapper<TRepaymentDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("borrow_id",tRepayment.getBorrowId());
         List<TRepaymentDetail> tRepaymentDetails =tRepaymentDetailMapper.selectList(queryWrapper);
        for(TRepaymentDetail repaymentDetail:tRepaymentDetails){
            //获取投资人钱包
            TUserWallet userWallet = tUserWalletService.findByUserId(repaymentDetail.getBidUserId());
            //更新投资人账户余额=账户余额+本期还款
            Long availableAmount=userWallet.getAvailableAmount()+repaymentDetail.getPrincipal();
            userWallet.setAvailableAmount(availableAmount);
            //更新投资人代收利息=代收利息-本期还款总利息
            Long interestPending=userWallet.getInterestPending()-repaymentDetail.getInterest();
            userWallet.setInterestPending(interestPending);
            //减少投资人代收本金
            Long principalPending=userWallet.getPrincipalPending()-repaymentDetail.getPrincipal();
            userWallet.setPrincipalPending(principalPending);
            //更新投资人钱包
            tUserWalletService.updataTUserWallet(userWallet);
            //添加收款流水说明
            TAccountFlow tAccountFlow =new TAccountFlow();
//            BigDecimal yRepaymentAmount = BigDecimal.valueOf(tRepayment.getTotalAmount()).divide(BigDecimal.valueOf(SystemLimitConst.MONEY_UNIT), SystemLimitConst.MONEY_SHOW_SCALE, RoundingMode.DOWN);
            tAccountFlow.setAccountId(userWallet.getAccountId());
            tAccountFlow.setAmount(repaymentDetail.getPrincipal());
            tAccountFlow.setFlowType(1);
            tAccountFlow.setAvailableAmount(availableAmount);
            tAccountFlow.setFreezeAmount(userWallet.getFreezeAmount());
            tAccountFlow.setRemark("["+tRepayment.getBorrowTitle()+"]收款成功，本次收款金额："+repaymentDetail.getPrincipal()+"元。");
            //生成会回款流水
            tAccountFlowService.insertTAccountFlow(tAccountFlow);
            //更新还款明细的还款时间
            repaymentDetail.setRepaymentTime(new Date());
            repaymentDetail.setCreateTime(new Date());
            tRepaymentDetailService.updateDetail(repaymentDetail);
        }
    }

    /**
     * 还款成功，为投资人账户添加收款明细
     * @param tRepayment
     * @return 杨
     */
    public void addDetail(TRepayment tRepayment) {
        //获取多个投资人集合
        List<TBid> tBidByborrowId = tBidService.findTBidByborrowId(Integer.parseInt(tRepayment.getBorrowId()));
        for (TBid bid :tBidByborrowId){
            TRepaymentDetail detail = new TRepaymentDetailVo();
            detail.setBidId(bid.getBidUserId());//标id
            detail.setBorrowId(bid.getBorrowId());//借款id
            detail.setRepaymentId(bid.getBorrowId());//还款id
            detail.setBorrowUserId(tRepayment.getBorrowUserId());//借款人id
            detail.setBidUserId(bid.getBidUserId());//投标人id
            detail.setBorrowTitle(tRepayment.getBorrowTitle());//借款标题
            detail.setTotalAmount(tRepayment.getTotalAmount());//本期还款总金额
            detail.setPrincipal(bid.getBidAmount());//本期还款本金
            detail.setInterest(bid.getBidInterest());//本期还款总利息
            detail.setPeriod(tRepayment.getPeriod());//还款期数
            detail.setDeadline(tRepayment.getDeadline());//本期还款截止日期
            detail.setRepaymentTime(tRepayment.getRepaymentTime());//还款时间
            detail.setRepaymentType(tRepayment.getRepaymentType());//还款方式
            //生成一条收款明细
            tRepaymentDetailService.save(detail);
        }
    }
}
