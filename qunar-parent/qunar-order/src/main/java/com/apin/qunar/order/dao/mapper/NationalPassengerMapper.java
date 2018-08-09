package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.NationalPassenger;
import com.apin.qunar.order.dao.model.NationalPassengerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NationalPassengerMapper {
    int countByExample(NationalPassengerExample example);

    int deleteByExample(NationalPassengerExample example);

    int deleteByPrimaryKey(String id);

    int insert(NationalPassenger record);

    int insertSelective(NationalPassenger record);

    List<NationalPassenger> selectByExample(NationalPassengerExample example);

    NationalPassenger selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NationalPassenger record, @Param("example") NationalPassengerExample example);

    int updateByExample(@Param("record") NationalPassenger record, @Param("example") NationalPassengerExample example);

    int updateByPrimaryKeySelective(NationalPassenger record);

    int updateByPrimaryKey(NationalPassenger record);
}