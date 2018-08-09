package com.apin.qunar.basic.service;


import com.apin.qunar.basic.common.enums.SmsSendTypeEnum;
import com.apin.qunar.basic.dao.model.User;

import java.util.List;

/**
 * @outhor ligang
 * @create 2018-07-16 10:49
 */
public interface UserService {

    boolean register(String name, String account, String password, String department);

    User queryByAccountAndPwd(String account, String password);

    boolean isExistAccount(String account);

    boolean changePassword(String account, String password);

    boolean createVerifyCode(String account,SmsSendTypeEnum smsSendTypeEnum);

    boolean validateVerifyCode(String account,String verifyCode);

    User queryByAccount(String account);
}
