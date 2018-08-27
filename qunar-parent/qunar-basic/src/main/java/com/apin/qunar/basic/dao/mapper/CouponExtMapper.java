package com.apin.qunar.basic.dao.mapper;

import com.apin.qunar.basic.domain.coupon.CouponVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CouponExtMapper {
    @Select("select id,coupon_money,coupon_type,coupon_status,insert_time from coupon where status & #{status} ORDER BY insert_time desc limit #{offset},#{limit}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "couponMoney", column = "coupon_money"),
            @Result(property = "couponType", column = "coupon_type"),
            @Result(property = "couponStatus", column = "coupon_status"),
            @Result(property = "insertTime", column = "insert_time"),
    })
    List<CouponVO> queryBy(@Param("account") String account, @Param("status") Integer status, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Update("update coupon set coupon_status=#{status} where id=#{id} and coupon_status!=#{status}")
    int updateStatus(@Param("id") Long id, @Param("status") Integer status);
}