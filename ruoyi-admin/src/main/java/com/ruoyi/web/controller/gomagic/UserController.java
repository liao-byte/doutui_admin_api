package com.ruoyi.web.controller.gomagic;

import cn.hutool.http.HttpUtil;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.gomagic.domain.User;
import com.ruoyi.gomagic.dto.ReportForms;
import com.ruoyi.gomagic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/gomagic/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    /**
     * 分页查询用户列表
     */
    @GetMapping("/getPageUserInfo")
    public TableDataInfo<User> getPageUserInfo(User user, PageQuery pageQuery){
        return userService.getPageUserInfo(user,pageQuery);
    }

    @GetMapping("/updateBanStatus")
    public R<Void> updateBanStatus(@RequestParam("id") String id ){
        User user = this.userService.getById(id);
        if (user == null) {
            return R.fail("用户信息不存在");
        }
        if (user.getBan() == 0){
            //通知第三方进行下线操作
            toNoticeDown(user.getId());
        }
        user.setBan(user.getBan() == 0 ? 1 : 0);
        userService.updateById(user);
        //调用第三方进行下线操作
        return R.ok();
    }


    //获取n日内新增人数和总数
    @GetMapping("/getAllNumAndNewAdd")
    public R<ReportForms> getAllNumAndNewAdd(@RequestParam Integer day){
        if (day==null){
            day=1;
        }
       return R.ok(userService.getAllNumAndNewAdd(day));
    }


    private void toNoticeDown(String id){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpUtil.get("http://localhost:8091/user/logOutById?id="+id);
                }catch (Exception e){

                }
            }
        }).start();
    }



}
