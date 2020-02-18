package com.babyvote.api.admin;


import com.babyvote.common.request.dictionary.DictionaryItemRequest;
import com.babyvote.common.request.dictionary.DictionaryRequest;
import com.babyvote.common.response.Result;
import com.babyvote.model.domain.TSystemDictionary;
import com.babyvote.model.domain.TSystemDictionaryItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "字典项操作", description = "字典项操作")
public interface TSystemDictionaryItemControllerApi {

    @ApiOperation(value = "查询全部数据项")
    public Result getAll(@ApiParam(name = "dictionaryRequest", value = "字典项查询实体") DictionaryItemRequest dictionaryItemRequest);

    @ApiOperation(value = "修改数据项")
    public Result update(@ApiParam(name = "TSystemDictionaryItem" ,value = "字典项实体") TSystemDictionaryItem systemDictionary);

    @ApiOperation(value = "添加数据项")
    public Result add(@ApiParam(name = "TSystemDictionaryItem" ,value = "字典项实体") TSystemDictionaryItem systemDictionary);

}
