package com.ruoyi.gomagic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.gomagic.domain.Package;


import java.util.List;

/**
 * <p>
 * 套餐表 服务类
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-07
 */
public interface PackageService extends IService<Package> {


    TableDataInfo<Package> getPagePackage(Package queryPackage, PageQuery pageQuery);

}
