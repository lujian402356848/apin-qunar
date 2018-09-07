package com.apin.qunar.basic.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface LoginLogExtMapper {
    @Select("select distinct account from login_log where insert_time>=#{startTime} and insert_time<=#{endTime}")
    List<String> queryAccountByInsertTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);
}