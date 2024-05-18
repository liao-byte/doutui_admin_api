package com.ruoyi.gomagic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.gomagic.domain.User;
import com.ruoyi.gomagic.domain.UserTask;
import com.ruoyi.gomagic.dto.ReportForms;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-01
 */
public interface UserTaskService extends IService<UserTask> {


    TableDataInfo<UserTask> listPageTask(UserTask userTask, PageQuery pageQuery);

    ReportForms getImageAllNumAndNewAdd(Integer day);

    ReportForms getVideoAllNumAndNewAdd(Integer day);
}
