package com.apin.qunar.basic.dao.mapper;

import com.apin.qunar.basic.dao.model.Sms;
import com.apin.qunar.basic.dao.model.SmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsMapper {
    int countByExample(SmsExample example);

    int deleteByExample(SmsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Sms record);

    int insertSelective(Sms record);

    List<Sms> selectByExample(SmsExample example);

    Sms selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sms record, @Param("example") SmsExample example);

    int updateByExample(@Param("record") Sms record, @Param("example") SmsExample example);

    int updateByPrimaryKeySelective(Sms record);

    int updateByPrimaryKey(Sms record);
}