package com.apin.qunar.app.basic.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.basic.request.UserChangePasswordRequest;
import com.apin.qunar.app.basic.request.UserLoginRequest;
import com.apin.qunar.app.basic.request.UserRegisterRequest;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.basic.domain.ExecuteResult;
import com.apin.qunar.basic.domain.user.UserVO;
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
    public GeneralResultMap register(@RequestBody UserRegisterRequest request) {
        String account = request.getAccount();
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/user/register接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ExecuteResult executeResult = userService.register(request.getRealName(), account, request.getPassword(), request.getMobileNo());
            if (executeResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL, executeResult.getDesc());
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
        }
        return generalResultMap;
    }

    @CrossOrigin
    @PostMapping(value = "/user/login")
    public GeneralResultMap login(@RequestBody UserLoginRequest request) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        try {
            UserVO user = userService.login(request.getLoginName(), request.getPassword(), request.getIp());
            if (user == null) {
                generalResultMap.setResult(SysReturnCode.FAIL, "账户名或密码不正确");
            } else {
                generalResultMap.setResult(SysReturnCode.SUCC, user);
            }
        } catch (Exception e) {
            log.error("用户登录异常,request:{}", JSON.toJSON(request), e);
            generalResultMap.setResult(SysReturnCode.FAIL);
        }
        return generalResultMap;
    }

    @PostMapping(value = "/user/changePassword")
    public GeneralResultMap changePassword(@RequestBody UserChangePasswordRequest userRequest) {
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

