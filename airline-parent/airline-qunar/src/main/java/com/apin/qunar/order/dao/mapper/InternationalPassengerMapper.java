package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.InternationalPassenger;
import com.apin.qunar.order.dao.model.InternationalPassengerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InternationalPassengerMapper {
    int countByExample(InternationalPassengerExample example);

    int deleteByExample(InternationalPassengerExample example);

    int deleteByPrimaryKey(String id);

    int insert(InternationalPassenger record);

    int insertSelective(InternationalPassenger record);

    List<InternationalPassenger> selectByExample(InternationalPassengerExample example);

    InternationalPassenger selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") InternationalPassenger record, @Param("example") InternationalPassengerExample example);

    int updateByExample(@Param("record") InternationalPassenger record, @Param("example") InternationalPassengerExample example);

    int updateByPrimaryKeySelective(InternationalPassenger record);

    int updateByPrimaryKey(InternationalPassenger record);
}