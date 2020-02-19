package com.babyvote.work.pojo;

import com.babyvote.model.domain.TRepaymentDetail;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TRepaymentDetailVo extends TRepaymentDetail {

    @ApiModelProperty(value = "还款状态，已还或预期已还，根据时间进行处理")
    private String satae;
}
