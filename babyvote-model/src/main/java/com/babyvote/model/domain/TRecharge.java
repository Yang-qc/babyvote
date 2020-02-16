package com.babyvote.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class TRecharge implements Serializable {

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

    @ApiModelProperty(value = "充值日期")
    private Date rechargeTime;

    @ApiModelProperty(value = "审核状态( 0:审核拒绝  1:审核中  2:审核通过 )")
    private Integer state;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建日期")
    private Date createTime;


}
