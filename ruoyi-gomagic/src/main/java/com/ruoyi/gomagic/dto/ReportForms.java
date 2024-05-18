package com.ruoyi.gomagic.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ReportForms implements Serializable {
    //总数
    private Long total;

    //每日新增加

    private List<EveryDayADD>  everyDayADDList;

}
