package com.apin.qunar.basic.service.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.basic.common.constant.SmsConstants;
import com.apin.qunar.basic.common.enums.AccountTypeEnum;
import com.apin.qunar.basic.common.enums.SmsSendTypeEnum;
import com.apin.qunar.basic.dao.impl.LoginLogDaoImpl;
import com.apin.qunar.basic.dao.impl.UserDaoImpl;
import com.apin.qunar.basic.dao.model.LoginLog;
import com.apin.qunar.basic.dao.model.User;
import com.apin.qunar.basic.service.SmsService;
import com.apin.qunar.basic.service.UserService;
import com.apin.qunar.common.ids.IDGenerator;
import com.google.common.cache.Cache;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private Cache<String, String> verifyCodeCache = com.google.common.cache.CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(1, TimeUnit.MINUTES).build();
    @Autowired
    private UserDaoImpl userDao;
    @Autowired
    private LoginLogDaoImpl loginLogDao;
    @Autowired
    private SmsService smsService;

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
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            return null;
        }
        User user = userDao.queryByAccountAndPwd(account, password);
        addLoginLog(user);
        return user;
    }

    private void addLoginLog(User user) {
        if (user == null) {
            return;
        }
        LoginLog loginLog = buildLoginLog(user);
        try {
            loginLogDao.insert(loginLog);
        } catch (Exception e) {
            log.error("增加登录日志有误，user:{}", JSON.toJSON(user), e);
        }
    }

    private LoginLog buildLoginLog(User user) {
        LoginLog loginLog = new LoginLog();
        loginLog.setId(IDGenerator.getUniqueId());
        loginLog.setAccount(user.getAccount());
        loginLog.setLoginTime(new Date());
        return loginLog;
    }

    @Override
    public boolean isExistAccount(String account) {
        return userDao.isExistAccount(account);
    }

    @Override
    public boolean changePassword(String account, String password) {
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            return false;
        }
        return userDao.updatePwd(account, password);
    }

    @Override
    public boolean createVerifyCode(String account, SmsSendTypeEnum smsSendTypeEnum) {
        boolean result = false;
        try {
            User user = new User();
            user.setAccount(account);
            sendSms(user, smsSendTypeEnum);
            result = true;
        } catch (Exception e) {
            log.error("用户登录或修改密码的验证码获取异常,account:{}", account, e);
        }
        return result;
    }

    @Override
    public boolean validateVerifyCode(String account, String verifyCode) {
        boolean result = false;
        try {
            if (StringUtils.isBlank(account) || StringUtils.isBlank(verifyCode)) {
                return false;
            }
            if (verifyCode.equals(verifyCodeCache.getIfPresent(account))) {
                result = true;
            }
        } catch (Exception e) {
            log.error("验证码验证异常,request:{}", account, verifyCode, e);
        }
        return result;
    }

    private void sendSms(User user, SmsSendTypeEnum smsSendTypeEnum) {
        String verifyCode = null;
        String verifyCodeContent = null;
        switch (smsSendTypeEnum) {
            case USER_LOGIN_VERIFY_CODE:
                verifyCode = getVerifyCode(user);
                verifyCodeContent = String.format(SmsConstants.USER_LOGIN_VERIFY_CODE, verifyCode);
                smsService.sendSms(user.getAccount(), verifyCodeContent, SmsSendTypeEnum.USER_LOGIN_VERIFY_CODE);
                break;
            case USER_CHANGE_PASSWORD_VERIFY_CODE:
                verifyCode = getVerifyCode(user);
                verifyCodeContent = String.format(SmsConstants.USER_CHANGE_PASSWORD_VERIFY_CODE, verifyCode);
                smsService.sendSms(user.getAccount(), verifyCodeContent, SmsSendTypeEnum.USER_CHANGE_PASSWORD_VERIFY_CODE);
                break;
        }
    }

    private String getVerifyCode(User user) {
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);//生成短信验证
        verifyCodeCache.put(user.getAccount(), verifyCode);
        return verifyCode;
    }
}
