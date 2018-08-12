package com.apin.qunar.statistics.dao.mapper;

import com.apin.qunar.statistics.domain.SearchFlightRecordDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;


public interface InternationalSearchFlightRecordExtMapper {
    @Select("select distinct merchant_no from international_search_flight_record where insert_time>#{startTime} and insert_time<=#{endTime}")
    List<String> queryMerchantNoByInsertTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Select("select count(1) from international_search_flight_record where merchant_no=#{merchantNo} and insert_time>#{startTime} and insert_time<=#{endTime}")
    int queryFlightCntBy(@Param("merchantNo") String merchantNo, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Select("select merchant_no as merchantNo,dept_city as city, count(dept_city) as searchCnt from international_search_flight_record where insert_time>=#{startTime} and insert_time<#{endTime} group by merchant_no,dept_city having dept_city is not null and merchant_no=#{merchantNo} order by searchCnt desc limit 20")
    List<SearchFlightRecordDTO> queryDeptCityTop20By(@Param("merchantNo") String merchantNo, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Select("select merchant_no as merchantNo,arri_city as city, count(arri_city) as searchCnt from international_search_flight_record where insert_time>=#{startTime} and insert_time<#{endTime} group by merchant_no,arri_city having arri_city is not null and merchant_no=#{merchantNo} order by searchCnt desc limit 20")
    List<SearchFlightRecordDTO> queryArriCityTop20By(@Param("merchantNo") String merchantNo, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Delete("delete from international_search_flight_record where insert_time<=#{date}")
    int deleteByInsertTimeLessThan(@Param("date") Date date);
}