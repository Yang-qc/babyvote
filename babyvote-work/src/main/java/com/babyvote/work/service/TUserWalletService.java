package com.babyvote.work.service;

import com.babyvote.model.domain.TUserWallet;
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
public interface TUserWalletService extends IService<TUserWallet> {

    /**
     * 根据账号id更新用户余额
     * @param tUserWallet
     * @return
     */
    int updataTUserWallet(TUserWallet tUserWallet);

    /**
     * 根据账号id查询余额等信息
     * @param userId
     * @return
     */
    TUserWallet findByUserId(Integer userId);
}
