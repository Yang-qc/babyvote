package com.babyvote.common.exception;

import com.babyvote.common.constants.ResultCodeEnum;
import com.babyvote.common.model.response.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * 自定义异常类型
 */
@Data
@ToString
@ApiModel(value = "全局异常")
public class KetaiException extends RuntimeException {
    @ApiModelProperty(value = "状态码")
    private Integer code;

    //错误代码
    ResultCode resultCode;
    /**
     * 接受状态码和消息
     * @param code
     * @param message
     */
    public KetaiException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型
     * @param resultCodeEnum
     */
    public KetaiException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    /**
     * 接收枚举类型
     */
    public KetaiException(ResultCode resultCode) {
        super(resultCode.message());
        this.resultCode = resultCode;
    }
}
