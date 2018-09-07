package com.apin.qunar.basic.dao.mapper;

import com.apin.qunar.basic.dao.model.AirportSearch;
import com.apin.qunar.basic.dao.model.AirportSearchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AirportSearchMapper {
    int countByExample(AirportSearchExample example);

    int deleteByExample(AirportSearchExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AirportSearch record);

    int insertSelective(AirportSearch record);

    List<AirportSearch> selectByExample(AirportSearchExample example);

    AirportSearch selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AirportSearch record, @Param("example") AirportSearchExample example);

    int updateByExample(@Param("record") AirportSearch record, @Param("example") AirportSearchExample example);

    int updateByPrimaryKeySelective(AirportSearch record);

    int updateByPrimaryKey(AirportSearch record);
}