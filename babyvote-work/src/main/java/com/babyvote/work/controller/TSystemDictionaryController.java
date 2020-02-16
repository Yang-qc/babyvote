package com.babyvote.work.controller;


import com.babyvote.api.admin.TSystemDictionaryControllerApi;
import com.babyvote.common.constants.ResultCodeEnum;
import com.babyvote.common.exception.ExceptionThrowOut;
import com.babyvote.common.model.response.ResultCode;
import com.babyvote.common.request.dictionary.DictionaryRequest;
import com.babyvote.common.response.Result;
import com.babyvote.common.response.ResultListPage;
import com.babyvote.model.domain.TSystemDictionary;
import com.babyvote.work.service.TSystemDictionaryService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Slf4j
@RestController
@RequestMapping("/system/dictionary/")
public class TSystemDictionaryController implements TSystemDictionaryControllerApi {

    @Autowired
    private TSystemDictionaryService tSystemDictionaryService;

    /**
     * @描述 查询数据字典，可根据字典名称模糊查询
     * @参数注释： 封装查询对象
     * @创建人 周
     */
    @Override
    @PostMapping("getAll")
    public Result getAll(DictionaryRequest dictionaryRequest) {
        if (StringUtils.isEmpty(dictionaryRequest.getNowPage())) {
            dictionaryRequest.setNowPage(0L);
            dictionaryRequest.setPageSize(5L);
        }
        Page<TSystemDictionary> pageParam = new Page<>(dictionaryRequest.getNowPage(), dictionaryRequest.getPageSize());
        tSystemDictionaryService.getAll(pageParam, dictionaryRequest);
        return Result.ok(new ResultListPage(pageParam.getRecords(), pageParam.getPages(), pageParam.getTotal(), dictionaryRequest.getNowPage(), dictionaryRequest.getPageSize()));
    }
    /**
     * @描述 修改字典
     * @创建人  周
     */
    @Override
    @PostMapping("update")
    public Result update(TSystemDictionary systemDictionary) {
        try {
            tSystemDictionaryService.updateById(systemDictionary);
            return Result.ok();
        }catch (Exception e){
            ExceptionThrowOut.cast(ResultCodeEnum.DATA_DICTIONARY_MODIFICATION_FAILED);
            log.error("修改数据字典失败！具体错误：{}",e.getMessage());
            return Result.error();
        }
    }
    /**
     * @描述 添加字典
     * @创建人  周
     */
    @Override
    @PostMapping("add")
    public Result add(TSystemDictionary systemDictionary) {
        try {
            tSystemDictionaryService.save(systemDictionary);
            return Result.ok();
        }catch (Exception e){
            ExceptionThrowOut.cast(ResultCodeEnum.DATA_DICTIONARY_ADD_TO_FAILED);
            log.error("添加数据字典失败！具体错误：{}",e.getMessage());
            return Result.error();
        }
    }
}

