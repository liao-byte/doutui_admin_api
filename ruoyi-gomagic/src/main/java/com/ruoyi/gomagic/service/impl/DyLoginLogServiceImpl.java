package com.ruoyi.gomagic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.gomagic.domain.DyLoginLog;
import com.ruoyi.gomagic.domain.User;
import com.ruoyi.gomagic.dto.ReportForms;
import com.ruoyi.gomagic.mapper.DyLoginLogMapper;
import com.ruoyi.gomagic.service.DyLoginLogService;
import org.springframework.stereotype.Service;

@Service
public class DyLoginLogServiceImpl extends ServiceImpl<DyLoginLogMapper, DyLoginLog> implements DyLoginLogService{
    @Override
    public DyLoginLog getCityAndTaskid() {
        return baseMapper.getCityAndTaskid();
    }
    @Override
    public DyLoginLog getByTaskId(String taskId) {
        return baseMapper.getByTaskId(taskId);
    }
    @Override
    public DyLoginLog getLastTask() {
        return baseMapper.getLastTask();
    }
}
