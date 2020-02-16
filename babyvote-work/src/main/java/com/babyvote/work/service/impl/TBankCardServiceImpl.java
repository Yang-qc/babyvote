package com.babyvote.work.service.impl;

import com.babyvote.work.pojo.TBankCard;
import com.babyvote.work.mapper.TBankCardMapper;
import com.babyvote.work.service.TBankCardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  银行卡服务实现类
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Service
public class TBankCardServiceImpl extends ServiceImpl<TBankCardMapper, TBankCard> implements TBankCardService {

    @Override
    public void getByUserId(String UserId) {

    }
}
