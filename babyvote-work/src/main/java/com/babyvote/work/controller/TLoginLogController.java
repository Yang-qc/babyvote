package com.babyvote.work.controller;


import com.babyvote.api.admin.TLoginLogControllerApi;
import com.babyvote.common.constants.ResultCodeEnum;
import com.babyvote.common.exception.ExceptionThrowOut;
import com.babyvote.common.request.LoginLogRequest;
import com.babyvote.common.response.Result;
import com.babyvote.common.response.ResultListPage;
import com.babyvote.model.domain.TLoginLog;
import com.babyvote.work.service.TLoginLogService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  登录日志管理
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Slf4j
@RestController
@RequestMapping("/system/loginlog/")
public class TLoginLogController implements TLoginLogControllerApi {

    @Autowired
    private TLoginLogService tLoginLogService;

    @PostMapping("query")
    @Override
    public Result query(LoginLogRequest loginLogRequest){
        Page<TLoginLog> pageParam = new Page<>(loginLogRequest.getNowPage(), loginLogRequest.getPageSize());
        tLoginLogService.query(pageParam, loginLogRequest);
        return Result.ok(
                new ResultListPage(
                        pageParam.getRecords(), pageParam.getPages(),
                        pageParam.getTotal(), pageParam.getCurrent(), pageParam.getSize()));
    }

    @Override
    @PostMapping("loginLogSave")
    public Result LoginLogSave(TLoginLog loginLog) {
        try {
            tLoginLogService.save(loginLog);
            return Result.ok();
        }catch (Exception e){
            ExceptionThrowOut.cast(ResultCodeEnum.FAILED_TO_ADD_LOG);
            log.error("添加日志失败！具体错误：{}",e.getMessage());
            return Result.error();
        }
    }

}

