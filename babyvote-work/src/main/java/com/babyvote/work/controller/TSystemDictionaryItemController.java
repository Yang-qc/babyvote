package com.babyvote.work.controller;


import com.babyvote.api.admin.TSystemDictionaryItemControllerApi;
import com.babyvote.common.constants.ResultCodeEnum;
import com.babyvote.common.exception.ExceptionThrowOut;
import com.babyvote.common.request.dictionary.DictionaryItemRequest;
import com.babyvote.common.response.Result;
import com.babyvote.common.response.ResultListPage;
import com.babyvote.model.domain.TSystemDictionaryItem;
import com.babyvote.work.service.TSystemDictionaryItemService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Slf4j
@RestController
@RequestMapping("/system/dictionaryItem")
public class TSystemDictionaryItemController implements TSystemDictionaryItemControllerApi {

    @Autowired
    private TSystemDictionaryItemService tSystemDictionaryItemService;

    @Override
    @PostMapping("getAll")
    public Result getAll(DictionaryItemRequest dictionaryRequest) {
        if (StringUtils.isEmpty(dictionaryRequest.getNowPage())) {
            dictionaryRequest.setNowPage(0L);
            dictionaryRequest.setPageSize(5L);
        }
        Page<TSystemDictionaryItem> pageParam = new Page<>(dictionaryRequest.getNowPage(), dictionaryRequest.getPageSize());
        tSystemDictionaryItemService.getAll(pageParam, dictionaryRequest);
        return Result.ok(new ResultListPage(pageParam.getRecords(), pageParam.getPages(), pageParam.getTotal(), dictionaryRequest.getNowPage(), dictionaryRequest.getPageSize()));
    }
    /**
     * @描述 修改字典项
     * @创建人  周
     */
    @Override
    @PostMapping("update")
    public Result update(TSystemDictionaryItem tSystemDictionaryItem) {
        try {
            tSystemDictionaryItemService.updateById(tSystemDictionaryItem);
            return Result.ok();
        }catch (Exception e){
            ExceptionThrowOut.cast(ResultCodeEnum.DATA_DICTIONARY_ENTRY_MODIFICATION_FAILED);
            log.error("修改数据字典项失败！具体错误：{}",e.getMessage());
            return Result.error();
        }
    }
    /**
     * @描述 添加字典项
     * @创建人  周
     */
    @Override
    @PostMapping("add")
    public Result add(TSystemDictionaryItem tSystemDictionaryItem) {
        try {
            tSystemDictionaryItemService.save(tSystemDictionaryItem);
            log.debug("添加数据字典项成功！");
            return Result.ok();
        }catch (Exception e){
            ExceptionThrowOut.cast(ResultCodeEnum.DATA_DICTIONARY_ENTRY_ADD_TO_FAILED);
            log.error("添加数据字典项失败！具体错误：{}",e.getMessage());
            return Result.error();
        }
    }
}

