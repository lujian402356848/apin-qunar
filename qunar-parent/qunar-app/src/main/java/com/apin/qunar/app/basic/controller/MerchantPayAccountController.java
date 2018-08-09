package com.apin.qunar.app.basic.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.basic.request.CreateMerchantPayAccountRequest;
import com.apin.qunar.app.basic.request.SearchMerchantPayAccountListRequest;
import com.apin.qunar.app.basic.request.SetMerchantPayPasswordRequest;
import com.apin.qunar.app.basic.request.UnbindMerchantPayAccountRequest;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.basic.common.enums.PayAccountStausEnum;
import com.apin.qunar.basic.dao.model.MerchantPayAccount;
import com.apin.qunar.basic.service.MerchantPayAccountService;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.common.ids.IDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @outhor lujian
 * @create 2018-07-25 18:57
 */

@Slf4j
@RestController
@RequestMapping(AppConstants.ROOT_URL)
public class MerchantPayAccountController extends BaseController {
    @Autowired
    private MerchantPayAccountService merchantPayAccountService;

    @PostMapping(value = "/merchantPayAccount/list")
    public GeneralResultMap list(@RequestBody SearchMerchantPayAccountListRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/merchantPayAccount/list接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        Map<String, Object> data = new HashMap<>();
        try {
            List<MerchantPayAccount> merchantPayAccounts = merchantPayAccountService.queryByMerchantNo(request.getMerchantNo());
            data.put("merchantPayAccountList", merchantPayAccounts);
            generalResultMap.setResult(SysReturnCode.SUCC, data);
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("查询商户支付账户列表异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    @PostMapping(value = "/merchantPayAccount/register")
    public GeneralResultMap register(@RequestBody CreateMerchantPayAccountRequest request) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        try {
            boolean result = merchantPayAccountService.register(buildMerchantPayAccount(request));
            if (result) {
                generalResultMap.setResult(SysReturnCode.SUCC);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL);
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("商户注册异常,request:{}", JSON.toJSON(request), e);
        }
        return generalResultMap;
    }

    @PostMapping(value = "/merchantPayAccount/unbind")
    public GeneralResultMap unbind(@RequestBody UnbindMerchantPayAccountRequest request) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        try {
            boolean result = false;// merchantPayAccountService.register(buildMerchantPayAccount(request));
            if (result) {
                generalResultMap.setResult(SysReturnCode.SUCC);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL);
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("商户注册异常,request:{}", JSON.toJSON(request), e);
        }
        return generalResultMap;
    }

    @PostMapping(value = "/merchantPayAccount/changePassword")
    public GeneralResultMap register(@RequestBody SetMerchantPayPasswordRequest request) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        try {
            boolean result = merchantPayAccountService.setPayPassword(request.getMerchantNo(), request.getAccount(), request.getPassword());
            if (result) {
                generalResultMap.setResult(SysReturnCode.SUCC);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL);
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("商户注册异常,request:{}", JSON.toJSON(request), e);
        }
        return generalResultMap;
    }

    @PostMapping(value = "/merchantPayAccount/remove")
    public GeneralResultMap remove(@RequestBody SetMerchantPayPasswordRequest request) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        try {
            boolean result = merchantPayAccountService.removePayAccount(request.getMerchantNo(), request.getAccount());
            if (result) {
                generalResultMap.setResult(SysReturnCode.SUCC);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL);
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("移除商户支付账户异常,request:{}", JSON.toJSON(request), e);
        }
        return generalResultMap;
    }

    private MerchantPayAccount buildMerchantPayAccount(CreateMerchantPayAccountRequest request) {
        MerchantPayAccount merchant = new MerchantPayAccount();
        merchant.setId(IDGenerator.getUniqueId());
        merchant.setMerchantNo(request.getMerchantNo());
        merchant.setAccount(request.getAccount());
        merchant.setAccountType(request.getAccountType());
        merchant.setAccountStaus(PayAccountStausEnum.NOSIGN.getCode());
        return merchant;
    }


}
