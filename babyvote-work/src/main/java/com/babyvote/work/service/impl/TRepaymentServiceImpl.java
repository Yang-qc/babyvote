package com.babyvote.work.service.impl;

import com.babyvote.common.query.TRepaymentQuery;
import com.babyvote.work.pojo.TRepayment;
import com.babyvote.work.mapper.TRepaymentMapper;
import com.babyvote.work.service.TRepaymentService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Service
public class TRepaymentServiceImpl extends ServiceImpl<TRepaymentMapper, TRepayment> implements TRepaymentService {

    @Override
    public void getByBorrowId(Page<TRepayment> pageParam, TRepaymentQuery tRepaymentQuery) {

    }
}
