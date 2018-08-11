package com.apin.qunar.basic.dao.impl;


import com.apin.qunar.basic.dao.mapper.UserExtMapper;
import com.apin.qunar.basic.dao.mapper.UserMapper;
import com.apin.qunar.basic.dao.model.User;
import com.apin.qunar.basic.dao.model.UserExample;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @outhor ligang
 * @create 2018-07-16 10:18
 */
@Repository
public class UserDaoImpl {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserExtMapper userExtMapper;

    public boolean insert(User user) {
        return userMapper.insert(user) > 0;
    }


    public User queryByAccount(String account) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(account);
        criteria.andHasEnableEqualTo(1);
        List<User> users = userMapper.selectByExample(example);
        return CollectionUtils.isEmpty(users) ? null : users.get(0);
    }

    public User queryByAccountAndPwd(String account, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(account);
        criteria.andPasswordEqualTo(password);
        criteria.andHasEnableEqualTo(1);
        List<User> users = userMapper.selectByExample(example);
        return CollectionUtils.isEmpty(users) ? null : users.get(0);
    }

    public boolean isExistAccount(String account) {
        return userExtMapper.queryCntByAccount(account) > 0;
    }

    public boolean updatePwd(String accout, String password) {
        return userExtMapper.updatePwd(accout, password) > 0;
    }
}
