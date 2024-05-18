package com.ruoyi.gomagic.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * DY用户登录对象 dy_user_token
 *
 * @author ruoyi
 * @date 2024-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DyUserToken implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     *
     */
    private String id;
    /**
     * 抖音Id
     */
    private Long dyId;
    /**
     * 抖音号
     */
    private String dyNumber;
    /**
     * 昵称
     */
    private String nickname;
    /**
     *
     */
    private String secUid;
    /**
     * 登录地
     */
    private String loginCity;
    /**
     * 一级代理用户ID
     */
    private String firstAgentUserId;
    /**
     * 二级代理用户ID
     */
    private String secondAgentUserId;
    /**
     * 状态，1-在线，0-离线
     */
    private Integer state;
    /**
     * 是否启用
     */
    private Integer isUse;
    /**
     * 创建时间
     */
    private Long createTime;
}
