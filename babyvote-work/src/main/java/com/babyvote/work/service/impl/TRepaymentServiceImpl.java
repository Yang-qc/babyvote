package com.babyvote.work.service.impl;

import com.babyvote.common.request.TRepaymentQuery;
import com.babyvote.model.domain.TRepayment;
import com.babyvote.work.mapper.TRepaymentMapper;
import com.babyvote.work.service.TRepaymentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * <p>
 *  还款服务实现类
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Service
@Transactional
public class TRepaymentServiceImpl extends ServiceImpl<TRepaymentMapper, TRepayment> implements TRepaymentService {

    @Override
    public void getByBorrowId(Page<TRepayment> pageParam, TRepaymentQuery tRepaymentQuery) {
        QueryWrapper<TRepayment> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        if (queryWrapper == null) {
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }
        //获取开始日期
        Date beginDate=tRepaymentQuery.getCreateTime();
        //获取结束日期
        Date endDate=tRepaymentQuery.getDeadline();
        //获取用户id
        String userId=tRepaymentQuery.getBorrowUserId();
        //获取还款状态
        Integer borrowStates=tRepaymentQuery.getState();
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


}
