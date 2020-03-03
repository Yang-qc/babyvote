package com.babyvote.work.service.impl;

import com.babyvote.common.request.TRepaymentDetailQuery;
import com.babyvote.model.domain.TRepaymentDetail;
import com.babyvote.work.mapper.TRepaymentDetailMapper;
import com.babyvote.work.pojo.TRepaymentDetailVo;
import com.babyvote.work.service.TRepaymentDetailService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Service
public class TRepaymentDetailServiceImpl extends ServiceImpl<TRepaymentDetailMapper, TRepaymentDetail> implements TRepaymentDetailService {


    /**
     * 根据借款id查询还款记录
     * @param id
     * @return
     * @auther 李
     */
    @Override
    public List<TRepaymentDetailVo> findDetailByBorrowId(Integer id) {
        QueryWrapper<TRepaymentDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("borrow_id",id);
        List<TRepaymentDetail> tRepaymentDetails = baseMapper.selectList(queryWrapper);
        List<TRepaymentDetailVo> tRepaymentDetailsVo = new ArrayList<>();
        TRepaymentDetailVo tRepaymentDetailVo = new TRepaymentDetailVo();
        for (int i = 0; i < tRepaymentDetails.size(); i++) {
            BeanUtils.copyProperties(tRepaymentDetails.get(i), tRepaymentDetailVo);
            //时间格式
//            tRepaymentDetailVo.setCreateTime(tRepaymentDetailVo.getCreateTime().substring(1,10));
            tRepaymentDetailVo.setCreateTime(tRepaymentDetailVo.getCreateTime());
            tRepaymentDetailsVo.add(i,tRepaymentDetailVo);
            Integer day = Math.toIntExact((tRepaymentDetails.get(i).getDeadline().getTime() - tRepaymentDetails.get(i).getRepaymentTime().getTime()) / (24 * 60 * 60 * 1000));
            if(day>0||day==0){//已还状态
                tRepaymentDetailsVo.get(i).setSatae("已还");
            }else {
               tRepaymentDetailsVo.get(i).setSatae("逾期已还");
            }
        }
        return tRepaymentDetailsVo;
    }

    /**
     * 收款明细分页查询---根据投资人id/账号id查询收款明细
     * @param pageParam
     * @param tRepaymentDetailQuery
     */
    @Override
    public void selectDetailAll(Page<TRepaymentDetail> pageParam, TRepaymentDetailQuery tRepaymentDetailQuery) {
        QueryWrapper<TRepaymentDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        String bidUserId=tRepaymentDetailQuery.getUserId();
        //获取还款方式
        Integer repaymentType = tRepaymentDetailQuery.getRepaymentType();
        //查询条件
        if (!StringUtils.isEmpty(bidUserId)) {
            queryWrapper.eq("bid_user_id", bidUserId);
        }
        if (!StringUtils.isEmpty(repaymentType)) {
            queryWrapper.eq("repayment_type", repaymentType);
        }
        baseMapper.selectPage(pageParam,queryWrapper);
    }

    /**
     * 根据id更新收款明细
     * @param repaymentDetail
     * @return
     * @auther 杨
     */
    @Override
    public int updateDetail(TRepaymentDetail repaymentDetail) {
        return baseMapper.updateById(repaymentDetail);
    }

}
