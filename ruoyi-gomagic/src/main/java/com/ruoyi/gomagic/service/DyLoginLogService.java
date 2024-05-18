package com.ruoyi.gomagic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.gomagic.domain.DyLoginLog;

public interface DyLoginLogService extends IService<DyLoginLog> {
    DyLoginLog getCityAndTaskid();
    DyLoginLog getByTaskId(String taskId);
    DyLoginLog getLastTask();
}
