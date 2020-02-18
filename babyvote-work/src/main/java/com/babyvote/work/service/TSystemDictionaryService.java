package com.babyvote.work.service;

import com.babyvote.common.request.dictionary.DictionaryRequest;
import com.babyvote.model.domain.TSystemDictionary;
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
public interface TSystemDictionaryService extends IService<TSystemDictionary> {

    void getAll(Page<TSystemDictionary> pageParam, DictionaryRequest dictionaryRequest);
}
