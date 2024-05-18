package com.ruoyi.gomagic.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.gomagic.domain.User;
import com.ruoyi.gomagic.dto.EveryDayADD;
import com.ruoyi.gomagic.dto.ReportForms;
import com.ruoyi.gomagic.mapper.UserMapper;
import com.ruoyi.gomagic.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户基础表 服务实现类
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public TableDataInfo<User> getPageUserInfo(User user, PageQuery pageQuery) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>().like(StringUtils.isNotEmpty(user.getRealName()),User::getRealName,user.getRealName())
            .like(StringUtils.isNotEmpty(user.getNickname()),User::getNickname,user.getNickname())
            .like(StringUtils.isNotEmpty(user.getPhone()),User::getPhone,user.getPhone());
        Page<User> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public R<Void> updateBanStatus(String id) {
        User user = this.getById(id);
        if (user == null) {
            return R.fail("用户信息不存在");
        }
        user.setBan(user.getBan() == 0 ? 1 : 0);
        this.updateById(user);
        return R.ok();
    }

    @Override
    public ReportForms getAllNumAndNewAdd(Integer day) {
        ReportForms reportForms = new ReportForms();
        Long l = baseMapper.selectCount(new QueryWrapper<>());
        reportForms.setTotal(l);

        List<EveryDayADD> everyDayADDList = baseMapper.getNewAdd(day);

        reportForms.setEveryDayADDList(everyDayADDList);
        return reportForms;
    }
}
