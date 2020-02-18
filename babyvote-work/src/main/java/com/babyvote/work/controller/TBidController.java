package com.babyvote.work.controller;


import com.babyvote.common.response.Result;
import com.babyvote.common.response.ResultListPage;
import com.babyvote.work.service.TBidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 *  投标人
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@RestController
@RequestMapping("/work/t-bid")
public class TBidController {

    @Autowired
    private TBidService tBidService;

    /**
     * 根据借款id查询投标记录集合
     * @param id
     * @return
     * @auther 李
     */
    @PostMapping("findTBidByborrowId")
    public Result findTBidByborrowId(Integer id){
        return Result.ok(new ResultListPage(tBidService.findTBidByborrowId(id)));
    }
}

