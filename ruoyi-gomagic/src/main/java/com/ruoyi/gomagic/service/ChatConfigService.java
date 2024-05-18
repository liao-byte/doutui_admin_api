package com.ruoyi.gomagic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.gomagic.domain.ChatConfig;

import java.util.List;

public interface ChatConfigService extends IService<ChatConfig> {

    R<?> getAllModel();

    R<?> saveOrUpdateList(List<ChatConfig> addOrUpdateList);

}
