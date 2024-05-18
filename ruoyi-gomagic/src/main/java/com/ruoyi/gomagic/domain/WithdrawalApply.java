package com.ruoyi.gomagic.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-10-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WithdrawalApply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 提现申请
     */
      private Long id;

    /**
     * 提现申请人
     */
    private Long applyId;

    /**
     * 提现id集合
     */
    private String applyOrderId;

    /**
     * 提现金额
     */
    private Long amount;

    /**
     * 状态
     */
    private Integer status;

    private Long createTime;
    private Long updateTime;

}
