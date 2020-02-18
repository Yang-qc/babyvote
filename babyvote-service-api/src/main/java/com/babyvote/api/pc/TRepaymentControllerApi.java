package com.babyvote.api.pc;

import com.babyvote.common.request.TRepaymentQuery;
import com.babyvote.common.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "宝贝投互联网金融平台", description = "还款模块管理中心")
public interface TRepaymentControllerApi {

    @ApiOperation("还款信息分页查询")
    public Result getByBorrowId(
            @ApiParam(name = "tRepaymentQuery", value = "还款查询对象", required = true) TRepaymentQuery tRepaymentQuery
    );
}
