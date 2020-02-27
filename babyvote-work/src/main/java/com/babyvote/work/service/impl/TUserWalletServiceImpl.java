package com.babyvote.work.service.impl;

        import com.babyvote.model.domain.TUserWallet;
        import com.babyvote.work.mapper.TUserWalletMapper;
        import com.babyvote.work.service.TUserWalletService;
        import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
        import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
        import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Service
public class TUserWalletServiceImpl extends ServiceImpl<TUserWalletMapper, TUserWallet> implements TUserWalletService {

    /**
     * 根据账号id更新用户余额
     *
     * @param tUserWallet
     * @return
     */
    @Override
    public int updataTUserWallet(TUserWallet tUserWallet) {
        return baseMapper.updateById(tUserWallet);
    }

    /**
     * 根据账号id查询余额等信息
     *
     * @param userId
     * @return
     */
    @Override
    public TUserWallet findByUserId(Integer userId) {
        return baseMapper.selectById(userId);
    }

    /**
     * 根据账号id查询用户钱包信息
     * @param userId
     * @return
     */
    @Override
    public TUserWallet findByUserId(String userId) {
        return baseMapper.findByUserId(userId);
    }
}
