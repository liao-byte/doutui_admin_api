package com.ruoyi.gomagic.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 兑换表
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserPointExchangeRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 兑换ID
     */
      private String id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 兑换码
     */
    private String code;

    /**
     * 数量
     */
    private Integer val;

    /**
     * 兑换日期
     */
    private Long exchangeTime;

    /**
     * 兑换类型
     */
    private String exchangeType;

    /**
     * 是否已兑换：0-否，1-是
     */
    private Boolean isExchange;

    /**
     * 创建时间
     */
    private Long createTime;


}
