package com.babyvote.work.service.impl;

import com.babyvote.model.domain.TAccountFlow;
import com.babyvote.model.domain.TRecharge;
import com.babyvote.model.domain.TUserWallet;
import com.babyvote.work.mapper.TRechargeMapper;
import com.babyvote.work.pojo.RequestParam;
import com.babyvote.work.service.TAccountFlowService;
import com.babyvote.work.service.TBankCardService;
import com.babyvote.work.service.TRechargeService;
import com.babyvote.work.service.TUserWalletService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

/**
 * <p>
 *  充值审核 服务实现类
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Service
public class TRechargeServiceImpl extends ServiceImpl<TRechargeMapper, TRecharge> implements TRechargeService {

    @Autowired
    private TUserWalletService tUserWalletService;

    @Autowired
    private TAccountFlowService flowService;

    @Autowired
    private TBankCardService bankCardService;
    /**
     *  根据时间和状态查询充值数据
     * @param pageParam
     * @param param
     * @auther 李
     */
    @Override
    public void findByTimeAndState(Page<TRecharge> pageParam, RequestParam param) {
        QueryWrapper<TRecharge> queryWrapper = new QueryWrapper<>();
        //大于开始时间，小于结束时间
        queryWrapper.ge(!StringUtils.isEmpty(param.getSerStartTime()), "create_time", param.getSerStartTime()).le(!StringUtils.isEmpty(param.getSerEndTime()), "create_time",param.getSerEndTime());
        if(!StringUtils.isEmpty(param.getState())){
            if(param.getState()!=3) {
                queryWrapper.eq("state", param.getState());
            }
        }
        baseMapper.selectPage(pageParam,queryWrapper);
    }

    /**
     * 充值审批，
     * 审核成功——>用户余额增加——>银行卡余额减少——>生成一条线上充值账户流水；
     * 审核失败——>银行卡的钱回退
     * @param tRecharge
     * @param
     * @return
     * @auther 李
     */
    @Override
    public int auditTRecharge(TRecharge tRecharge) {
        TUserWallet byUserId = tUserWalletService.findByUserId(Integer.parseInt(tRecharge.getUserId()));
        //state 1:审核通过；2：审核失败
        if(tRecharge.getState()==1){
            TUserWallet tUserWallet = new TUserWallet();
            tUserWallet.setAccountId(tRecharge.getUserId());//账户id
            //用户余额增加：可用金额增加
             Long amount =  byUserId.getAvailableAmount()+tRecharge.getAmount();
            tUserWallet.setAvailableAmount(amount);
            //生成一条线上充值账户流水
            TAccountFlow tAccountFlow = new TAccountFlow();
            tAccountFlow.setId(UUID.randomUUID().hashCode());//主键id
            tAccountFlow.setAccountId(tRecharge.getUserId());//账户id
            tAccountFlow.setAmount(tRecharge.getAmount());//改变的金额数量
            tAccountFlow.setAvailableAmount(amount);        //变化后)可用金额
            tAccountFlow.setFreezeAmount(byUserId.getFreezeAmount());//变化后冻结金额
            tAccountFlow.setRemark("我是流水说明");
            tAccountFlow.setCreateTime(new Date());
            int i = flowService.insertTAccountFlow(tAccountFlow);
            //账户余额进行更新
            int i1 = tUserWalletService.updataTUserWallet(tUserWallet);
            if(i+i1>=2){
                return 1;//成功
            }
            //事务回滚
            return 0;//失败
        }
        //审核失败，银行卡的钱回退
        if(bankCardService.updataTBankCard(Integer.parseInt(tRecharge.getUserId()), tRecharge.getAmount())>0){
            return 1;
        }
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
       return 0;
    }
}
