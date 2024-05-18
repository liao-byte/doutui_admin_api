package com.ruoyi.gomagic.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.gomagic.domain.InCome;
import com.ruoyi.gomagic.domain.Package;
import com.ruoyi.gomagic.domain.User;
import com.ruoyi.gomagic.domain.WithdrawalApply;
import com.ruoyi.gomagic.dto.WithdrawalApplyPageDTO;
import com.ruoyi.gomagic.mapper.InComeMapper;
import com.ruoyi.gomagic.mapper.UserMapper;
import com.ruoyi.gomagic.mapper.WithdrawalApplyMapper;
import com.ruoyi.gomagic.query.WithdrawalApplyUpdateStatus;
import com.ruoyi.gomagic.service.UserService;
import com.ruoyi.gomagic.service.WithdrawalApplyService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-10-20
 */
@Service
public class WithdrawalApplyServiceImpl extends ServiceImpl<WithdrawalApplyMapper, WithdrawalApply> implements WithdrawalApplyService {

    @Autowired
    public UserMapper userMapper;

    @Autowired
    public InComeMapper inComeMapper;
    private final static Integer WITHDRAWAL_APPLY_STATUS_PASS = 2;
    private final static Integer WITHDRAWAL_APPLY_STATUS_REFUSE = 3;

    @Override
    public TableDataInfo<WithdrawalApplyPageDTO> listPageWithdrawalApply(WithdrawalApply withdrawalApply, PageQuery pageQuery) {
        TableDataInfo<WithdrawalApplyPageDTO> withdrawalApplyPageDTOTableDataInfo = new TableDataInfo<>();

        LambdaQueryWrapper<WithdrawalApply> lqw = new LambdaQueryWrapper<>();
        //状态
        lqw.orderByAsc(WithdrawalApply::getStatus);
        lqw.orderByDesc(WithdrawalApply::getUpdateTime);
        Page<WithdrawalApply> page = baseMapper.selectPage(pageQuery.build(), lqw);
        TableDataInfo<WithdrawalApply> build = TableDataInfo.build(page);

        BeanUtils.copyProperties(build, withdrawalApplyPageDTOTableDataInfo);
        List<WithdrawalApply> rows = build.getRows();
        List<WithdrawalApplyPageDTO> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(rows)){
            //查询用户信息
            List<Long> ids = rows.stream().map(WithdrawalApply::getApplyId).collect(Collectors.toList());
            List<User> users = userMapper.selectBatchIds(ids);
            Map<String, User> userMap = users.stream().collect(Collectors.toMap(User::getId, user -> user));

            result = rows.stream().map(item -> {
                WithdrawalApplyPageDTO withdrawalApplyPageDTO = new WithdrawalApplyPageDTO();
                BeanUtils.copyProperties(item, withdrawalApplyPageDTO);
                if (userMap.get(item.getApplyId() + "") != null) {
                    withdrawalApplyPageDTO.setApplyName(userMap.get(item.getApplyId() + "").getNickname());
                }
                return withdrawalApplyPageDTO;
            }).collect(Collectors.toList());
        }
        withdrawalApplyPageDTOTableDataInfo.setRows(result);
        return withdrawalApplyPageDTOTableDataInfo;
    }


    @Override
    public R<?> updateStatus(WithdrawalApplyUpdateStatus withdrawalApplyUpdateStatus) {

        WithdrawalApply byId = this.getById(withdrawalApplyUpdateStatus.getId());
        if (byId == null) {
            return R.fail("不存在");
        }
        WithdrawalApply withdrawalApply = new WithdrawalApply();
        withdrawalApply.setId(Long.valueOf(withdrawalApplyUpdateStatus.getId()));
        withdrawalApply.setStatus(withdrawalApplyUpdateStatus.getStatus());
        withdrawalApply.setUpdateTime(System.currentTimeMillis());
        this.updateById(withdrawalApply);

        String[] split = byId.getApplyOrderId().split(",");
        List<String> ids = Arrays.asList(split);
        List<InCome> inComes = inComeMapper.selectBatchIds(ids);
        int status=1;
        //更新用户审核信息
        if (withdrawalApplyUpdateStatus.getStatus() == 1){
            status=WITHDRAWAL_APPLY_STATUS_PASS;
        } else if (withdrawalApplyUpdateStatus.getStatus() == 2) {
            status=WITHDRAWAL_APPLY_STATUS_REFUSE;
        }
        for (InCome inCome : inComes) {
            inCome.setWithdrawal(status);
            inCome.setWithdrawalTime(System.currentTimeMillis());
            inComeMapper.updateById(inCome);
        }
        return R.ok();
    }
}
