package com.babyvote.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TRepaymentDetail对象", description="")
public class TRepaymentDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "标的id")
    private String bidId;

    @ApiModelProperty(value = "借款id")
    private String borrowId;

    @ApiModelProperty(value = "还款id")
    private String repaymentId;

    @ApiModelProperty(value = "借款人id")
    private String borrowUserId;

    @ApiModelProperty(value = "投标人id")
    private String bidUserId;

    @ApiModelProperty(value = "借款标题")
    private String borrowTitle;

    @ApiModelProperty(value = "本期还款总金额(利息+本金)(单位：分)")
    private Long totalAmount;

    @ApiModelProperty(value = "本期还款本金(单位；分)")
    private Long principal;

    @ApiModelProperty(value = "本期还款总利息(单位：分)")
    private Long interest;

    @ApiModelProperty(value = "还款期数(第几月还款)")
    private Integer period;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "本期还款截止日期")
    private Date deadline;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "还款时间")
    private Date repaymentTime;

    @ApiModelProperty(value = "还款方式")
    private Integer repaymentType;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;


}
