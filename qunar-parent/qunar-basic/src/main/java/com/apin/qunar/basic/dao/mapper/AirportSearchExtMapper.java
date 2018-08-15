package com.apin.qunar.basic.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AirportSearchExtMapper {
    @Select("select distinct airport_code from airport_search where search_keyword like CONCAT(#{keyword},'%') limit 10")
    List<String> queryAirportCodeByKeyword(@Param("keyword") String keyword);
}