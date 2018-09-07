package com.apin.qunar.order.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @outhor ligang
 * @create 2018-08-07 16:57
 */
public interface NationalChangeOrderExtMapper {

    @Update("update national_change_order set change_status=#{payStatus},ticket_no=#{ticketNo} where order_no=#{orderNo}")
    int updateStatusAndTicketNo( @Param("orderNo") String orderNo, @Param("payStatus") int payStatus, @Param("ticketNo") String ticketNo);


    @Update("update national_change_order set change_status=#{payStatus} where order_no=#{orderNo}")
    int updateStatus(@Param("orderNo") String orderNo, @Param("payStatus") int payStatus);

}