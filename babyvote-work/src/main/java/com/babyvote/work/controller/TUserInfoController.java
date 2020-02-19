package com.babyvote.work.controller;


import com.babyvote.common.response.Result;
import com.babyvote.common.response.ResultListPage;
import com.babyvote.work.service.TUserInfoService;
import io.swagger.models.auth.In;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/work/t-user-info")
public class TUserInfoController {

    @Autowired
    private TUserInfoService userInfoService;

    /**
     * 根据借款人id查询借款人信息
     * @param
     * @return
     * @auther 李
     */
    @PostMapping("findUserInfo")
    public Result findUserInfo(@RequestParam Integer borrowUserId){
        return Result.ok(new ResultListPage(userInfoService.findById(borrowUserId)));
    }
}

