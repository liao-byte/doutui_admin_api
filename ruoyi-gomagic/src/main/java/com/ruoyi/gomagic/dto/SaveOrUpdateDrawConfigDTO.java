package com.ruoyi.gomagic.dto;

import com.ruoyi.gomagic.domain.MjDrawConfig;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SaveOrUpdateDrawConfigDTO implements Serializable {

    List<SaveOrUpdateDrawConfig> list;

    @Data
    static class SaveOrUpdateDrawConfig implements Serializable{
        private String name;


        private MjDrawConfig mjDrawConfig;
    }
}
