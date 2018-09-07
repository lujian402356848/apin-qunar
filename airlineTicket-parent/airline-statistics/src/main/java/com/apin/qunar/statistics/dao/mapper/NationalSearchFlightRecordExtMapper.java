package com.apin.qunar.statistics.dao.mapper;

import com.apin.qunar.statistics.domain.SearchFlightRecordDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;


public interface NationalSearchFlightRecordExtMapper {
    @Select("select distinct account from national_search_flight_record where insert_time>=#{startTime} and insert_time<=#{endTime}")
    List<String> queryAccountByInsertTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Select("select count(1) from national_search_flight_record where account=#{account} and insert_time>#{startTime} and insert_time<=#{endTime}")
    int queryFlightCntBy(@Param("account") String account, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Select("select merchant_no as merchantNo,dept_city as city, count(dept_city) as searchCnt from national_search_flight_record where insert_time>=#{startTime} and insert_time<#{endTime} group by merchant_no,dept_city having dept_city is not null and merchant_no=#{merchantNo} order by searchCnt desc limit 20")
    List<SearchFlightRecordDTO> queryDeptCityTop20By(@Param("merchantNo") String merchantNo, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Select("select merchant_no as merchantNo,arri_city as city, count(arri_city) as searchCnt from national_search_flight_record where insert_time>=#{startTime} and insert_time<#{endTime} group by merchant_no,arri_city having arri_city is not null and merchant_no=#{merchantNo} order by searchCnt desc limit 20")
    List<SearchFlightRecordDTO> queryArriCityTop20By(@Param("merchantNo") String merchantNo, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Delete("delete from national_search_flight_record where insert_time<=#{date}")
    int deleteByInsertTimeLessThan(@Param("date") Date date);
}