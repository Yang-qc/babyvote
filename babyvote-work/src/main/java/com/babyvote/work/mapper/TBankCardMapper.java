package com.babyvote.work.mapper;

import com.babyvote.model.domain.TBankCard;
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
public interface TBankCardMapper extends BaseMapper<TBankCard> {

    /**
     * 充值审核失败后，银行卡的钱回退，余额增加
     * @param UserId
     * @param myBalance
     * @return
     * @auther 李
     */
    int updateByUserId(@Param("UserId") Integer UserId,@Param("myBalance") Long myBalance);
}
