package com.ruoyi.gomagic.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.gomagic.domain.Package;
import com.ruoyi.gomagic.domain.User;
import com.ruoyi.gomagic.mapper.PackageMapper;
import com.ruoyi.gomagic.service.PackageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 套餐表 服务实现类
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-07
 */
@Service
public class PackageServiceImpl extends ServiceImpl<PackageMapper, Package> implements PackageService {


    @Override
    public TableDataInfo<Package> getPagePackage(Package queryPackage, PageQuery pageQuery) {
        LambdaQueryWrapper<Package> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Package::getIsDelete,0);
        lqw.like(StringUtils.isNotBlank(queryPackage.getTitle()),Package::getTitle,queryPackage.getTitle());
        lqw.like(StringUtils.isNotBlank(queryPackage.getServerName()),Package::getServerName,queryPackage.getServerName());
        lqw.orderByDesc(Package::getCreateDateTime);
        Page<Package> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }
}
