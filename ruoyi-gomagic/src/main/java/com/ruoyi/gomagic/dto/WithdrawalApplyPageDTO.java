package com.ruoyi.gomagic.dto;

import com.ruoyi.gomagic.domain.WithdrawalApply;
import lombok.Data;

import java.io.Serializable;

@Data
public class WithdrawalApplyPageDTO extends WithdrawalApply implements Serializable{
    private String applyName;
}
