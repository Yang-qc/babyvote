package com.babyvote.work.service.impl;

import com.babyvote.common.request.dictionary.DictionaryRequest;
import com.babyvote.model.domain.TSystemDictionary;
import com.babyvote.work.mapper.TSystemDictionaryMapper;
import com.babyvote.work.service.TSystemDictionaryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Service
public class TSystemDictionaryServiceImpl extends ServiceImpl<TSystemDictionaryMapper, TSystemDictionary> implements TSystemDictionaryService {

    @Override
    public void getAll(Page<TSystemDictionary> pageParam, DictionaryRequest dictionaryRequest) {
        QueryWrapper<TSystemDictionary> queryWrapper = new QueryWrapper<>();
        String keyword = dictionaryRequest.getKeyword();
        if (!StringUtils.isEmpty(keyword)) {
            queryWrapper.like("name", keyword);
        }
        baseMapper.selectPage(pageParam, queryWrapper);
    }
}
