package com.ruoyi.gomagic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.gomagic.domain.ChatConfig;
import com.ruoyi.gomagic.mapper.ChatConfigMapper;
import com.ruoyi.gomagic.service.ChatConfigService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-10-23
 */
@Service
public class ChatConfigServiceImpl extends ServiceImpl<ChatConfigMapper, ChatConfig> implements ChatConfigService {

    @Override
    public R<?> getAllModel() {
        List<ChatConfig> chatConfigs = this.baseMapper.selectList(new LambdaQueryWrapper<>());
        return R.ok(chatConfigs);
    }

    @Override
    public R<?> saveOrUpdateList(List<ChatConfig> addOrUpdateList) {
        boolean b = this.saveOrUpdateBatch(addOrUpdateList);
        return b?R.ok():R.fail();
    }
}
