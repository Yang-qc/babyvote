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
@ApiModel(value="TBid对象", description="")
public class TBid implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "借款id")
    private String borrowId;

    @ApiModelProperty(value = "借款标题")
    private String borrowTitle;

    @ApiModelProperty(value = "投标金额")
    private Long bidAmount;

    @ApiModelProperty(value = "投标利息")
    private Long bidInterest;

    @ApiModelProperty(value = "年化率")
    private Integer yearRate;

    @ApiModelProperty(value = "借款状态")
    private Integer borrowState;

    @ApiModelProperty(value = "投标人id")
    private String bidUserId;

    @ApiModelProperty(value = "投标人用户名")
    private String bidUsername;

    @ApiModelProperty(value = "投标时间")
    private Date bidTime;

    @ApiModelProperty(value = "创建日期")
    private String createTime;


}
