package com.ruoyi.web.controller.taskmag;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.hutool.http.HttpUtil;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.helper.LoginHelper;
import com.ruoyi.gomagic.domain.DyUserToken;
import com.ruoyi.gomagic.domain.MjAccount;
import com.ruoyi.gomagic.domain.Package;
import com.ruoyi.gomagic.domain.User;
import com.ruoyi.gomagic.dto.ReportForms;
import com.ruoyi.gomagic.service.DyUserTokenService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequestMapping("/taskmag/account")
@RestController
@RequiredArgsConstructor
public class DyUserTokenController {
    private final DyUserTokenService dyUserTokenService;

    /**
     * 分页查询用户列表
     */
    @GetMapping("/getPageUserInfo")
    public TableDataInfo<DyUserToken> getPageUserInfo(DyUserToken dyUserToken, PageQuery pageQuery){
        return dyUserTokenService.getPageUserInfo(dyUserToken,pageQuery);
    }

    /**
     * 新增加
     */
    @PostMapping("/addToken")
    public R<Void> addToken(@RequestBody DyUserToken dyUserToken){
        dyUserTokenService.save(dyUserToken);
        return R.ok();
    }

    /**
     * 更新账号状态
     */
    @SaIgnore
    @PostMapping("/updateStatus")
    public R<Void> updateStatus(@RequestBody DyUserToken dyUserToken){
        DyUserToken userToken = dyUserTokenService.getByDyNumber(dyUserToken.getDyNumber());
        //if(userToken===null)
        //    return R.fail("D号不存在，"+dyUserToken.getDyNumber());
        userToken.setState(dyUserToken.getState());
        dyUserTokenService.updateById(userToken);
        return R.ok();
    }
}
