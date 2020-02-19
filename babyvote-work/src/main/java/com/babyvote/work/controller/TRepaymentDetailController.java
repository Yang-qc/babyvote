package com.babyvote.work.controller;


import com.babyvote.common.response.Result;
import com.babyvote.common.response.ResultListPage;
import com.babyvote.work.service.TRepaymentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
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
 */
@RestController
@RequestMapping("/work/t-repayment-detail")
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
}

