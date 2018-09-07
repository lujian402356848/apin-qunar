package com.apin.qunar.statistics.dao.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface DayMerchantStatisticsExtMapper {
    @Select("select max(insert_time) from day_merchant_statistics")
    Date queryMaxInsertTime();
}
