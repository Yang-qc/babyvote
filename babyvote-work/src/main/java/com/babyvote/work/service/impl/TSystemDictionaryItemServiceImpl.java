package com.babyvote.work.service.impl;

import com.babyvote.common.request.dictionary.DictionaryItemRequest;
import com.babyvote.model.domain.TSystemDictionary;
import com.babyvote.model.domain.TSystemDictionaryItem;
import com.babyvote.work.mapper.TSystemDictionaryItemMapper;
import com.babyvote.work.service.TSystemDictionaryItemService;
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
public class TSystemDictionaryItemServiceImpl extends ServiceImpl<TSystemDictionaryItemMapper, TSystemDictionaryItem> implements TSystemDictionaryItemService {

    @Override
    public void getAll(Page<TSystemDictionaryItem> pageParam, DictionaryItemRequest dictionaryRequest) {
        QueryWrapper<TSystemDictionaryItem> queryWrapper = new QueryWrapper<>();
        String keyword = dictionaryRequest.getKeyword();
        String parentId = dictionaryRequest.getParentId();
        // 根据时间排序
        queryWrapper.orderByDesc("create_time");
        if (StringUtils.isNotBlank(parentId)) {
            queryWrapper.eq("parent_id", parentId);
        }
        if (StringUtils.isNotBlank(keyword)) {
            queryWrapper.like("value", keyword);
        }
        baseMapper.selectPage(pageParam, queryWrapper);
    }
}
