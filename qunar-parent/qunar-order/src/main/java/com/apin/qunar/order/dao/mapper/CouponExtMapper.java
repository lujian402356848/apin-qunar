package com.apin.qunar.order.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface CouponExtMapper {
    @Update("update coupon set status=#{Status} where id=#{Id} and status!=#{Status}")
    int updateStatus(@Param("id") Long id, @Param("status") int status);
}
