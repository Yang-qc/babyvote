package com.babyvote.common.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * 通用查询对象，对于一些通用属性的提取
 */
@Data
@ToString
@ApiModel(value = "通用查询对象",description = "通用查询对象")
public class RequestData {

    @ApiModelProperty(value = "开始时间")
    private String startTime;

    @ApiModelProperty(value = "结束时间")
    private String endTime;

    @ApiModelProperty(value = "当前页")
    private Long nowPage;

    @ApiModelProperty(value = "每页大小")
    private Long pageSize;
}
