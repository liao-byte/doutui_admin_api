package com.ruoyi.gomagic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.gomagic.domain.DyLoginLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DyLoginLogMapper extends BaseMapper<DyLoginLog> {
    DyLoginLog getCityAndTaskid();
    DyLoginLog getByTaskId(String taskId);
    DyLoginLog getLastTask();
}
