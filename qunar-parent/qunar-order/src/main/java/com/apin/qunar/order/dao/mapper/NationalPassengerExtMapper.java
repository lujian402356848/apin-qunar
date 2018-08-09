package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.NationalPassenger;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-02 17:31
 */
public interface NationalPassengerExtMapper {
    @Select("select order_no as orderNo,name from national_passenger where order_no in(${orderNos})")
    List<NationalPassenger> queryByOrderNo(@Param("orderNos") String orderNos);

    @Select("select mobile_no from national_passenger where order_no=#{orderNo}")
    List<String> queryMobileNoByOrderNo(@Param("orderNo") String orderNo);
}
