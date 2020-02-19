package com.babyvote.work.service.impl;

import com.babyvote.model.domain.TBorrow;
import com.babyvote.work.mapper.TBorrowMapper;
import com.babyvote.work.service.TBorrowService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Service
public class TBorrowServiceImpl extends ServiceImpl<TBorrowMapper, TBorrow> implements TBorrowService {

    /**
     *  标的信息管理，分页查询全部或根据id查询
     * @param pageParam
     * @param id
     * @auther 李
     */
    @Override
    public void findAllBorrow(Page<TBorrow> pageParam, Integer id) {
        QueryWrapper<TBorrow> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(id)){
            queryWrapper.eq("id",id);
        }
        //根据创建时间降序
        queryWrapper.orderByDesc("create_time");
        baseMapper.selectPage(pageParam,queryWrapper);
    }
}
