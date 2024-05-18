package com.ruoyi.web.controller.gomagic;



import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.gomagic.domain.WithdrawalApply;
import com.ruoyi.gomagic.dto.WithdrawalApplyPageDTO;
import com.ruoyi.gomagic.query.WithdrawalApplyUpdateStatus;
import com.ruoyi.gomagic.service.WithdrawalApplyService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-10-20
 */
@RestController
@RequestMapping("/gomagic/withdrawalApply")
@RequiredArgsConstructor
public class WithdrawalApplyController {

    private final WithdrawalApplyService withdrawalApplyService;


    /**
     * 分页查询用户列表
     */
    @GetMapping("/listPageWithdrawalApply")
    public TableDataInfo<WithdrawalApplyPageDTO> listPageWithdrawalApply(WithdrawalApply withdrawalApply, PageQuery pageQuery){
        return withdrawalApplyService.listPageWithdrawalApply(withdrawalApply,pageQuery);
    }

    @PostMapping("updateStatus")
    public R<?> updateStatus(@RequestBody WithdrawalApplyUpdateStatus withdrawalApplyUpdateStatus){
        return withdrawalApplyService.updateStatus(withdrawalApplyUpdateStatus);
    }
}

