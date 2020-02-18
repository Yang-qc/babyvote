package com.babyvote.work.service.impl;

import com.babyvote.work.pojo.TUserAccount;
import com.babyvote.work.mapper.TUserAccountMapper;
import com.babyvote.work.service.TUserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Service
public class TUserAccountServiceImpl extends ServiceImpl<TUserAccountMapper, TUserAccount> implements TUserAccountService {

    @Override
    public TUserAccount findUserAccountByBorrowId(Integer id) {
        return baseMapper.selectById(id);
    }
}
