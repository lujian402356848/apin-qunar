package com.apin.qunar.order.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @outhor ligang
 * @create 2018-07-30 16:01
 */
public interface NationalRefundOrderExtMapper {

    @Update("update national_return_order set order_no=#{orderNo},return_status=#{payStatus},ticket_no=#{ticketNo} where parent_order_no=#{parentOrderNo}")
    int updateStatusAndTicketNo(@Param("parentOrderNo") String parentOrderNo, @Param("orderNo") String orderNo, @Param("payStatus") int payStatus, @Param("ticketNo") String ticketNo);


    @Update("update national_return_order set pay_id=#{payId},return_status=#{payStatus},pay_time=#{payTime} where order_no=#{orderNo}")
    int updatePayInfo(@Param("orderNo") String orderNo, @Param("payId") String payId, @Param("payStatus") int payStatus, @Param("payTime") String payTime);


    @Update("update national_return_order set return_status=#{payStatus} where order_no=#{orderNo}")
    int updateStatus(@Param("orderNo") String orderNo, @Param("payStatus") int payStatus);

    @Update("update national_return_order set return_pay_status=#{returnStauts} , return_pay_type=#{returnType} where order_no=#{orderNo}")
    int updateReturnPayTypeAndstatus(@Param("orderNo") String orderNo, @Param("returnType") Integer returnType, @Param("returnStauts") Integer returnStauts);
}