package com.babyvote.work.service;

import com.babyvote.model.domain.TBid;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 *  投标记录
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
public interface TBidService extends IService<TBid> {

    /**
     * 根据借款id查询投标记录集合
     * @return
     * @auther 李
     */
    List<TBid> findTBidByborrowId(Integer id);


}
