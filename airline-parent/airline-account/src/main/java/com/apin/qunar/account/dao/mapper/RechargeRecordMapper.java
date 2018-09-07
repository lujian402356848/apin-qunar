package com.apin.qunar.account.dao.mapper;

import com.apin.qunar.account.dao.model.RechargeRecord;
import com.apin.qunar.account.dao.model.RechargeRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RechargeRecordMapper {
    int countByExample(RechargeRecordExample example);

    int deleteByExample(RechargeRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(RechargeRecord record);

    int insertSelective(RechargeRecord record);

    List<RechargeRecord> selectByExample(RechargeRecordExample example);

    RechargeRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RechargeRecord record, @Param("example") RechargeRecordExample example);

    int updateByExample(@Param("record") RechargeRecord record, @Param("example") RechargeRecordExample example);

    int updateByPrimaryKeySelective(RechargeRecord record);

    int updateByPrimaryKey(RechargeRecord record);
}