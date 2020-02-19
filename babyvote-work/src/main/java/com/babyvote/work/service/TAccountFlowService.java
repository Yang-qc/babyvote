package com.babyvote.work.service;

import com.babyvote.model.domain.TAccountFlow;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  账户流水 服务类
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
public interface TAccountFlowService extends IService<TAccountFlow> {

    /**
     * 生成一条账户流水
     * 1. 充值审批成功后生成流水
     * 2.
     * @param tAccountFlow
     * @return
     * @auther 李
     */
    int insertTAccountFlow(TAccountFlow tAccountFlow);
}
