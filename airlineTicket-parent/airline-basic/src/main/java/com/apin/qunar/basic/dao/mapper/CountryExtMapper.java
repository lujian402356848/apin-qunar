package com.apin.qunar.basic.dao.mapper;

import com.apin.qunar.basic.dao.model.Country;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CountryExtMapper {
    @Select("SELECT * FROM country WHERE name like CONCAT('%',#{name},'%') LIMIT 1")
    Country queryLikeByName(@Param("name") String name);

    @Select("SELECT name FROM country WHERE name like CONCAT(#{keyword},'%') or code like CONCAT(#{keyword},'%') or spell like CONCAT (#{keyword},'%')")
    List<String> queryNameByKeyword(@Param("keyword") String keyword);

}
