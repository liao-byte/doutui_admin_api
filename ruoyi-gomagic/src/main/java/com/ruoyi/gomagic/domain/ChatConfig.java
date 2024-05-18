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
 * @since 2023-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ChatConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 模型名称
     */
    private String modelName;

    /**
     * 模型名称
     */
    private String showModelName;

    /**
     * 单次消耗积分
     */
    private Integer integral;

    /**
     * 是否禁用
     */
    private Integer ban;

    /**
     * 平台类型 0 openAI 1 文心一言
     */
    private Long platformType;

    /**
     * 访问地址
     */
    private String accessUrl;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;

    private Integer isDelete;
}
