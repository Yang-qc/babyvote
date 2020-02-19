package com.babyvote.work.service.impl;

import com.babyvote.common.request.TRechargeQuery;
import com.babyvote.model.domain.TRecharge;
import com.babyvote.model.domain.TRepayment;
import com.babyvote.work.mapper.TRechargeMapper;
import com.babyvote.work.service.TRechargeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  充值服务实现类
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Service
public class TRechargeServiceImpl extends ServiceImpl<TRechargeMapper, TRecharge> implements TRechargeService {

    @Override
    public void selectAll(Page<TRecharge> pageParam, TRechargeQuery tRechargeQuery) {
        QueryWrapper<TRecharge> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        //根据充值状态查询
        Integer state=tRechargeQuery.getState();

        //条件查询
        if (!StringUtils.isEmpty(state)) {
            queryWrapper.eq("state", state);
        }
        baseMapper.selectPage(pageParam,queryWrapper);
    }
}
