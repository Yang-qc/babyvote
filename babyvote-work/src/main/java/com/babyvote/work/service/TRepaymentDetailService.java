package com.babyvote.work.service;

import com.babyvote.work.pojo.TRepaymentDetail;
import com.babyvote.work.pojo.TRepaymentDetailVo;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

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
}
