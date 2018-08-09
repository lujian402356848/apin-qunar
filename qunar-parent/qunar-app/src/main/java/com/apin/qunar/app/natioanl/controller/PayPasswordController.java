package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.PayPasswordRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @outhor lujian
 * @create 2018-06-23 22:29
 * 支付密码校验
 */
@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class PayPasswordController extends BaseController {

    @PostMapping(value = "/order/payPassword")
    public GeneralResultMap payPassword(@RequestBody PayPasswordRequest payPasswordRequest) {
        GeneralResultMap generalResultMap = validateCommonParam(payPasswordRequest);
        if (!generalResultMap.isSuccess()) {
            log.warn("/order/payPassword接口基础验证不通过，request:{}", JSON.toJSON(payPasswordRequest));
            return generalResultMap;
        }
        Map<String, Object> data = new HashMap<>();
        try {
            if (!payPasswordRequest.getPassword().isEmpty() && "S7DROWnGLR".equals(payPasswordRequest.getPassword())) {
                data.put("data", "密码验证成功！");
                generalResultMap.setResult(SysReturnCode.SUCC, data);
            } else {
                data.put("data", "支付密码有误！");
                generalResultMap.setResult(SysReturnCode.FAIL, data);
            }

        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("支付密码校验有异常:{}", payPasswordRequest, e);
        }
        return generalResultMap;
    }

}
