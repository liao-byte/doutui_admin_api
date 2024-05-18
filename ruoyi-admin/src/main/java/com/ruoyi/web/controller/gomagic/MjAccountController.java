package com.ruoyi.web.controller.gomagic;

import cn.dev33.satoken.annotation.SaIgnore;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.gomagic.domain.MjAccount;
import com.ruoyi.gomagic.domain.MjAccountContainer;
import com.ruoyi.gomagic.domain.MjAccountPageResult;
import com.ruoyi.gomagic.service.MjAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/gomagic/mjAccount")
@RestController
@RequiredArgsConstructor
@Slf4j
public class MjAccountController {

    private final MjAccountService mjAccountService;


    @GetMapping("/listPageMjAccount")
    public TableDataInfo<MjAccount> listPageMjAccount(PageQuery pageQuery, MjAccount mjAccount) {
        return mjAccountService.listPageMjAccount(mjAccount,pageQuery);
    }

    /**
     * 新增加
     */
    @PostMapping("/addMjAccount")
    public R<Void> addMjAccount(@RequestBody MjAccount mjAccount){
        mjAccountService.save(mjAccount);
        return R.ok();
    }

    /**
     * 同步Account账户的信息
     */
    @GetMapping("/synchronizeAccount/{id}")
    public R<Void> synchronizeAccount(@PathVariable("id") String id){
        mjAccountService.synchronizeAccount(id);
        return R.ok();
    }

    /**
     * 删除账号
     */
    @GetMapping("/deleteAccount/{id}")
    public R<Void> deleteAccount(@PathVariable("id") String id){
        mjAccountService.removeById(id);
        return R.ok();
    }

    /**
     * 启动服务
     */
    @GetMapping("/startMjService/{id}")
    public R<Void> startMjService( @PathVariable("id") String id){
    return mjAccountService.startMjService(id);
    }

    /**
     * 重启服务
     */
    @GetMapping("/restartMjService/{id}")
    public R<Void> restartMjService( @PathVariable String id){
        return mjAccountService.restartMjService(id);
    }

}
