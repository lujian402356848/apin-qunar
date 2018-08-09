package com.apin.qunar.order.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface InternationalRegularPassengerExtMapper {
    @Select("select count(1) from international_regular_passenger where card_no=#{cardNo}")
    int queryCntByCardNo(@Param("cardNo") String cardNo);
}
