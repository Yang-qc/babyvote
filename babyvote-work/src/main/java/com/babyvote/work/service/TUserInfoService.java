package com.babyvote.work.service;

import com.babyvote.work.pojo.TUserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.imageio.plugins.common.I18N;
import io.swagger.models.auth.In;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
public interface TUserInfoService extends IService<TUserInfo> {

    /**
     * 根据id查询借款人信息
     * @param id
     * @return
     * @auther 李
     */
    TUserInfo findById(Integer id);
}
