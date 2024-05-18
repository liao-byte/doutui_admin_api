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
 * @since 2023-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class InCome implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
      private Long id;

    /**
     * 被邀请人id
     */
    private String friendId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 套餐id
     */
    private String packageId;

    /**
     * 套餐名称
     */
    private String packageTitle;

    /**
     * 套餐类型
     */
    private Integer packageType;

    /**
     * 套餐金额
     */
    private Integer packageAmount;

    /**
     * 收入
     */
    private Integer inAmount;

    /**
     * 是否提现
     */
    private Integer withdrawal;

    /**
     * 创建事件
     */
    private Long createTime;

    /**
     * 更新事件
     */
    private Long updateTime;

    /**
     * 提现时间
     */
    private Long withdrawalTime;

    private String serverName;


}
