package com.ruoyi.gomagic.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.gomagic.domain.User;
import com.ruoyi.gomagic.domain.UserTask;
import com.ruoyi.gomagic.dto.EveryDayADD;
import com.ruoyi.gomagic.dto.ReportForms;
import com.ruoyi.gomagic.mapper.UserTaskMapper;
import com.ruoyi.gomagic.service.UserTaskService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-01
 */
@Service
public class UserTaskServiceImpl extends ServiceImpl<UserTaskMapper, UserTask> implements UserTaskService {

    @Override
    public TableDataInfo<UserTask> listPageTask(UserTask userTask, PageQuery pageQuery) {
        LambdaQueryWrapper<UserTask> lqw = new LambdaQueryWrapper<UserTask>()
            .like(userTask.getId()!=null,UserTask::getId,userTask.getId())
            .like(userTask.getUserId()!=null,UserTask::getUserId,userTask.getUserId())
            .eq(StringUtils.isNotEmpty(userTask.getStatus()),UserTask::getStatus,userTask.getStatus())
            .eq(userTask.getType()!=null,UserTask::getType,userTask.getType())
            .eq(UserTask::getIsDelete,0)
            .eq(userTask.getAuditStatus()!=null,UserTask::getAuditStatus,userTask.getAuditStatus())
            .orderByDesc(UserTask::getCreateTime);
        Page<UserTask> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public ReportForms getImageAllNumAndNewAdd(Integer day) {
        LambdaQueryWrapper<UserTask> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ne(UserTask::getType,12);

        ReportForms reportForms = new ReportForms();
        Long l = baseMapper.selectCount(queryWrapper);
        reportForms.setTotal(l);

        List<EveryDayADD> everyDayADDList = baseMapper.getImageAllNumAndNewAdd(day);

        reportForms.setEveryDayADDList(everyDayADDList);
        return reportForms;
    }

    @Override
    public ReportForms getVideoAllNumAndNewAdd(Integer day) {
        LambdaQueryWrapper<UserTask> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserTask::getType,13);
        ReportForms reportForms = new ReportForms();
        Long l = baseMapper.selectCount(queryWrapper);
        reportForms.setTotal(l);

        List<EveryDayADD> everyDayADDList = baseMapper.getVideoAllNumAndNewAdd(day);

        reportForms.setEveryDayADDList(everyDayADDList);
        return reportForms;
    }
}
