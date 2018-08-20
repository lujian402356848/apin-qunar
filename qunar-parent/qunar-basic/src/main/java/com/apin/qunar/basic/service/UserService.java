package com.apin.qunar.basic.service;


import com.apin.qunar.basic.dao.model.User;
import com.apin.qunar.basic.domain.ExecuteResult;

/**
 * @outhor ligang
 * @create 2018-07-16 10:49
 */
public interface UserService {
    ExecuteResult register(String name, String account, String password, String department);

    User login(String account, String password, String ip);

    boolean changePassword(String account, String password);
}
