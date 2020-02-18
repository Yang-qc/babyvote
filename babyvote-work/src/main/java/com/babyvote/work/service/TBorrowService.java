package com.babyvote.work.service;


import com.babyvote.model.domain.TBorrow;
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
public interface TBorrowService extends IService<TBorrow> {

    /**
     * 标的信息管理，分页查询全部或根据id查询
     * @param id
     * @return
     * @auther 李
     */
    void findAllBorrow(Page<TBorrow> pageParam, Integer id);
}
