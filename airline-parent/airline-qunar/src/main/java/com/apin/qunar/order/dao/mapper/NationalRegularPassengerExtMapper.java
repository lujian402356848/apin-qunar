package com.apin.qunar.order.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface NationalRegularPassengerExtMapper {
    @Select("select count(1) from national_regular_passenger where card_no=#{cardNo}")
    int queryCntByCardNo(@Param("cardNo") String cardNo);
}
