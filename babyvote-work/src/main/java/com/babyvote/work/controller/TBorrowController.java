package com.babyvote.work.controller;


import com.babyvote.common.response.Result;
import com.babyvote.common.response.ResultListPage;
import com.babyvote.work.pojo.TBorrow;
import com.babyvote.work.service.TBorrowService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@RestController
@RequestMapping("/work/t-borrow")
public class TBorrowController {

    @Autowired
    private TBorrowService tBorrowService;

    /**
     * 标的信息管理，分页查询全部或根据id查询
     * @param id
     * @param pageSize
     * @param nowPage
     * @return
     * @auther 李
     */
    @PostMapping("qurBorrowPage")
    public Result qurBorrowPage(@RequestParam(required = false) Integer id,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "0") Integer nowPage){
        Page<TBorrow> pageParam = new Page<>(nowPage, pageSize);
        tBorrowService.findAllBorrow(pageParam,id);
        long total = pageParam.getTotal();
        List<TBorrow> records = pageParam.getRecords();
        if(!StringUtils.isEmpty(id)){
            return Result.ok(new ResultListPage(records.get(0),total));
        }
        return Result.ok(new ResultListPage(records,total));
    }
}

