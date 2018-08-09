package com.apin.qunar.statistics.dao.mapper;

import com.apin.qunar.statistics.dao.model.SearchFlightRecord;
import com.apin.qunar.statistics.dao.model.SearchFlightRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SearchFlightRecordMapper {
    int countByExample(SearchFlightRecordExample example);

    int deleteByExample(SearchFlightRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SearchFlightRecord record);

    int insertSelective(SearchFlightRecord record);

    List<SearchFlightRecord> selectByExample(SearchFlightRecordExample example);

    SearchFlightRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SearchFlightRecord record, @Param("example") SearchFlightRecordExample example);

    int updateByExample(@Param("record") SearchFlightRecord record, @Param("example") SearchFlightRecordExample example);

    int updateByPrimaryKeySelective(SearchFlightRecord record);

    int updateByPrimaryKey(SearchFlightRecord record);
}