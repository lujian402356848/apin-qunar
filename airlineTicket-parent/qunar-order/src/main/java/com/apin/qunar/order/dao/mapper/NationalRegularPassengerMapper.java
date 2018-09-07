package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.NationalRegularPassenger;
import com.apin.qunar.order.dao.model.NationalRegularPassengerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NationalRegularPassengerMapper {
    int countByExample(NationalRegularPassengerExample example);

    int deleteByExample(NationalRegularPassengerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NationalRegularPassenger record);

    int insertSelective(NationalRegularPassenger record);

    List<NationalRegularPassenger> selectByExample(NationalRegularPassengerExample example);

    NationalRegularPassenger selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NationalRegularPassenger record, @Param("example") NationalRegularPassengerExample example);

    int updateByExample(@Param("record") NationalRegularPassenger record, @Param("example") NationalRegularPassengerExample example);

    int updateByPrimaryKeySelective(NationalRegularPassenger record);

    int updateByPrimaryKey(NationalRegularPassenger record);
}