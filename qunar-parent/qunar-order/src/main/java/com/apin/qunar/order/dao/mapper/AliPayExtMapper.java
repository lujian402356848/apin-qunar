package com.apin.qunar.order.dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AliPayExtMapper {
    @Select("select count(1) from ali_pay where order_no=#{orderNo}")
    int queryCntByOrderNo(@Param("orderNo") String orderNo);

    @Update("update ali_pay set ali_pay_status=#{payStatus} where id=#{id}")
    int updateAliPayStatus(@Param("id") String id, @Param("payStatus") Integer payStatus);

    @Update("update ali_pay set qunar_pay_status=#{payStatus} where id=#{id}")
    int updateQunarPayStatus(@Param("id") String id, @Param("payStatus") Integer payStatus);

    @Update("update ali_pay set alipay_trade_no=#{tradeNo},ali_pay_status=#{payStatus},ali_pay_time=#{payTime} where id=#{id} and ali_pay_status!=#{payStatus}")
    int updateAliPayInfo(@Param("id") String id, @Param("tradeNo") String tradeNo, @Param("payStatus") Integer payStatus, @Param("payTime") String payTime);

    @Update("update ali_pay set qunar_pay_status=#{payStatus},qunar_pay_time=#{payTime} where id=#{id} and qunar_pay_status!=#{payStatus}")
    int updateQunarPayInfo(@Param("id") String id, @Param("payStatus") Integer payStatus, @Param("payTime") String payTime);

    @Delete("delete from ali_pay where order_no=#{orderNo}")
    int deleteByOrderNo(@Param("orderNo") String orderNo);
}