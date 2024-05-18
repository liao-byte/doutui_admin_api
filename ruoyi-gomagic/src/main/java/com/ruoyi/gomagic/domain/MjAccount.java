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
 * @since 2023-08-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MjAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
      private Long id;

    /**
     * 账户
     */
    private String mjAccountName;

    /**
     * 状态
     */
    private Integer mjStatus;

    /**
     * remix的状态
     */
    private Boolean mjRemix;

    /**
     * 模式
     */
    private String mjMode;

    /**
     * 剩余时间
     */
    private String mjFastTime;

    /**
     * 服务器id
     */
    private String mjGuildId;

    /**
     * 通道id
     */
    private String mjChannelId;

    /**
     * 用户token
     */
    private String mjUserToken;

    /**
     * 用户sessionId
     */
    private String mjSessionId;

    private String mjUserAgent;

    private String mjCookie;

    /**
     * 并发数
     */
    private Integer mjCoreSize;

    /**
     * 等待队列
     */
    private Integer mjQueueSize;

    /**
     * 超时时间
     */
    private Integer mjTimeoutMinutes;
    private String mjVisibilityMode;
    private String mjLifeTime;
    private String mjRelaxedTime;

    private Integer useStatus;

}
