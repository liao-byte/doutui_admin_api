package com.ruoyi.web.controller.taskmag;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.hutool.http.HttpUtil;
import com.google.api.client.util.SecurityUtils;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.domain.entity.SysDictType;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.helper.LoginHelper;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.gomagic.domain.*;
import com.ruoyi.gomagic.domain.Package;
import com.ruoyi.gomagic.dto.ReportForms;
import com.ruoyi.gomagic.service.DyLoginLogService;
import com.ruoyi.gomagic.service.DyUserTokenService;
import com.ruoyi.system.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.system.service.SysLoginService;
import com.ruoyi.system.service.ISysUserService;

import java.math.BigDecimal;
import java.util.Map;

@Slf4j
@RequestMapping("/dyhelp/dymag")
@RestController
@RequiredArgsConstructor
public class DyLoginLogController {
    private final ISysUserService userService;
    private final DyLoginLogService dyLoginLogService;
    private final DyUserTokenService dyUserTokenService;

    /**
     * 初始化登录任务
     */
    @SaIgnore
    @PostMapping("/initLoginLog")
    public R<DyLoginLog> initLoginLog(@RequestBody DyLoginLog dyLoginLog){
        Long userId =  LoginHelper.getUserId();
        SysUser user =  userService.selectUserById(userId);
        if(user==null)
            return R.fail("用户不存在,UserId:"+userId);

        DyLoginLog temp = dyLoginLogService.getLastTask();
        if(temp==null)
            dyLoginLog.setTaskId(String.valueOf(1));
        else
            dyLoginLog.setTaskId(String.valueOf( Integer.valueOf(temp.getTaskId())+1));
        dyLoginLog.setCreateTime(System.currentTimeMillis());
        if(StringUtils.isNotBlank(user.getParentUserId()) && !user.getParentUserId().equals("0")) {
            dyLoginLog.setFirstAgentUserId(user.getParentUserId());
            dyLoginLog.setSecondAgentUserId(String.valueOf(user.getUserId()));
        }else{
            dyLoginLog.setFirstAgentUserId(String.valueOf(user.getUserId()));
        }
        dyLoginLog.setStatus(0);
        dyLoginLogService.save(dyLoginLog);
        return R.ok("操作成功",dyLoginLog);
    }

    /**
     * 获取下一个登录任务
     */
    @SaIgnore
    @GetMapping("/getCityAndTaskid")
    public R<DyLoginLog> getCityAndTaskid(){
        DyLoginLog dyLoginLog = dyLoginLogService.getCityAndTaskid();
        if(dyLoginLog==null)
            return R.fail("暂无要处理");
        dyLoginLog.setStatus(1);
        dyLoginLogService.updateById(dyLoginLog);
        return R.ok(dyLoginLog);
    }


    /**
     * 更新登录二维码
     */
    @SaIgnore
    @PostMapping("/updataQrcode")
    public R<DyLoginLog> updataQrcode(@Validated @RequestBody DyLoginLog dyLoginLog) {
        DyLoginLog loginLog = dyLoginLogService.getByTaskId(dyLoginLog.getTaskId());
        if(loginLog == null)
            return R.fail("任务Id不存在，Id:"+dyLoginLog.getTaskId());
        loginLog.setQrcode(dyLoginLog.getQrcode());
        loginLog.setGenerateTime(System.currentTimeMillis());
        loginLog.setStatus(1);
        dyLoginLogService.updateById(loginLog);
        return R.ok();
    }

    /**
     * 登录成功，更新登录日志及保存登录身份
     */
    @SaIgnore
    @PostMapping("/addDyLoginlog")
    public R<Void> addDyLoginlog(@RequestBody DyLoginLog dyLoginLog){
        DyLoginLog loginLog = dyLoginLogService.getByTaskId(dyLoginLog.getTaskId());
        if(loginLog == null)
            return R.fail("任务Id不存在，Id:"+dyLoginLog.getTaskId());
        loginLog.setDyNumber(dyLoginLog.getDyNumber());
        loginLog.setNickname(dyLoginLog.getNickname());
        loginLog.setLoginTime(System.currentTimeMillis());
        loginLog.setStatus(2);
        dyLoginLogService.updateById(loginLog);

        Boolean isCreate = false;
        DyUserToken dyUserToken = dyUserTokenService.getByDyNumber(dyLoginLog.getDyNumber());
        if(dyUserToken==null) {
            isCreate = true;
        }else {
            Map<String, Long> timeDifference = DateUtils.calculateTimeDifference(dyUserToken.getCreateTime(), System.currentTimeMillis());
            if (timeDifference.get("days") > 30) {
                isCreate = true;
            } else {
                log.info("DY号[" + dyUserToken.getDyNumber() + "]在30天内已扫码登录，上次登录时间["+dyUserToken.getCreateTime()+"]，请勿重复采集。");
                return R.fail("账号在30天内已登录，无法重复登录");
            }
        }
        if(isCreate){
            dyUserToken = new DyUserToken();
            dyUserToken.setCreateTime(System.currentTimeMillis());
            dyUserToken.setDyNumber(loginLog.getDyNumber());
            dyUserToken.setLoginCity(loginLog.getCity());
            dyUserToken.setFirstAgentUserId(loginLog.getFirstAgentUserId());
            dyUserToken.setNickname(loginLog.getNickname());
            dyUserToken.setSecondAgentUserId(loginLog.getSecondAgentUserId());
            dyUserToken.setState(1);
            dyUserToken.setIsUse(1);
            dyUserTokenService.save(dyUserToken);
        }
        return R.ok();
    }

    /**
     * 通过任务Id获取登录二维码
     */
    @SaIgnore
    @GetMapping("/getQRCode")
    public R<DyLoginLog> getQRCode(@RequestParam String taskId){
        DyLoginLog loginLog = dyLoginLogService.getByTaskId(taskId);
        if(loginLog == null)
            return R.fail("任务Id不存在，Id:"+taskId);
        return R.ok(loginLog);
    }

}
