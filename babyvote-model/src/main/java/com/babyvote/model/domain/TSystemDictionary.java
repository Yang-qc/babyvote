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
@ApiModel(value="TSystemDictionary对象", description="")
public class TSystemDictionary implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字典组id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "字典组编号")
    private String code;

    @ApiModelProperty(value = "字典组名称")
    private String name;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


}
