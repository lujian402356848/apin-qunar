package com.apin.qunar.basic.dao.mapper;

import com.apin.qunar.basic.dao.model.Airline;
import com.apin.qunar.basic.dao.model.AirlineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AirlineMapper {
    int countByExample(AirlineExample example);

    int deleteByExample(AirlineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Airline record);

    int insertSelective(Airline record);

    List<Airline> selectByExample(AirlineExample example);

    Airline selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Airline record, @Param("example") AirlineExample example);

    int updateByExample(@Param("record") Airline record, @Param("example") AirlineExample example);

    int updateByPrimaryKeySelective(Airline record);

    int updateByPrimaryKey(Airline record);
}