package com.apin.qunar.statistics.dao.mapper;

import com.apin.qunar.statistics.dao.model.InternationalSearchFlightRecord;
import com.apin.qunar.statistics.dao.model.InternationalSearchFlightRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InternationalSearchFlightRecordMapper {
    int countByExample(InternationalSearchFlightRecordExample example);

    int deleteByExample(InternationalSearchFlightRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InternationalSearchFlightRecord record);

    int insertSelective(InternationalSearchFlightRecord record);

    List<InternationalSearchFlightRecord> selectByExample(InternationalSearchFlightRecordExample example);

    InternationalSearchFlightRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InternationalSearchFlightRecord record, @Param("example") InternationalSearchFlightRecordExample example);

    int updateByExample(@Param("record") InternationalSearchFlightRecord record, @Param("example") InternationalSearchFlightRecordExample example);

    int updateByPrimaryKeySelective(InternationalSearchFlightRecord record);

    int updateByPrimaryKey(InternationalSearchFlightRecord record);
}