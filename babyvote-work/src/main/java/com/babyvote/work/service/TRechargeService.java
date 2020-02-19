package com.babyvote.work.service;

import com.babyvote.common.request.TRechargeQuery;
import com.babyvote.common.request.TRepaymentQuery;
import com.babyvote.model.domain.TRecharge;
import com.babyvote.model.domain.TRepayment;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  充值服务类接口
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
public interface TRechargeService extends IService<TRecharge> {
    /**
     * 充值记录查询
     * @param pageParam
     * @param tRechargeQuery
     */
    public void selectAll(Page<TRecharge> pageParam, TRechargeQuery tRechargeQuery);
}
