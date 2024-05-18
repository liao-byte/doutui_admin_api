package com.ruoyi.gomagic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.gomagic.domain.ChatRecord;
import com.ruoyi.gomagic.dto.ReportForms;
import com.ruoyi.gomagic.mapper.ChatRecordMapper;
import com.ruoyi.gomagic.service.ChatRecordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * <p>
 * 聊天记录表 服务实现类
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-09
 */
@Service
public class ChatRecordServiceImpl extends ServiceImpl<ChatRecordMapper, ChatRecord> implements ChatRecordService {


    @Override
    public ReportForms getAllNumAndNewAdd(Integer day) {
        ReportForms reportForms = new ReportForms();
        Long l = baseMapper.selectCount(new LambdaQueryWrapper<>());
        reportForms.setTotal(l);
        reportForms.setEveryDayADDList(baseMapper.getAllNumAndNewAdd(day));
        return reportForms;
    }
}
