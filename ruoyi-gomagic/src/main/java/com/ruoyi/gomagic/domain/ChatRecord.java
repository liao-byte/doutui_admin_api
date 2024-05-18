package com.ruoyi.gomagic.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 聊天记录表
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ChatRecord implements Serializable {

    private static final long serialVersionUID = 1L;

      private String id;

    /**
     * 聊天ID
     */
    private String chatId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 上一对话ID
     */
    private String prevRecordId;

    /**
     * 聊天内容
     */
    private String content;

    /**
     * 模型
     */
    private String model;

    /**
     * 是否删除：0-未删除，1-已删除
     */
    private Integer isDeleted;

    /**
     * 创建时间
     */
    private Long createTime;


    /**
     * 角色类型 0 用户 1 ai 模型
     */
    private Integer roleType;

    private Integer isStop;
}
