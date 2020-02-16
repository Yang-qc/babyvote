package com.babyvote.common.request.dictionary;

import com.babyvote.common.model.request.RequestData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "DictionaryRequestItem查询对象",description = "字典项查询对象")
public class DictionaryItemRequest extends RequestData {
    //搜索字段
    @ApiModelProperty(value = "搜索字段")
    private String keyword;
    //搜索字段
    @ApiModelProperty(value = "字典项父d")
    private String parentId;
}
