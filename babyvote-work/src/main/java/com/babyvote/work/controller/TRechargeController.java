package com.babyvote.work.controller;


import com.babyvote.common.request.TRechargeQuery;
import com.babyvote.common.response.Result;
import com.babyvote.common.response.ResultListPage;
import com.babyvote.model.domain.TRecharge;
import com.babyvote.work.service.TRechargeService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  充值审核接口
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@RestController
@RequestMapping("/system/recharge/")
public class TRechargeController {

    @Autowired
    private TRechargeService tRechargeService;

    @PostMapping("add")
    public Result add(TRecharge tRecharge){
        System.out.println("开始进行充值。。。开始钱包清算。。。");
        //默认充值状态为1审核中，后台进行审核后更改
        tRecharge.setState(1);
        tRechargeService.save(tRecharge);
        return Result.ok();
    }

    @PostMapping("query")
    public Result query(TRechargeQuery tRechargeQuery){
        if (StringUtils.isEmpty(tRechargeQuery.getNowPage())){
            tRechargeQuery.setNowPage(1);
            tRechargeQuery.setPageSize(5);
        }
        Page<TRecharge> pageParam = new Page<>(tRechargeQuery.getNowPage(), tRechargeQuery.getPageSize());
        tRechargeService.selectAll(pageParam, tRechargeQuery);
        return Result.ok(new ResultListPage(pageParam.getRecords(), pageParam.getPages(), pageParam.getTotal(), pageParam.getCurrent(), pageParam.getSize()));
    }


}

