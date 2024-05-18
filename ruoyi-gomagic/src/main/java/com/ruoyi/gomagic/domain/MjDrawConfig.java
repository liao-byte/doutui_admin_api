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
 * @since 2023-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MjDrawConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
      private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 积分
     */
    private Integer integral;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;


}
