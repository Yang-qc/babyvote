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
@ApiModel(value="TRecharge对象", description="")
public class TRechargeQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "充值账户id")
    private String userId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "银行卡id")
    private String bankCardId;

    @ApiModelProperty(value = "交易号")
    private String tradeNo;

    @ApiModelProperty(value = "充值金额(单位：分)")
    private Long amount;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "充值日期")
    private Date rechargeTime;

    @ApiModelProperty(value = "审核状态( 0:审核拒绝  1:审核中  2:审核通过 )")
    private Integer state;

    @ApiModelProperty(value = "备注")
    private String remark;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建日期")
    private Date createTime;

    @ApiModelProperty(value = "当前页码")
    private Integer nowPage;

    @ApiModelProperty(value = "每页展示数量")
    private Integer pageSize;

}
