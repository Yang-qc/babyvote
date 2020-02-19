package com.babyvote.work.service;

import com.babyvote.model.domain.TBankCard;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

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

    /**
     * 充值审核失败，银行卡的钱回退
     * @param UserId
     * @return
     * @authere
     */
    int updataTBankCard(Integer UserId,Long myBlance);

}
