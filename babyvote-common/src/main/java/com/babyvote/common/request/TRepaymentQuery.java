package com.babyvote.common.request;

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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TRepayment对象", description="")
public class TRepaymentQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "借款id")
    private String borrowId;

    @ApiModelProperty(value = "借款人id")
    private String borrowUserId;

    @ApiModelProperty(value = "借款标题")
    private String borrowTitle;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "截止日期")
    private Date deadline;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "还款日期")
    private Date repaymentTime;

    @ApiModelProperty(value = "本期还款总金额(单位：分)")
    private Long totalAmount;

    @ApiModelProperty(value = "本期还款本金(单位：分)")
    private Long principal;

    @ApiModelProperty(value = "本期还款总利息(单位：分)")
    private Long interest;

    @ApiModelProperty(value = "还款期数(第几期)")
    private Integer period;

    @ApiModelProperty(value = "还款状态（1、逾期，2、待还，3、已还，4、逾期已还）")
    private Integer state;

    @ApiModelProperty(value = "借款类型")
    private Integer borrowType;

    @ApiModelProperty(value = "还款方式（1等额本息,2先息后本）")
    private Integer repaymentType;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "当前页码")
    private Integer nowPage;

    @ApiModelProperty(value = "每页展示数量")
    private Integer pageSize;


}
