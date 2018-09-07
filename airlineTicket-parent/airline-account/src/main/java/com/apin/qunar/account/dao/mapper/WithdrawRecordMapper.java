package com.apin.qunar.account.dao.mapper;

import com.apin.qunar.account.dao.model.WithdrawRecord;
import com.apin.qunar.account.dao.model.WithdrawRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WithdrawRecordMapper {
    int countByExample(WithdrawRecordExample example);

    int deleteByExample(WithdrawRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(WithdrawRecord record);

    int insertSelective(WithdrawRecord record);

    List<WithdrawRecord> selectByExample(WithdrawRecordExample example);

    WithdrawRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WithdrawRecord record, @Param("example") WithdrawRecordExample example);

    int updateByExample(@Param("record") WithdrawRecord record, @Param("example") WithdrawRecordExample example);

    int updateByPrimaryKeySelective(WithdrawRecord record);

    int updateByPrimaryKey(WithdrawRecord record);
}