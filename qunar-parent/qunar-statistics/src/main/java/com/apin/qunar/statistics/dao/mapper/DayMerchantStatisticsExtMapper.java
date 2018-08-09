package com.apin.qunar.statistics.dao.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface DayMerchantStatisticsExtMapper {
    @Select("select max(insert_time) from search_flight_record")
    Date queryMaxInsertTime();
}
