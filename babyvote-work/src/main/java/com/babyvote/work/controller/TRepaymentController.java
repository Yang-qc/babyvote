package com.babyvote.work.controller;


import com.babyvote.api.pc.TRepaymentControllerApi;
import com.babyvote.common.request.TRepaymentQuery;
import com.babyvote.common.response.ResultListPage;
import com.babyvote.model.domain.TRepayment;
import com.babyvote.work.service.TRepaymentService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.babyvote.common.response.Result;

import java.util.List;

/**
 * 还款控制器
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@RestController
@RequestMapping("/finance/repayment/")
public class TRepaymentController implements TRepaymentControllerApi {

    @Autowired
    private TRepaymentService tRepaymentService;

    /**
     * 还款信息分页查询
     * @param tRepaymentQuery
     * @return
     * @auther 杨
     */
    @PostMapping("getByBorrowId")
    @Override
    public Result getByBorrowId(TRepaymentQuery tRepaymentQuery) {
        Page<TRepayment> pageParam = new Page<>(tRepaymentQuery.getNowPage(), tRepaymentQuery.getPageSize());
        tRepaymentService.getByBorrowId(pageParam, tRepaymentQuery);
        return Result.ok(new ResultListPage(pageParam.getRecords(), pageParam.getPages(), pageParam.getTotal(), pageParam.getCurrent(), pageParam.getSize()));
    }

    /**
     * 还款
     * @return
     * @auther 杨
     */
    @PostMapping("repay")
    public Result repay(@RequestParam("id") String id, @RequestParam("userId") String userId) {
        tRepaymentService.repay(id, userId);
        return Result.ok();
    }
}

