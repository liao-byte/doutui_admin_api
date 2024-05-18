package com.ruoyi.web.controller.gomagic;

import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.gomagic.domain.User;
import com.ruoyi.gomagic.domain.UserTask;
import com.ruoyi.gomagic.dto.ReportForms;
import com.ruoyi.gomagic.service.UserTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gomagic/userTask")
@RequiredArgsConstructor
public class UserTaskController {

    private final UserTaskService userTaskService;


    /**
     * 分页查询用户列表
     */
    @GetMapping("/listPageTask")
    public TableDataInfo<UserTask> listPageTask(UserTask userTask, PageQuery pageQuery){
        return userTaskService.listPageTask(userTask,pageQuery);
    }


    /**
     * 删除id状态
     */
    @DeleteMapping("/deleteById/{id}")
    public R<Void> deleteById(@PathVariable("id") String id) {
        UserTask byId = userTaskService.getById(id);
        byId.setIsDelete(1);
        userTaskService.updateById(byId);
        return R.ok();
    }

    /**
     * 更新审核状态
     */
    @PostMapping("/updateAuditStatus")
    public R<Void> updateAuditStatus(@RequestBody UserTask userTask){

        UserTask exits = userTaskService.getById(userTask.getId());
        if (exits ==null){
            return R.fail("数据不存在");
        }
        exits.setAuditStatus(userTask.getAuditStatus());
         userTaskService.updateById(exits);
        return R.ok();
    }
    //获取n日内新增人数和总数
    @GetMapping("/getImageAllNumAndNewAdd")
    public R<ReportForms> getImageAllNumAndNewAdd(@RequestParam Integer day){
        if (day==null){
            day=1;
        }
        return R.ok(userTaskService.getImageAllNumAndNewAdd(day));
    }

    //获取n日内新增人数和总数
    @GetMapping("/getVideoAllNumAndNewAdd")
    public R<ReportForms> getVideoAllNumAndNewAdd(@RequestParam Integer day){
        if (day==null){
            day=1;
        }
        return R.ok(userTaskService.getVideoAllNumAndNewAdd(day));
    }

}
