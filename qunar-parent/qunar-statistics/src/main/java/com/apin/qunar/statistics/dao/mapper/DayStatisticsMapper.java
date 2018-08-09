package com.apin.qunar.statistics.dao.mapper;

import com.apin.qunar.statistics.dao.model.DayStatistics;
import com.apin.qunar.statistics.dao.model.DayStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DayStatisticsMapper {
    int countByExample(DayStatisticsExample example);

    int deleteByExample(DayStatisticsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DayStatistics record);

    int insertSelective(DayStatistics record);

    List<DayStatistics> selectByExample(DayStatisticsExample example);

    DayStatistics selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DayStatistics record, @Param("example") DayStatisticsExample example);

    int updateByExample(@Param("record") DayStatistics record, @Param("example") DayStatisticsExample example);

    int updateByPrimaryKeySelective(DayStatistics record);

    int updateByPrimaryKey(DayStatistics record);
}