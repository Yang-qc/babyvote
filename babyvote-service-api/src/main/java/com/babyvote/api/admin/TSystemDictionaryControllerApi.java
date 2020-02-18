package com.babyvote.api.admin;

import com.babyvote.common.request.dictionary.DictionaryRequest;
import com.babyvote.common.response.Result;
import com.babyvote.model.domain.TSystemDictionary;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2020-02-16 14:23
 */
@Api(value = "字典组操作", description = "字典组操作")
public interface TSystemDictionaryControllerApi {

    @ApiOperation(value = "查询全部数据项")
    public Result getAll();

    @ApiOperation(value = "分页全部数据项")
    public Result query(@ApiParam(name = "dictionaryRequest", value = "字典组查询实体") DictionaryRequest dictionaryRequest);

    @ApiOperation(value = "修改数据组")
    public Result update(@ApiParam(name = "TsystemDictionary" ,value = "字典组实体") TSystemDictionary systemDictionary);

    @ApiOperation(value = "添加数据组")
    public Result add(@ApiParam(name = "TsystemDictionary" ,value = "字典组实体") TSystemDictionary systemDictionary);

}
