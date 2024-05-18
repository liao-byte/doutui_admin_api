package com.ruoyi.gomagic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.gomagic.domain.DyUserToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DyUserTokenMapper extends BaseMapper<DyUserToken> {
    DyUserToken getByDyNumber(String dyNumber);
}
