package com.babyvote.work.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

@Data
public class RequestParam {
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "开始时间")
    private String serStartTime;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "结束时间")
    private String serEndTime;

    @ApiModelProperty(value = "状态")
    private Integer state;

    private Integer nowPage;

    private Integer pageSize;

    private Integer totalNum;

}
