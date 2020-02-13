package com.babyvote.common.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@ApiModel(value = "全局统一返回结果")
public class ResponseResult implements Response {

    @ApiModelProperty(value = "是否成功")
    boolean success = SUCCESS;

    @ApiModelProperty(value = "返回码")
    int code = SUCCESS_CODE;

    @ApiModelProperty(value = "返回消息")
    String message;

    public ResponseResult(ResultCode resultCode){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public static ResponseResult SUCCESS(){
        return new ResponseResult(CommonCode.SUCCESS);
    }
    public static ResponseResult FAIL(){
        return new ResponseResult(CommonCode.FAIL);
    }

}
