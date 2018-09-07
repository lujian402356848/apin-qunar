package com.apin.qunar.statistics.dao.mapper;

import com.apin.qunar.statistics.dao.model.DayMerchantStatistics;
import com.apin.qunar.statistics.dao.model.DayMerchantStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DayMerchantStatisticsMapper {
    int countByExample(DayMerchantStatisticsExample example);

    int deleteByExample(DayMerchantStatisticsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DayMerchantStatistics record);

    int insertSelective(DayMerchantStatistics record);

    List<DayMerchantStatistics> selectByExample(DayMerchantStatisticsExample example);

    DayMerchantStatistics selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DayMerchantStatistics record, @Param("example") DayMerchantStatisticsExample example);

    int updateByExample(@Param("record") DayMerchantStatistics record, @Param("example") DayMerchantStatisticsExample example);

    int updateByPrimaryKeySelective(DayMerchantStatistics record);

    int updateByPrimaryKey(DayMerchantStatistics record);
}