package com.ruoyi.gomagic.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户基础表
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
      private String id;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 手机号是否验证：0-未验证，1-已验证
     */
    private Boolean isPhoneVerified;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 邮箱是否验证：0-未验证，1-已验证
     */
    private Boolean isEmailVerified;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 加盐
     */
    private String salt;

    /**
     * 邀请码
     */
    private String code;

    /**
     * 登录状态：0-未登录，1-已登录
     */
    private Boolean status;

    /**
     * 奖励积分
     */
    private Integer rewardPoints;

    /**
     * 充值积分
     */
    private Integer rechargePoints;

    /**
     * 冻结积分
     */
    private Integer frozenPoints;

    /**
     * 消费积分
     */
    private Integer consumedPoints;

    /**
     * OpenId
     */
    private String openid;

    /**
     * UnionId
     */
    private String unionid;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 在线时长（分钟）
     */
    private Integer onlineDuration;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    private Integer ban;
}
