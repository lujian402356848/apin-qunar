package com.apin.qunar.order.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

/**
 * @outhor lujian
 * @create 2018-06-27 20:36
 */
public interface NationalOrderExtMapper {
    @Select("select count(1) from national_order where pay_status in '${payStatusStr}' and insert_time>=#{startTime} and insert_time<#{endTime}")
    int queryCntBy(@Param("payStatusStr") String payStatusStr, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Select("select count(1) from national_order where merchant_no=#{merchantNo} and pay_status in (${payStatusStr}) and insert_time>=#{startTime} and insert_time<#{endTime}")
    int queryCntByMer(@Param("merchantNo") String merchantNo, @Param("payStatusStr") String payStatusStr, @Param("startTime") String startTime, @Param("endTime") String endTime);

    @Select("select sum(pay_amount) from national_order where merchant_no=#{merchantNo} and pay_status in (${payStatusStr}) and insert_time>=#{startTime} and insert_time<#{endTime}")
    int queryTotalAmountBy(@Param("payStatusStr") String payStatusStr, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Select("select sum(pay_amount) from national_order where merchant_no=#{merchantNo} and pay_status in (${payStatusStr}) and insert_time>=#{startTime} and insert_time<#{endTime}")
    int queryTotalAmountByMer(@Param("merchantNo") String merchantNo, @Param("payStatusStr") String payStatusStr, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Update("update national_order set pay_status=#{payStatus} where order_no=#{orderNo} and pay_status!=#{payStatus}")
    int updateStatus(@Param("orderNo") String orderNo, @Param("payStatus") int payStatus);

    @Update("update national_order set ticket_no=#{ticketNo},pay_status=#{payStatus} where order_no=#{orderNo}")
    int updateStatusAndTicketNo(@Param("orderNo") String orderNo, @Param("ticketNo") String ticketNo, @Param("payStatus") int payStatus);

    @Update("update national_order set pay_id=#{payId},pay_status=#{payStatus},pay_time=#{payTime} where order_no=#{orderNo}")
    int updatePayInfo(@Param("orderNo") String orderNo, @Param("payId") String payId, @Param("payStatus") int payStatus, @Param("payTime") String payTime);
}