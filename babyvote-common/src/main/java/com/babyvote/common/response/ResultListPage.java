package com.babyvote.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 描述:
 *      返回结果并携带分页信息
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2020-01-06 19:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultListPage<T> implements Serializable {
    /**
     * 后台研学基地、研学课程、研学承办机构新增时需要名为 model 的返回值
     */
    public ResultListPage(T model) {
        this.model = model;
    }

    public ResultListPage(T datalist, long allCount) {
        this.datalist = datalist;
        this.allCount = allCount;

    }
    public ResultListPage(T datalist, long allPage, long allCount, long nowPage, long pageSize) {
        this.datalist = datalist;
        this.allPage = allPage;
        this.allCount = allCount;
        this.nowPage = nowPage;
        this.pageSize = pageSize;
    }
    private T model;
    private T datalist;
    private long allPage;
    private long allCount;
    private long nowPage;
    private long pageSize;
}
