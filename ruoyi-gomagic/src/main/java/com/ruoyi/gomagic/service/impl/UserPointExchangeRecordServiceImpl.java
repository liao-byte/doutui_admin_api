package com.ruoyi.gomagic.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.gomagic.domain.UserPointExchangeRecord;
import com.ruoyi.gomagic.mapper.UserPointExchangeRecordMapper;
import com.ruoyi.gomagic.service.UserPointExchangeRecordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 兑换表 服务实现类
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-09
 */
@Service
public class UserPointExchangeRecordServiceImpl extends ServiceImpl<UserPointExchangeRecordMapper, UserPointExchangeRecord> implements UserPointExchangeRecordService {

    @Override
    public TableDataInfo<UserPointExchangeRecord> listPagePointExchange(UserPointExchangeRecord userPointExchangeRecord, PageQuery pageQuery) {
        LambdaQueryWrapper<UserPointExchangeRecord> lqw = new LambdaQueryWrapper<UserPointExchangeRecord>()
            .like(StringUtils.isNotBlank(userPointExchangeRecord.getUserId()),UserPointExchangeRecord::getUserId,userPointExchangeRecord.getUserId())
            .like(StringUtils.isNotBlank(userPointExchangeRecord.getId()),UserPointExchangeRecord::getId,userPointExchangeRecord.getId())
            .orderByDesc(UserPointExchangeRecord::getCreateTime)
            ;
        Page<UserPointExchangeRecord> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }
}
