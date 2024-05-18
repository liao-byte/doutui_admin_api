package com.ruoyi.gomagic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.gomagic.domain.MjDrawConfig;
import com.ruoyi.gomagic.mapper.MjDrawConfigMapper;
import com.ruoyi.gomagic.service.MjDrawConfigService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-10-23
 */
@Service
public class MjDrawConfigServiceImpl extends ServiceImpl<MjDrawConfigMapper, MjDrawConfig> implements MjDrawConfigService {

    @Override
    public R<?> getAllMjDrawConfig() {
        List<MjDrawConfig> list = this.list();
        Map<String, MjDrawConfig> collect = list.stream().collect(Collectors.toMap(MjDrawConfig::getName, MjDrawConfig -> MjDrawConfig));
        return R.ok(collect);
    }
}
