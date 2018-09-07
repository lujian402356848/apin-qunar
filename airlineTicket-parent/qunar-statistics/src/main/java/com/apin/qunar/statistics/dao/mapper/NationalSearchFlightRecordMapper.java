package com.apin.qunar.statistics.dao.mapper;

import com.apin.qunar.statistics.dao.model.NationalSearchFlightRecord;
import com.apin.qunar.statistics.dao.model.NationalSearchFlightRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NationalSearchFlightRecordMapper {
    int countByExample(NationalSearchFlightRecordExample example);

    int deleteByExample(NationalSearchFlightRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NationalSearchFlightRecord record);

    int insertSelective(NationalSearchFlightRecord record);

    List<NationalSearchFlightRecord> selectByExample(NationalSearchFlightRecordExample example);

    NationalSearchFlightRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NationalSearchFlightRecord record, @Param("example") NationalSearchFlightRecordExample example);

    int updateByExample(@Param("record") NationalSearchFlightRecord record, @Param("example") NationalSearchFlightRecordExample example);

    int updateByPrimaryKeySelective(NationalSearchFlightRecord record);

    int updateByPrimaryKey(NationalSearchFlightRecord record);
}