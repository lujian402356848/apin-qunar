package com.apin.qunar.statistics.dao.mapper;

import com.apin.qunar.statistics.dao.model.NationalSearchCityStatistics;
import com.apin.qunar.statistics.dao.model.NationalSearchCityStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NationalSearchCityStatisticsMapper {
    int countByExample(NationalSearchCityStatisticsExample example);

    int deleteByExample(NationalSearchCityStatisticsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NationalSearchCityStatistics record);

    int insertSelective(NationalSearchCityStatistics record);

    List<NationalSearchCityStatistics> selectByExample(NationalSearchCityStatisticsExample example);

    NationalSearchCityStatistics selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NationalSearchCityStatistics record, @Param("example") NationalSearchCityStatisticsExample example);

    int updateByExample(@Param("record") NationalSearchCityStatistics record, @Param("example") NationalSearchCityStatisticsExample example);

    int updateByPrimaryKeySelective(NationalSearchCityStatistics record);

    int updateByPrimaryKey(NationalSearchCityStatistics record);
}