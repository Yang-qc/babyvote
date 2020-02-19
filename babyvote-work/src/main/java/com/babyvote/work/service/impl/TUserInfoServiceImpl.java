package com.babyvote.work.service.impl;

import com.babyvote.model.domain.TUserInfo;
import com.babyvote.work.mapper.TUserInfoMapper;
import com.babyvote.work.service.TSystemDictionaryItemService;
import com.babyvote.work.service.TUserAccountService;
import com.babyvote.work.service.TUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TUserInfoServiceImpl extends ServiceImpl<TUserInfoMapper, TUserInfo> implements TUserInfoService {

    @Autowired
    private TSystemDictionaryItemService itemService;

    @Autowired
    private TUserAccountService userAccountService;
    /**
     * 根据id查询借款人信息
     * @param id
     * @return
     * @auther  李
     */
    @Override
    public TUserInfo findById(Integer id) {
        TUserInfo tUserInfo = baseMapper.selectById(id);
        //收入
        tUserInfo.setIncomeLevelId(itemService.findItemByid(tUserInfo.getIncomeLevelId()).getValue());
        //婚姻状况
        tUserInfo.setMarriageId(itemService.findItemByid(tUserInfo.getMarriageId()).getValue());
        //教育背景
        tUserInfo.setEduBackgroundId(itemService.findItemByid(tUserInfo.getEduBackgroundId()).getValue());
        //住房情况
        tUserInfo.setHouseConditionId(itemService.findItemByid(tUserInfo.getHouseConditionId()).getValue());
        //创建时间
        tUserInfo.setCreateTime(userAccountService.findUserAccountByBorrowId(id).getCreateTime().substring(0,10));
        return tUserInfo;
    }
}
