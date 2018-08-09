package com.apin.qunar.basic.dao.impl;

import com.apin.qunar.basic.dao.mapper.LoginLogMapper;
import com.apin.qunar.basic.dao.model.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @outhor lujian
 * @create 2018-07-19 13:41
 */
@Repository
public class LoginLogDaoImpl {
    @Autowired
    LoginLogMapper loginLogMapper;

    public boolean insert(LoginLog loginLog) {
        return loginLogMapper.insert(loginLog) > 0;
    }
}
