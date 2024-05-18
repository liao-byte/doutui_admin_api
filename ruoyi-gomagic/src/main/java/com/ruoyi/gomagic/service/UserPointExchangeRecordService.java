package com.ruoyi.gomagic.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.gomagic.domain.UserPointExchangeRecord;

/**
 * <p>
 * 兑换表 服务类
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-09
 */
public interface UserPointExchangeRecordService extends IService<UserPointExchangeRecord> {


    TableDataInfo<UserPointExchangeRecord> listPagePointExchange(UserPointExchangeRecord userPointExchangeRecord, PageQuery pageQuery);
}
