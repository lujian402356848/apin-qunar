package com.apin.qunar.basic.service.impl;

import com.apin.qunar.basic.common.enums.AccountTypeEnum;
import com.apin.qunar.basic.dao.impl.LoginLogDaoImpl;
import com.apin.qunar.basic.dao.impl.UserDaoImpl;
import com.apin.qunar.basic.dao.model.LoginLog;
import com.apin.qunar.basic.dao.model.User;
import com.apin.qunar.basic.service.UserService;
import com.apin.qunar.common.ids.IDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDaoImpl userDao;
    @Autowired
    private LoginLogDaoImpl loginLogDao;

    @Override
    public boolean register(String name, String account, String password, String department) {
        boolean isExist = userDao.isExistAccount(account);
        if (isExist) {
            log.warn("该用户账户已经存在,account:{}", account);
            return false;
        }
        User user = new User();
        user.setId(IDGenerator.getUniqueId());
        user.setAccount(account);
        user.setAccountType(AccountTypeEnum.EMPLOYEE.getCode());
        user.setRealName(name);
        user.setPassword(password);
        user.setDepartment(department);
        user.setHasAdmin(0);
        user.setHasEnable(1);
        return userDao.insert(user);
    }

    @Override
    public User queryByAccountAndPwd(String account, String password) {
        User user = userDao.queryByAccountAndPwd(account, password);
        if (user != null) {
            LoginLog loginLog = new LoginLog();
            loginLog.setId(IDGenerator.getUniqueId());
            loginLog.setAccount(account);
            loginLog.setLoginTime(new Date());
            loginLogDao.insert(loginLog);
        }
        return user;
    }
    @Override
    public boolean isExistAccount(String account){
        return userDao.isExistAccount(account);
    }

    @Override
    public boolean changePassword(String account, String password) {
        return userDao.updatePwd(account, password);
    }
}
