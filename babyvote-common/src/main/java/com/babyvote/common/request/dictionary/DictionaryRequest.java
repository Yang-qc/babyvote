package com.babyvote.common.request.dictionary;

import com.babyvote.common.model.request.RequestData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "DictionaryRequest查询对象",description = "字典组查询对象")
public class DictionaryRequest extends RequestData {
    //搜索字段
    @ApiModelProperty(value = "搜索字段")
    private String keyword;
}
