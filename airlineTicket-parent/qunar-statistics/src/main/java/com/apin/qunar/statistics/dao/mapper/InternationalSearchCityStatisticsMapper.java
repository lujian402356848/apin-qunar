package com.apin.qunar.statistics.dao.mapper;

import com.apin.qunar.statistics.dao.model.InternationalSearchCityStatistics;
import com.apin.qunar.statistics.dao.model.InternationalSearchCityStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InternationalSearchCityStatisticsMapper {
    int countByExample(InternationalSearchCityStatisticsExample example);

    int deleteByExample(InternationalSearchCityStatisticsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InternationalSearchCityStatistics record);

    int insertSelective(InternationalSearchCityStatistics record);

    List<InternationalSearchCityStatistics> selectByExample(InternationalSearchCityStatisticsExample example);

    InternationalSearchCityStatistics selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InternationalSearchCityStatistics record, @Param("example") InternationalSearchCityStatisticsExample example);

    int updateByExample(@Param("record") InternationalSearchCityStatistics record, @Param("example") InternationalSearchCityStatisticsExample example);

    int updateByPrimaryKeySelective(InternationalSearchCityStatistics record);

    int updateByPrimaryKey(InternationalSearchCityStatistics record);
}