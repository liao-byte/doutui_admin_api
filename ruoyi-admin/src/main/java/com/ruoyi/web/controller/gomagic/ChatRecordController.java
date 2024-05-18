package com.ruoyi.web.controller.gomagic;


import com.ruoyi.common.core.domain.R;
import com.ruoyi.gomagic.dto.ReportForms;
import com.ruoyi.gomagic.service.ChatRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 聊天记录表 前端控制器
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-09
 */
@RestController
@RequestMapping("/gomagic/chatRecord")
@RequiredArgsConstructor
public class ChatRecordController {



    private final ChatRecordService chatRecordService;

    //获取n日内新增人数和总数
    @GetMapping("/getAllNumAndNewAdd")
    public R<ReportForms> getAllNumAndNewAdd(@RequestParam Integer day){
        if (day==null){
            day=1;
        }
        return R.ok(chatRecordService.getAllNumAndNewAdd(day));
    }

}

