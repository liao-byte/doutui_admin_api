package com.ruoyi.web.controller.gomagic;


import com.ruoyi.common.core.domain.R;
import com.ruoyi.gomagic.domain.MjDrawConfig;
import com.ruoyi.gomagic.dto.SaveOrUpdateDrawConfigDTO;
import com.ruoyi.gomagic.service.impl.MjDrawConfigServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-10-23
 */
@RestController
@RequestMapping("/gomagic/mjDrawConfig")
@RequiredArgsConstructor
@Slf4j
public class MjDrawConfigController {

    private final MjDrawConfigServiceImpl mjDrawConfigService;


    @PostMapping("/getAllMjDrawConfig")
    public R<?> getAllMjDrawConfig(){
        return mjDrawConfigService.getAllMjDrawConfig();
    }


    @PostMapping("/saveOrUpdateConfig")
    public R<?> saveOrUpdateConfig(@RequestBody List<MjDrawConfig> mjDrawConfigs){
        log.info("保存或更新为:{}",mjDrawConfigs);
        mjDrawConfigService.saveOrUpdateBatch(mjDrawConfigs);
        return R.ok();
    }
}

