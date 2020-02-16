package com.babyvote.common.request;

import com.babyvote.common.model.request.RequestData;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 还款信息查询类
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Data
@ApiModel(value = "LoginLogRequest查询对象",description = "登录日志查询对象封装")
public class LoginLogRequest extends RequestData implements Serializable  {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "状态")
    private Integer loginResult;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户类型")
    private Integer accountType;


}
