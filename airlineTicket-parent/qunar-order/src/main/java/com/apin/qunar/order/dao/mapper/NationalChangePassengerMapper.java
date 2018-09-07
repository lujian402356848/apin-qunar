package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.NationalChangePassenger;
import com.apin.qunar.order.dao.model.NationalChangePassengerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NationalChangePassengerMapper {
    int countByExample(NationalChangePassengerExample example);

    int deleteByExample(NationalChangePassengerExample example);

    int deleteByPrimaryKey(String id);

    int insert(NationalChangePassenger record);

    int insertSelective(NationalChangePassenger record);

    List<NationalChangePassenger> selectByExample(NationalChangePassengerExample example);

    NationalChangePassenger selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NationalChangePassenger record, @Param("example") NationalChangePassengerExample example);

    int updateByExample(@Param("record") NationalChangePassenger record, @Param("example") NationalChangePassengerExample example);

    int updateByPrimaryKeySelective(NationalChangePassenger record);

    int updateByPrimaryKey(NationalChangePassenger record);
}