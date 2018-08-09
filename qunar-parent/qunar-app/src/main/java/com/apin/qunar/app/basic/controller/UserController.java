package com.apin.qunar.app.basic.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.basic.request.UserRequest;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
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
        String account = userRequest.getAccount();
        String password = userRequest.getPassword();
        User user = userService.queryByAccountAndPwd(account, password);
        GeneralResultMap generalResultMap = new GeneralResultMap();
        try {
            if (user == null) {
                generalResultMap.setResult(SysReturnCode.FAIL);
            } else {
                generalResultMap.setResult(SysReturnCode.SUCC, user);
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
        }
        return generalResultMap;
    }

    @PostMapping(value = "/user/changePassword")
    public GeneralResultMap changePassword(@RequestBody UserRequest userRequest) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        try {
            boolean result = userService.changePassword(userRequest.getAccount(), userRequest.getPassword());
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
}

