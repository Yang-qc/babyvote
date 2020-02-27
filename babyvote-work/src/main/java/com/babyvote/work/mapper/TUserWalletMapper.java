package com.babyvote.work.mapper;

import com.babyvote.model.domain.TUserWallet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
public interface TUserWalletMapper extends BaseMapper<TUserWallet> {
    /**
     * 根据账号id查询余额等信息
     * @param userId
     * @return
     */
    TUserWallet findByUserId(@Param("userId")String userId);
}
