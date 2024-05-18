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

public class DyLoginLog implements Serializable {
    private static final long serialVersionUID=1L;

    /**
     *
     */
    private String id;
    /**
     * 任务Id
     */
    private String taskId;
    /**
     * 城市
     */
    private String city;
    /**
     * 登录码地址
     */
    private String qrcode;
    /**
     * 状态，0-未处理,1-已处理
     */
    private Integer status;
    /**
     * D号
     */
    private String dyNumber;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 一级代理用户ID
     */
    private String firstAgentUserId;
    /**
     * 二级代理用户ID
     */
    private String secondAgentUserId;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 生成二维码时间
     */
    private Long generateTime;
    /**
     * 登录时间
     */
    private Long loginTime;
}
