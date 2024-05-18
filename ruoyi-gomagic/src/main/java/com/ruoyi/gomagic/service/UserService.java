package com.ruoyi.gomagic.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.gomagic.domain.User;
import com.ruoyi.gomagic.dto.ReportForms;

/**
 * <p>
 * 用户基础表 服务类
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-03
 */
public interface UserService extends IService<User> {

    TableDataInfo<User> getPageUserInfo(User user, PageQuery pageQuery);

    R<Void> updateBanStatus(String id);

    ReportForms getAllNumAndNewAdd(Integer day);

}
