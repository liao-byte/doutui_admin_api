package com.ruoyi.gomagic.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author liaoZhangSheng
 * @since 2023-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Package implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String title;
    private String spec;
    private BigDecimal price;
    private Integer number;
    private String remark;
    private String status;
    /**
     * 封面图片路径
     */
    private String imgUrl;
    /**
     * 有效开始时间
     */
    private Long startDateTime;
    /**
     * 有效结束时间
     */
    private Long endDateTime;
    private Boolean discount;
    private Boolean isDelete;
    /**
     * 创建时间
     */
    private Long createDateTime;

    private Long createUserId;
    /**
     * 更新时间
     */
    private Long updateDateTime;

    private Integer points;

    private Integer type;


    private String serverName;
}
