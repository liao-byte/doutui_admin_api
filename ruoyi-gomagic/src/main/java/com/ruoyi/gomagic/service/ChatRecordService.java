package com.ruoyi.gomagic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.gomagic.domain.ChatRecord;
import com.ruoyi.gomagic.dto.ReportForms;


/**
 * <p>
 * 聊天记录表 服务类
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-09
 */
public interface ChatRecordService extends IService<ChatRecord> {

    ReportForms getAllNumAndNewAdd(Integer day);
}
