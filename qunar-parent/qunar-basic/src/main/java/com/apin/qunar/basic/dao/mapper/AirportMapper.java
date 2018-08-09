package com.apin.qunar.basic.dao.mapper;

import com.apin.qunar.basic.dao.model.Airport;
import com.apin.qunar.basic.dao.model.AirportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AirportMapper {
    int countByExample(AirportExample example);

    int deleteByExample(AirportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Airport record);

    int insertSelective(Airport record);

    List<Airport> selectByExample(AirportExample example);

    Airport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Airport record, @Param("example") AirportExample example);

    int updateByExample(@Param("record") Airport record, @Param("example") AirportExample example);

    int updateByPrimaryKeySelective(Airport record);

    int updateByPrimaryKey(Airport record);
}