package com.babyvote.work.pojo;

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
@ApiModel(value="TWithdraw对象", description="")
public class TWithdraw implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "提现账户id")
    private String userId;

    @ApiModelProperty(value = "提现金额(单位：分)")
    private Long amount;

    @ApiModelProperty(value = "手续费(单位：分)")
    private Long fee;

    @ApiModelProperty(value = "银行名称")
    private String bankName;

    @ApiModelProperty(value = "开户人姓名")
    private String realname;

    @ApiModelProperty(value = "银行卡号")
    private String cardNumber;

    @ApiModelProperty(value = "支行名称")
    private String branchName;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


}
