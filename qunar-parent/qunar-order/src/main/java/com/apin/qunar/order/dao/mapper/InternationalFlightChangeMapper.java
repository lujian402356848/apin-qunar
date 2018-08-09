package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.InternationalFlightChange;
import com.apin.qunar.order.dao.model.InternationalFlightChangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InternationalFlightChangeMapper {
    int countByExample(InternationalFlightChangeExample example);

    int deleteByExample(InternationalFlightChangeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InternationalFlightChange record);

    int insertSelective(InternationalFlightChange record);

    List<InternationalFlightChange> selectByExample(InternationalFlightChangeExample example);

    InternationalFlightChange selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InternationalFlightChange record, @Param("example") InternationalFlightChangeExample example);

    int updateByExample(@Param("record") InternationalFlightChange record, @Param("example") InternationalFlightChangeExample example);

    int updateByPrimaryKeySelective(InternationalFlightChange record);

    int updateByPrimaryKey(InternationalFlightChange record);
}