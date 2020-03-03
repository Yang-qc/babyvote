package com.babyvote.work.service;

import com.babyvote.common.request.TRechargeQuery;
import com.babyvote.model.domain.TRecharge;
import com.babyvote.work.pojo.RequestParam;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 充值服务类接口
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
public interface TRechargeService extends IService<TRecharge> {

    /**
     * 根据时间和状态查询充值数据
     *
     * @param param
     * @auther 李
     */
    void findByTimeAndState(Page<TRecharge> pageParam, RequestParam param);

    /**
     * 充值审批，
     * 审核成功——>用户余额增加——>生成一条线上充值账户流水；
     *
     * @param tRecharge
     * @param
     * @return
     */
    int auditTRecharge(TRecharge tRecharge);

    /**
     * 充值分页查询
     *
     * @param pageParam
     * @param tRechargeQuery
     * @auther 杨
     */
    void selectRecharge(Page<TRecharge> pageParam, TRechargeQuery tRechargeQuery);


    /**
     * 账户充值
     *
     * @param tRecharge
     * @auther 杨
     */
    void addRecharge(TRecharge tRecharge);

}
