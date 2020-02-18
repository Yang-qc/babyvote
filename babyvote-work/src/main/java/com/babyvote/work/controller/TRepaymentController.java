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
public class TRepaymentController implements TRepaymentControllerApi{

    @Autowired
    private TRepaymentService tRepaymentService;

    /**
     * 还款信息分页查询
     *
     * @param tRepaymentQuery
     * @return
     */
    @PostMapping("getByBorrowId")
    @Override
    public Result getByBorrowId(TRepaymentQuery tRepaymentQuery) {
        if (StringUtils.isEmpty(tRepaymentQuery.getNowPage())){
            tRepaymentQuery.setNowPage(1);
            tRepaymentQuery.setPageSize(5);
        }
        Page<TRepayment> pageParam = new Page<>(tRepaymentQuery.getNowPage(), tRepaymentQuery.getPageSize());
        tRepaymentService.getByBorrowId(pageParam, tRepaymentQuery);
        return Result.ok(new ResultListPage(pageParam.getRecords(), pageParam.getPages(), pageParam.getTotal(), pageParam.getCurrent(), pageParam.getSize()));
    }

    /**
     * 还款
     * @param tRepayment
     * @return
     */
    @PostMapping("repay")
    public Result repay(TRepayment tRepayment) {
        System.out.println("获取还款信息id:"+tRepayment.getId()+"\n"+"借款人id:"+tRepayment.getBorrowUserId());
        //进行还款清算
        System.out.println("开始还款清算。。。");
        System.out.println("开始更改还款状态。。。");
        //根据不同待还状态改变还款状态
       if(tRepayment.getState()==1){
            tRepayment.setState(4);
       }else if(tRepayment.getState()==2){
           tRepayment.setState(3);
        }
        tRepaymentService.updateById(tRepayment);
        return Result.ok();
    }


}

