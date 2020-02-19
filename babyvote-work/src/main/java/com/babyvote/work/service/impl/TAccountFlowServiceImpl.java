package com.babyvote.work.service.impl;

import com.babyvote.model.domain.TAccountFlow;
import com.babyvote.work.mapper.TAccountFlowMapper;
import com.babyvote.work.service.TAccountFlowService;
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
public class TAccountFlowServiceImpl extends ServiceImpl<TAccountFlowMapper, TAccountFlow> implements TAccountFlowService {

    /**
     * 生成一条账户流水
     * 1. 充值审批成功后生成流水
     * 2.
     * @param tAccountFlow
     * @return
     * @auther 李
     */
    @Override
    public int insertTAccountFlow(TAccountFlow tAccountFlow) {
        return baseMapper.insert(tAccountFlow);
    }
}
