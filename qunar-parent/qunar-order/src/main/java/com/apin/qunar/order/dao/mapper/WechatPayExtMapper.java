package com.apin.qunar.order.dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface WechatPayExtMapper {
    @Select("select count(1) from wechat_pay where order_no=#{orderNo}")
    int queryCntByOrderNo(@Param("orderNo") String orderNo);

    @Update("update wechat_pay set wechat_pay_status=#{payStatus} where id=#{id}")
    int updateWeChatPayStatus(@Param("id") String id, @Param("payStatus") Integer payStatus);

    @Update("update wechat_pay set qunar_pay_status=#{payStatus} where id=#{id}")
    int updateQunarPayStatus(@Param("id") String id, @Param("payStatus") Integer payStatus);

    @Update("update wechat_pay set wechat_trade_no=#{tradeNo},wechat_pay_status=#{payStatus},wechat_pay_time=#{payTime} where id=#{id} and wechat_pay_status!=#{payStatus}")
    int updateWeChatPayInfo(@Param("id") String id, @Param("tradeNo") String tradeNo, @Param("payStatus") Integer payStatus, @Param("payTime") String payTime);

    @Update("update wechat_pay set qunar_pay_status=#{payStatus},qunar_pay_time=#{payTime} where id=#{id} and qunar_pay_status!=#{payStatus}")
    int updateQunarPayInfo(@Param("id") String id, @Param("payStatus") Integer payStatus, @Param("payTime") String payTime);

    @Delete("delete from wechat_pay where order_no=#{orderNo}")
    int deleteByOrderNo(@Param("orderNo") String orderNo);
}
