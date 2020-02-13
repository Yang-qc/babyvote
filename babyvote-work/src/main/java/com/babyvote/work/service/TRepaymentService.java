package com.babyvote.work.service;

import com.babyvote.common.query.TRepaymentQuery;
import com.babyvote.work.pojo.TRepayment;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */

public interface TRepaymentService extends IService<TRepayment> {

    /**
     * 还款信息分页查询
     * @param pageParam
     * @param tRepaymentQuery
     */
    public void getByBorrowId(Page<TRepayment> pageParam, TRepaymentQuery tRepaymentQuery);
}
