package com.babyvote.work.service;

import com.babyvote.model.domain.TUserAccount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
public interface TUserAccountService extends IService<TUserAccount> {

    TUserAccount findUserAccountByBorrowId(Integer id);
}
