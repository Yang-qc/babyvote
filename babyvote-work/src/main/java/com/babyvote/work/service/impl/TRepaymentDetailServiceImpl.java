package com.babyvote.work.service.impl;

import com.babyvote.work.pojo.TRepaymentDetail;
import com.babyvote.work.mapper.TRepaymentDetailMapper;
import com.babyvote.work.pojo.TRepaymentDetailVo;
import com.babyvote.work.service.TRepaymentDetailService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
            tRepaymentDetailVo.setCreateTime(tRepaymentDetailVo.getCreateTime().substring(1,10));
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
}
