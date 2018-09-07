package com.apin.qunar.basic.dao.mapper;

import com.apin.qunar.basic.dao.model.Airline;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AirlineExtMapper {
    @Select("select * from airline where code like CONCAT('%',#{code},'%') LIMIT 1")
    Airline queryByCode(@Param("code") String code);
}
