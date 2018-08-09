package com.apin.qunar.basic.dao.mapper;

import com.apin.qunar.basic.dao.model.Country;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CountryExtMapper {
    @Select("SELECT * FROM country WHERE name like CONCAT('%',#{name},'%') LIMIT 1")
    Country queryLikeByName(@Param("name") String name);
}
