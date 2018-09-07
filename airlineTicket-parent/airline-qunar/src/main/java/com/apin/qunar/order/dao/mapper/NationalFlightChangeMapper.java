package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.NationalFlightChange;
import com.apin.qunar.order.dao.model.NationalFlightChangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NationalFlightChangeMapper {
    int countByExample(NationalFlightChangeExample example);

    int deleteByExample(NationalFlightChangeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NationalFlightChange record);

    int insertSelective(NationalFlightChange record);

    List<NationalFlightChange> selectByExample(NationalFlightChangeExample example);

    NationalFlightChange selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NationalFlightChange record, @Param("example") NationalFlightChangeExample example);

    int updateByExample(@Param("record") NationalFlightChange record, @Param("example") NationalFlightChangeExample example);

    int updateByPrimaryKeySelective(NationalFlightChange record);

    int updateByPrimaryKey(NationalFlightChange record);
}