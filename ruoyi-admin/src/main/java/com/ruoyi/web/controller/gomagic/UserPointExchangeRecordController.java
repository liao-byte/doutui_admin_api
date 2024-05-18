package com.ruoyi.web.controller.gomagic;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.gomagic.domain.UserPointExchangeRecord;
import com.ruoyi.gomagic.mapper.UserPointExchangeRecordMapper;
import com.ruoyi.gomagic.service.UserPointExchangeRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gomagic/pointExchange")
@RequiredArgsConstructor
public class UserPointExchangeRecordController extends BaseController {

    private final UserPointExchangeRecordService userPointExchangeRecordService;

    //分页查询
    @GetMapping("/listPagePointExchange")
    public TableDataInfo<UserPointExchangeRecord> listPagePointExchange(UserPointExchangeRecord userPointExchangeRecord, PageQuery pageQuery){
        return userPointExchangeRecordService.listPagePointExchange(userPointExchangeRecord,  pageQuery);
    }


    //添加对话码
    @PostMapping("/addPointExchange")
    public R<Void> addPointExchange(@RequestBody UserPointExchangeRecord userPointExchangeRecord){
        userPointExchangeRecord.setCreateTime(System.currentTimeMillis());
        userPointExchangeRecord.setExchangeType("1");
        userPointExchangeRecord.setIsExchange(false);
        userPointExchangeRecordService.save(userPointExchangeRecord);
        //TODO 发布事件通知人


        return toAjax(true);
    }

    // 删除

    @DeleteMapping("/deletePointExchange/{id}")
    public R<Void> deletePointExchange(@PathVariable("id") String id){
        userPointExchangeRecordService.removeById(id);
        return toAjax(true);
    }
}
