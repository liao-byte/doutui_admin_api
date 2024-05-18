package com.ruoyi.web.controller.gomagic;


import com.ruoyi.common.core.domain.R;
import com.ruoyi.gomagic.domain.ChatConfig;
import com.ruoyi.gomagic.service.ChatConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/gomagic/chatConfig")
@RequiredArgsConstructor
public class ChatConfigController {

    private final ChatConfigService chatConfigService;

    @GetMapping("/getAllModel")
    public R<?> getAllModel(){
        return chatConfigService.getAllModel();
    }


    @PostMapping("/saveOrUpdateList")
    public R<?> saveOrUpdateList(@RequestBody List<ChatConfig> addOrUpdateList){
        return chatConfigService.saveOrUpdateList(addOrUpdateList);
    }

}

