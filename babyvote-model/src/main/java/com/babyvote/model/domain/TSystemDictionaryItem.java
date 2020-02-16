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
@ApiModel(value="TSystemDictionaryItem对象", description="")
public class TSystemDictionaryItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字典项id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父id")
    private Integer parentId;

    @ApiModelProperty(value = "字典项值")
    private String value;

    @ApiModelProperty(value = "排序号(正序)")
    private Integer orderNo;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


}
