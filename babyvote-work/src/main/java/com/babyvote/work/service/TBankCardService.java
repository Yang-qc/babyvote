package com.babyvote.work.service;

import com.babyvote.work.pojo.TBankCard;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
public interface TBankCardService extends IService<TBankCard> {

    /**
     * 根据用户id查询银行卡信息
     * @param UserId
     */
    public void getByUserId(String UserId);
}
