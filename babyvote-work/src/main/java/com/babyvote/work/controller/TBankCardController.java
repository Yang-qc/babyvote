package com.babyvote.work.controller;


import com.babyvote.common.response.Result;
import com.babyvote.work.pojo.TBankCard;
import com.babyvote.work.service.TBankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *银行卡控制器
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@RestController
@RequestMapping("/user/bankcard")
public class  TBankCardController {

    @Autowired
    private TBankCardService tBankCardService;
    /**
     * 绑定银行卡信息
     * @param tBankCard
     * @return
     */
    @PostMapping("add")
    public Result add(TBankCard tBankCard){
        System.out.println("获取用户信息："+tBankCard);
        //绑定银行卡默认赠送体验价10000
        tBankCard.setBalance((long)10000);
        tBankCardService.save(tBankCard);
        return Result.ok();
    }

    /**
     * 获取银行卡信息
     * @param accountId
     * @return
     */
    @PostMapping("get/{accountId}")
    public Result getBankInfo(@PathVariable String accountId){
        System.out.println("获取银行卡信息");
//        tBankCardService.getByUserId(accountId);
        return Result.ok();

    }
}

