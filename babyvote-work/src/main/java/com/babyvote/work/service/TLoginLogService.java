package com.babyvote.work.service;

import com.babyvote.common.request.LoginLogRequest;
import com.babyvote.model.domain.TLoginLog;
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
public interface TLoginLogService extends IService<TLoginLog> {

    void query(Page<TLoginLog> pageParam, LoginLogRequest loginLogRequest);
}
