package com.babyvote.work.service;

import com.babyvote.common.request.TRepaymentQuery;
import com.babyvote.model.domain.TRepayment;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  还款服务接口
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

    /**
     * 还款
     * @param id
     * @param userId
     */
    public void repay(String id,String userId);
}
