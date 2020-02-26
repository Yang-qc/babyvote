package com.babyvote.work.controller;


import com.babyvote.common.response.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  个人账户信息前端控制器
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@RestController
@RequestMapping("/user/")
public class TUserWalletController {

    /**
     * 根据id查询用户账户信息
     * @return
     */
    @PostMapping("/get/{id}")
    public Result getAll(){
        return Result.ok();
    }

}

