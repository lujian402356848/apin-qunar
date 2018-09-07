package com.apin.qunar.statistics.dao.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface NationalSearchCityStatisticsExtMapper {
    @Select("select max(insert_time) from national_search_city_statistics")
    Date queryMaxInsertTime();
}