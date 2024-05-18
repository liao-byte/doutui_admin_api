package com.ruoyi.gomagic.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.gomagic.domain.User;
import com.ruoyi.gomagic.dto.EveryDayADD;
import com.ruoyi.gomagic.dto.ReportForms;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户基础表 Mapper 接口
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-03
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


    List<EveryDayADD> getNewAdd(@Param("day") Integer day);
}
