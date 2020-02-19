package com.babyvote.work.service.impl;

import com.babyvote.model.domain.TBankCard;
import com.babyvote.work.mapper.TBankCardMapper;
import com.babyvote.work.service.TBankCardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  银行卡服务实现类
 * @author 宝贝投项目组
 * @since 2020-02-12
 */
@Service
public class TBankCardServiceImpl extends ServiceImpl<TBankCardMapper, TBankCard> implements TBankCardService {

    @Autowired
    private TBankCardMapper bankCardMapper;

    @Override
    public void getByUserId(String UserId) {

    }

    /**
     * 充值审核失败，银行卡的钱回退
     * @param UserId
     * @param myBlance
     * @return
     * @auther 李
     */
    @Override
    public int updataTBankCard(Integer UserId,Long myBlance) {
        return bankCardMapper.updateByUserId(UserId, myBlance);
    }
}
