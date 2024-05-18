package com.ruoyi.gomagic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.gomagic.domain.DyUserToken;

public interface DyUserTokenService extends IService<DyUserToken> {
    TableDataInfo<DyUserToken> getPageUserInfo(DyUserToken dyUserToken, PageQuery pageQuery);
    DyUserToken getByDyNumber(String dyNumber);
}
