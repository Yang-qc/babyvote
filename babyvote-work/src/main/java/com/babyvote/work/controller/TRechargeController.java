package com.babyvote.work.controller;


import com.babyvote.api.admin.TRechargeControllerApi;
import com.babyvote.common.constants.ResultCodeEnum;
import com.babyvote.common.exception.ExceptionThrowOut;
import com.babyvote.common.response.Result;
import com.babyvote.model.domain.TRecharge;
import com.babyvote.work.service.TRechargeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 充值审核接口
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Slf4j
@RestController
@RequestMapping("/system/recharge")
public class TRechargeController implements TRechargeControllerApi {

    /**
     * 充值账户
     */
    @Autowired
    private TRechargeService tRechargeService;

    /**
     * 充值审核
     *
     * @param recharge
     * @return
     */
    @Override
    @PostMapping("audit")
    public Result audit(@ApiParam(name = "recharge", value = "用户充值信息管理实体") TRecharge recharge) {

        return null;
    }
}

