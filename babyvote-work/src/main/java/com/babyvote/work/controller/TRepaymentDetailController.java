package com.babyvote.work.controller;


import com.babyvote.common.request.TRepaymentDetailQuery;
import com.babyvote.common.response.Result;
import com.babyvote.common.response.ResultListPage;
import com.babyvote.model.domain.TRepayment;
import com.babyvote.model.domain.TRepaymentDetail;
import com.babyvote.work.pojo.TRepaymentDetailVo;
import com.babyvote.work.service.TRepaymentDetailService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 *
 * /work/t-repayment-detail
 */
@RestController
@RequestMapping("/finance/repayment/detail/")
public class TRepaymentDetailController {

    @Autowired
    private TRepaymentDetailService detailService;

    /**
     * 根据借款id查询还款记录
     * @param id
     * @return
     * @auther 李
     */
    @PostMapping("findDetailByBorrowId")
    public Result findDetailByBorrowId(Integer id){
        return Result.ok(new ResultListPage(detailService.findDetailByBorrowId(id)));
    }

    @PostMapping("selectDetailAll")
    public Result selectDetailAll(TRepaymentDetailQuery tRepaymentDetailQuery){
        if (StringUtils.isEmpty(tRepaymentDetailQuery.getNowPage())) {
            tRepaymentDetailQuery.setNowPage(1);
            tRepaymentDetailQuery.setPageSize(5);
        }
        Page<TRepaymentDetail> pageParam = new Page<>(tRepaymentDetailQuery.getNowPage(), tRepaymentDetailQuery.getPageSize());
        detailService.selectDetailAll(pageParam, tRepaymentDetailQuery);
        return Result.ok(new ResultListPage(pageParam.getRecords(), pageParam.getPages(), pageParam.getTotal(), pageParam.getCurrent(), pageParam.getSize()));
    }
}

