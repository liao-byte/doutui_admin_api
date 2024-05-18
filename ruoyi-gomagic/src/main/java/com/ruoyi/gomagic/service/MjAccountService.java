package com.ruoyi.gomagic.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.gomagic.domain.MjAccount;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-21
 */
public interface MjAccountService extends IService<MjAccount> {

    TableDataInfo<MjAccount> listPageMjAccount(MjAccount mjAccount, PageQuery pageQuery);

    void synchronizeAccount(String id);

    R<Void> startMjService(String id);

    R<Void> restartMjService(String id);
}
