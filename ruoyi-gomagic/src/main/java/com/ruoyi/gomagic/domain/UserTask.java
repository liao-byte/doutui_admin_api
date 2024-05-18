package com.ruoyi.gomagic.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author liaoZhangSheng
 * @since 2023-08-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserTask implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * mj代理服务器的任务id
     */
    private String mjTaskId;

    /**
     * mj生成图片的地址
     */
    private String mjImgUrl;

    /**
     * mj任务的状态状态
     */
    private String status;

    /**
     * 是否他人可见
     */
    private Integer isPrivately;

    /**
     * 描述
     */
    private String description;

    /**
     * 描述翻译
     */
    private String descriptionCn;

    /**
     * 任务类型
     */
    private Integer type;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 进度
     */
    private String progress;

    private String prompt;

    private String promptEn;


    private String state;

    private Long finishTime;

    private Long createTime;


    private String localUrl;

    /**
     * 缩略图地址
     */
    private String localMiniUrl;

    /**
     * 是否删除
     */
    private Integer isDelete;

    /**
     * 本次任务耗费积分
     */
    private Integer val;

    private Integer auditStatus;
}
