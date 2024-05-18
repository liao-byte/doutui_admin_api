package com.ruoyi.gomagic.service.impl;


import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.gomagic.domain.MjAccount;
import com.ruoyi.gomagic.domain.User;
import com.ruoyi.gomagic.mapper.MjAccountMapper;
import com.ruoyi.gomagic.service.MjAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-21
 */
@Service
@Slf4j
public class MjAccountServiceImpl extends ServiceImpl<MjAccountMapper, MjAccount> implements MjAccountService {

    @Value("${mjService.host}")
    private String host;

    @Override
    public TableDataInfo<MjAccount> listPageMjAccount(MjAccount mjAccount, PageQuery pageQuery) {
        LambdaQueryWrapper<MjAccount> lqw = new LambdaQueryWrapper<MjAccount>();
        Page<MjAccount> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public void synchronizeAccount(String id) {
        // 同步数据
        MjAccount mjAccount=this.getById(id);

        if (mjAccount == null){
            return;
        }

        //TODO 账号池的实现
        HttpUtil.get("http://localhost:8090/mj/submit/info");
    }

    @Override
    public R<Void> startMjService(String id) {

        String s = HttpUtil.get(host + "/mjAccount/startMjService/" + id);
        log.info("启动服务返回结果:{}", s);

        return R.ok();
    }

    @Override
    public R<Void> restartMjService(String id) {
        String s = HttpUtil.get(host + "/mjAccount/restartMjService/" + id);
        log.info("重启服务返回结果:{}", s);
        return R.ok();
    }
}
