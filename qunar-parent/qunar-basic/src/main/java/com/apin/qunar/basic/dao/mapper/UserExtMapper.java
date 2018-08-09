package com.apin.qunar.basic.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @outhor lujian
 * @create 2018-07-19 11:20
 */
public interface UserExtMapper {
    @Update("update user set password=#{password} where account=#{account}")
    int updatePwd(@Param("account") String account, @Param("password") String password);
    @Select("select count(1) from user where account=#{account}")
    int queryCntByAccount(@Param("account") String account);
}