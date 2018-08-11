package com.apin.qunar.app.basic.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.basic.request.UserRequest;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.basic.common.enums.SmsSendTypeEnum;
import com.apin.qunar.basic.dao.model.User;
import com.apin.qunar.basic.service.UserService;
import com.apin.qunar.common.enums.SysReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @outhor ligang
 * @create 2018-07-16 09:51
 * 用户注册
 */

@Slf4j
@RestController
@RequestMapping(AppConstants.ROOT_URL)
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/user/register")
    public GeneralResultMap register(@RequestBody UserRequest request) {
        String account = request.getAccount();
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/user/register接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            boolean isExist = userService.isExistAccount(account);
            if (isExist) {
                generalResultMap.setResult(SysReturnCode.FAIL, "该账户已注册,不能重复注册");
                return generalResultMap;
            }
            boolean result = userService.register(request.getRealName(), account, request.getPassword(), request.getMobileNo());
            if (result) {
                generalResultMap.setResult(SysReturnCode.SUCC);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL);
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
        }
        return generalResultMap;
    }

    @CrossOrigin
    @PostMapping(value = "/user/login")
    public GeneralResultMap login(@RequestBody UserRequest userRequest) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        try {
            User user = userService.queryByAccountAndPwd(userRequest.getAccount(), userRequest.getPassword());
            if (user == null) {
                generalResultMap.setResult(SysReturnCode.FAIL, "账户名或密码不正确");
            } else {
                user.setMerchantNo("20180726460336");
                generalResultMap.setResult(SysReturnCode.SUCC, user);
            }
        } catch (Exception e) {
            log.error("用户登录异常,request:{}", JSON.toJSON(userRequest), e);
            generalResultMap.setResult(SysReturnCode.FAIL);
        }
        return generalResultMap;
    }

    @PostMapping(value = "/user/createVerifyCode")
    public GeneralResultMap createVerifyCode(@RequestBody UserRequest userRequest) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        boolean result = false;
        try {
            if (userRequest.getHasLogin() == 1) {
                result = userService.createVerifyCode(userRequest.getAccount(), SmsSendTypeEnum.USER_LOGIN_VERIFY_CODE);
            }
            if (userRequest.getHasLogin() == 2) {
                result = userService.createVerifyCode(userRequest.getAccount(), SmsSendTypeEnum.USER_CHANGE_PASSWORD_VERIFY_CODE);
            }
            if (result) {
                generalResultMap.setResult(SysReturnCode.SUCC);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL);
            }
        } catch (Exception e) {
            log.error("用户登录获取验证码异常,request:{}", userRequest.getAccount(), e);
            generalResultMap.setResult(SysReturnCode.FAIL);
        }
        return generalResultMap;
    }

    @PostMapping(value = "/user/changePassword")
    public GeneralResultMap changePassword(@RequestBody UserRequest userRequest) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        try {
            boolean result = userService.changePassword(userRequest.getAccount(), userRequest.getPassword());
            if (!result) {
                generalResultMap.setResult(SysReturnCode.FAIL, "修改密码失败");
            } else {
                generalResultMap.setResult(SysReturnCode.SUCC, "修改密码成功");
            }
        } catch (Exception e) {
            log.error("用户修改密码异常,request:{}", JSON.toJSON(userRequest), e);
            generalResultMap.setResult(SysReturnCode.FAIL);
        }
        return generalResultMap;
    }
}

