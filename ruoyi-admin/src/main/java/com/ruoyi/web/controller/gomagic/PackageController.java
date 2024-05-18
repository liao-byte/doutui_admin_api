package com.ruoyi.web.controller.gomagic;

import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.helper.LoginHelper;
import com.ruoyi.gomagic.domain.Package;
import com.ruoyi.gomagic.domain.User;
import com.ruoyi.gomagic.service.PackageService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gomagic/package")
public class PackageController {

    private final PackageService packageService;
    /**
     * 分页查询用户列表
     */
    @GetMapping("/getPagePackage")
    public TableDataInfo<Package> getPagePackage(Package queryPackage, PageQuery pageQuery){
        return packageService.getPagePackage(queryPackage,pageQuery);
    }

    @GetMapping("/deleteById")
    public R<Void> deleteById(@RequestParam ("id")String id){
        Package byId = packageService.getById(id);
        byId.setIsDelete(true);
        packageService.updateById(byId);
        return R.ok();
    }

    @GetMapping("/getById")
    public R<Package> getById(@RequestParam ("id")String id){
        Package byId = packageService.getById(id);
        byId.setPrice(byId.getPrice().divide(new BigDecimal(100),2, RoundingMode.UP));
        return R.ok(byId);
    }

    @PostMapping("/addOrUpdate")
    public R<Void> addOrUpdate(@RequestBody Package addPackage){
        Long userId = LoginHelper.getUserId();
        //转换为分存在到数据库中
        addPackage.setPrice(addPackage.getPrice().multiply(new BigDecimal(100)));
        addPackage.setUpdateDateTime(System.currentTimeMillis());
        if (StringUtils.isNotBlank(addPackage.getId())){
            packageService.updateById(addPackage);
        }else {
            addPackage.setCreateDateTime(System.currentTimeMillis());
            addPackage.setCreateUserId(userId);
            addPackage.setNumber(0);
            addPackage.setDiscount(false);
            addPackage.setIsDelete(false);
            packageService.save(addPackage);
        }

        return R.ok();
    }
}
