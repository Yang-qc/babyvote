package com.babyvote.work.service;

import com.babyvote.common.request.TRepaymentDetailQuery;
import com.babyvote.model.domain.TRepaymentDetail;
import com.babyvote.work.pojo.TRepaymentDetailVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 *  还款记录
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
public interface TRepaymentDetailService extends IService<TRepaymentDetail> {

    /**
     * 根据借款id查询还款记录
    * @param id
     * @return
     */
    List<TRepaymentDetailVo> findDetailByBorrowId(Integer id);


    /**
     * 还款明细分页查询
     * @param tRepaymentDetailQuery
     */
    void selectDetailAll(Page<TRepaymentDetail> pageParam, TRepaymentDetailQuery tRepaymentDetailQuery);

    /**
     * 根据id更新收款明细
     * @param repaymentDetail
     * @return
     */
    int updateDetail(TRepaymentDetail repaymentDetail);


}
