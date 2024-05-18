package com.ruoyi.gomagic.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.gomagic.domain.UserTask;
import com.ruoyi.gomagic.dto.EveryDayADD;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-01
 */
@Mapper
public interface UserTaskMapper extends BaseMapper<UserTask> {

    List<EveryDayADD> getImageAllNumAndNewAdd(Integer day);

    List<EveryDayADD> getVideoAllNumAndNewAdd(Integer day);
}
