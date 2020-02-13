package com.babyvote.work.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.babyvote.common.response.Result;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@RestController
@RequestMapping("/finance/repayment/")
public class TRepaymentController {

    @PostMapping("getByBorrowId")
    public Result getByBorrowId(){
        return Result.ok();
    }
    /**
     * 还款
     * @return
     */
    @PostMapping("repay")
    public Result repay(){

        return Result.ok();
    }



}

