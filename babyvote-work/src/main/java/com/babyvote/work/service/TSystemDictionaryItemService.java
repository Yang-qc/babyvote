package com.babyvote.work.service;

import com.babyvote.common.request.dictionary.DictionaryItemRequest;
import com.babyvote.model.domain.TSystemDictionary;
import com.babyvote.model.domain.TSystemDictionaryItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
public interface TSystemDictionaryItemService extends IService<TSystemDictionaryItem> {

    void getAll(Page<TSystemDictionaryItem> pageParam, DictionaryItemRequest dictionaryRequest);
}
