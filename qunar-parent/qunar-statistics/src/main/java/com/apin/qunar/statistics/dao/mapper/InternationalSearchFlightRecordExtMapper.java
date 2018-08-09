package com.apin.qunar.statistics.dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;


public interface InternationalSearchFlightRecordExtMapper {
    @Select("select distinct merchant_no from search_flight_record where insert_time>=#{startTime} and insert_time<={endTime}")
    List<String> queryAllMerchantNo(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Select("select count(1) from search_flight_record where has_internal=#{hasNational} and insert_time>#{startTime} and insert_time<=#{endTime}")
    int queryFlightCnt(@Param("hasNational") Integer hasNational, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Delete("delete from search_flight_record where insert_time<=#{date}")
    int deleteByInsertTimeLessThan(@Param("date") Date date);
}