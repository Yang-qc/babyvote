package com.babyvote.api.admin;

import com.babyvote.common.response.Result;
import com.babyvote.model.domain.TRecharge;
import io.swagger.annotations.ApiParam;

public interface TRechargeControllerApi {

    public Result audit(@ApiParam(name = "recharge", value = "用户充值信息管理实体") TRecharge recharge);

}
