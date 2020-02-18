package com.babyvote.work.service.impl;

import com.babyvote.model.domain.TBid;
import com.babyvote.work.mapper.TBidMapper;
import com.babyvote.work.service.TBidService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Service
public class TBidServiceImpl extends ServiceImpl<TBidMapper, TBid> implements TBidService {

    /**
     * 根据借款id查询投标人集合
     * @param id
     * @return 李
     */
    @Override
    public List<TBid> findTBidByborrowId(Integer id) {
        List<TBid> borrow_id = baseMapper.selectList(new QueryWrapper<TBid>().eq("borrow_id", id));
        for (TBid bid:borrow_id){
            bid.setCreateTime(bid.getCreateTime().substring(0,10));
        }
        return borrow_id;
    }
}
