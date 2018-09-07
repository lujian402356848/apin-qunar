package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.InternationalPassenger;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-09 10:34
 */
public interface InternationalPassengerExtMapper {
    @Select("select order_no as orderNo,name from international_passenger where order_no in(${orderNos})")
    List<InternationalPassenger> queryByOrderNo(@Param("orderNos") String orderNos);

    @Select("select mobile_no from international_passenger where order_no=#{orderNo}")
    List<String> queryMobileNoByOrderNo(@Param("orderNo") String orderNo);
}
