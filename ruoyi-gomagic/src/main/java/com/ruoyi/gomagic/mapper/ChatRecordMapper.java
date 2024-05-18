package com.ruoyi.gomagic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.gomagic.domain.ChatRecord;
import com.ruoyi.gomagic.dto.EveryDayADD;

import java.util.List;


/**
 * <p>
 * 聊天记录表 Mapper 接口
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-09
 */
public interface ChatRecordMapper extends BaseMapper<ChatRecord> {

    List<EveryDayADD> getAllNumAndNewAdd(Integer day);
}
