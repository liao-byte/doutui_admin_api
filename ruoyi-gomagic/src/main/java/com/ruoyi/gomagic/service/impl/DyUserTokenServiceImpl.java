package com.ruoyi.gomagic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.helper.LoginHelper;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.gomagic.domain.DyLoginLog;
import com.ruoyi.gomagic.domain.DyUserToken;
import com.ruoyi.gomagic.domain.User;
import com.ruoyi.gomagic.mapper.DyUserTokenMapper;
import com.ruoyi.gomagic.service.DyUserTokenService;
import org.springframework.stereotype.Service;

@Service
public class DyUserTokenServiceImpl extends ServiceImpl<DyUserTokenMapper, DyUserToken> implements DyUserTokenService {
    @Override
    public TableDataInfo<DyUserToken> getPageUserInfo(DyUserToken dyUserToken, PageQuery pageQuery) {
        LambdaQueryWrapper<DyUserToken> lqw = new LambdaQueryWrapper<DyUserToken>();
        Long userId=LoginHelper.getUserId();
        String username = LoginHelper.getUsername();
        if(!username.equals("admin")) {

            lqw.eq(DyUserToken::getFirstAgentUserId,String.valueOf(userId));
            lqw.or().eq(DyUserToken::getSecondAgentUserId,String.valueOf(userId));

            //lqw.or()
                //.eq(DyUserToken::getFirstAgentUserId, userId);
                //.or()
                //.eq(DyUserToken::getSecondAgentUserId, userId);
        }
        Page<DyUserToken> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public DyUserToken getByDyNumber(String dyNumber) {
        return baseMapper.getByDyNumber(dyNumber);
    }
}
