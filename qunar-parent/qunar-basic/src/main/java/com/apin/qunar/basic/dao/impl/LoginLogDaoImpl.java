package com.apin.qunar.basic.dao.impl;

import com.apin.qunar.basic.dao.mapper.LoginLogExtMapper;
import com.apin.qunar.basic.dao.mapper.LoginLogMapper;
import com.apin.qunar.basic.dao.model.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-19 13:41
 */
@Repository
public class LoginLogDaoImpl {
    @Autowired
    LoginLogMapper loginLogMapper;
    @Autowired
    LoginLogExtMapper loginLogExtMapper;

    public boolean insert(LoginLog loginLog) {
        return loginLogMapper.insert(loginLog) > 0;
    }

    public List<String> queryAccountByInsertTime(Date startTime, Date endTime) {
        return loginLogExtMapper.queryAccountByInsertTime(startTime, endTime);
    }
}
