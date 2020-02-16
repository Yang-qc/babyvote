package com.babyvote.api.admin;

import com.babyvote.common.request.LoginLogRequest;
import com.babyvote.common.response.Result;
import com.babyvote.model.domain.TLoginLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;

@Api(value = "查询登录日志管理", description = "查询登录日志操作")
public interface TLoginLogControllerApi {

    @ApiOperation("查询登录日志列表")
    public Result query(@ApiParam(name = "LoginLogRequest", value = "日志查询条件封装") LoginLogRequest loginLogRequest);

    @ApiOperation("登录日志记录")
    public Result LoginLogSave(@ApiParam(name = "loginLog", value = "系统用户登录日志实体") TLoginLog loginLog);

}
