package com.ruoyi.gomagic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.gomagic.domain.MjDrawConfig;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-10-23
 */
public interface MjDrawConfigService extends IService<MjDrawConfig> {

    R<?> getAllMjDrawConfig();
}
