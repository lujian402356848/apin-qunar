package com.apin.qunar.statistics.dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;


public interface InternationalSearchFlightRecordExtMapper {
    @Select("select distinct merchant_no from international_search_flight_record where insert_time>=#{startTime} and insert_time<=#{endTime}")
    List<String> queryMerchantNoByInsertTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Select("select count(1) from international_search_flight_record where merchant_no=#{merchantNo} and insert_time>#{startTime} and insert_time<=#{endTime}")
    int queryFlightCntBy(@Param("merchantNo") String merchantNo, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Delete("delete from international_search_flight_record where insert_time<=#{date}")
    int deleteByInsertTimeLessThan(@Param("date") Date date);
}