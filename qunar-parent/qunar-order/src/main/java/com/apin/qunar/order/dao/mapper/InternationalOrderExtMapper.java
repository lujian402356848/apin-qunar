package com.apin.qunar.order.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

/**
 * @outhor lujian
 * @create 2018-07-09 10:25
 */
public interface InternationalOrderExtMapper {
    @Select("select count(1) from international_order where operator=#{operator} and pay_status in (${payStatusStr}) and insert_time>=#{startTime} and insert_time<#{endTime}")
    int queryCntBy(@Param("operator") String operator, @Param("payStatusStr") String payStatusStr, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Select("select ifnull(sum(pay_amount),0) from international_order where operator=#{operator} and pay_status in (${payStatusStr}) and insert_time>=#{startTime} and insert_time<#{endTime}")
    int queryTotalAmountBy(@Param("operator") String operator, @Param("payStatusStr") String payStatusStr, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Update("update international_order set pay_status=#{payStatus} where order_no=#{orderNo} and pay_status!=#{payStatus}")
    int updateStatus(@Param("orderNo") String orderNo, @Param("payStatus") int payStatus);

    @Update("update international_order set ticket_no=#{ticketNo},pay_status=#{payStatus} where order_no=#{orderNo}")
    int updateStatusAndTicketNo(@Param("orderNo") String orderNo, @Param("ticketNo") String ticketNo, @Param("payStatus") int payStatus);

    @Update("update international_order set pay_id=#{payId},pay_status=#{payStatus},pay_time=#{payTime} where order_no=#{orderNo}")
    int updatePayInfo(@Param("orderNo") String orderNo, @Param("payId") String payId, @Param("payStatus") int payStatus, @Param("payTime") String payTime);
}