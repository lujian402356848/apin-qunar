package com.apin.qunar.statistics.dao.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface InternationalSearchCityStatisticsExtMapper {
    @Select("select max(insert_time) from international_search_city_statistics")
    Date queryMaxInsertTime();
}