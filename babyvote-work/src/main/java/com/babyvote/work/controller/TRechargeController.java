package com.babyvote.work.controller;


import com.babyvote.common.response.Result;
import com.babyvote.common.response.ResultListPage;
import com.babyvote.model.domain.TRecharge;
import com.babyvote.work.pojo.RequestParam;
import com.babyvote.work.service.TRechargeService;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/system/recharge")
public class TRechargeController {

    @Autowired
    private TRechargeService rechargeService;

    /**
     *  根据时间和状态查询充值数据
     * @param param
     * @auther 李
     */
    @PostMapping("findRecharge")
    public Result findRecharge(@RequestBody RequestParam param){
        Page<TRecharge> page = new Page<>(param.getNowPage(), param.getPageSize());
        rechargeService.findByTimeAndState(page,param);
        return Result.ok(new ResultListPage(page.getRecords(),page.getTotal()));
    }

    /**
     * 充值审批，
     * 审核成功——>用户余额增加——>银行卡余额减少——>生成一条线上充值账户流水；
     * 审核失败——>银行卡的钱回退
     * @param tRecharge
     * @return
     * @auther 李
     */
    @PostMapping("auditTRecharge")
    public Result auditTRecharge(@RequestBody TRecharge tRecharge){
        int i = rechargeService.auditTRecharge(tRecharge);
        if(i>1){//审核成功
            return Result.ok();
        }
        return Result.error();//失败
    }
}

