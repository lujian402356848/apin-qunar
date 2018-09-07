package com.apin.qunar.basic.dao.mapper;

import com.apin.qunar.basic.dao.model.AirlinePriceRate;
import com.apin.qunar.basic.dao.model.AirlinePriceRateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AirlinePriceRateMapper {
    int countByExample(AirlinePriceRateExample example);

    int deleteByExample(AirlinePriceRateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AirlinePriceRate record);

    int insertSelective(AirlinePriceRate record);

    List<AirlinePriceRate> selectByExample(AirlinePriceRateExample example);

    AirlinePriceRate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AirlinePriceRate record, @Param("example") AirlinePriceRateExample example);

    int updateByExample(@Param("record") AirlinePriceRate record, @Param("example") AirlinePriceRateExample example);

    int updateByPrimaryKeySelective(AirlinePriceRate record);

    int updateByPrimaryKey(AirlinePriceRate record);
}