package com.babyvote.work.service.impl;

import com.babyvote.common.request.LoginLogRequest;
import com.babyvote.model.domain.TLoginLog;
import com.babyvote.work.mapper.TLoginLogMapper;
import com.babyvote.work.service.TLoginLogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Service
public class TLoginLogServiceImpl extends ServiceImpl<TLoginLogMapper, TLoginLog> implements TLoginLogService {

    @Override
    public void query(Page<TLoginLog> pageParam, LoginLogRequest loginLogRequest) {
        // 条件
        QueryWrapper<TLoginLog> queryWrapper = new QueryWrapper<>();
        // 根据时间排序
        queryWrapper.orderByDesc("create_time");
        //开始时间
        String beginDate = loginLogRequest.getStartTime();
        //结束时间
        String endDate = loginLogRequest.getEndTime();
        //登录结果
        Integer loginResult = loginLogRequest.getLoginResult();
        //用户名
        String username = loginLogRequest.getUsername();
        //用户类型
        Integer accountType = loginLogRequest.getAccountType();
        if (!StringUtils.isEmpty(beginDate)) {
            queryWrapper.gt("login_time", beginDate);
        }
        if (!StringUtils.isEmpty(beginDate)) {
            queryWrapper.lt("login_time", endDate);
        }
        if (!StringUtils.isEmpty(loginResult)) {
            queryWrapper.eq("login_result", loginResult);
        }
        if (!StringUtils.isEmpty(username)) {
            queryWrapper.like("username", username);
        }

        if (!StringUtils.isEmpty(loginResult)) {
            queryWrapper.eq("account_type", accountType);
        }
        baseMapper.selectPage(pageParam, queryWrapper);
    }
}
