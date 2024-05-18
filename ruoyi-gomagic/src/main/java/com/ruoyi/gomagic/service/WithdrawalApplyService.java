package com.ruoyi.gomagic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.gomagic.domain.WithdrawalApply;
import com.ruoyi.gomagic.dto.WithdrawalApplyPageDTO;
import com.ruoyi.gomagic.query.WithdrawalApplyUpdateStatus;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-10-20
 */
public interface WithdrawalApplyService extends IService<WithdrawalApply> {

    TableDataInfo<WithdrawalApplyPageDTO> listPageWithdrawalApply(WithdrawalApply withdrawalApply, PageQuery pageQuery);

    R<?> updateStatus(WithdrawalApplyUpdateStatus withdrawalApplyUpdateStatus);
}
