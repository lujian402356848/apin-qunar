package com.apin.qunar.app.basic.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.basic.request.*;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.basic.common.enums.AuditStatusEnum;
import com.apin.qunar.basic.dao.model.Merchant;
import com.apin.qunar.basic.domain.merchant.MerchantVO;
import com.apin.qunar.basic.service.MerchantService;
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
 * @create 2018-07-23 15:02
 */

@Slf4j
@RestController
@RequestMapping(AppConstants.ROOT_URL)
public class MerchantController extends BaseController {
    @Autowired
    private MerchantService merchantService;

    @PostMapping(value = "/merchant/list")
    public GeneralResultMap searchMerchantList(@RequestBody SearchMerchantListRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/merchant/list接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        Map<String, Object> data = new HashMap<>();
        if (request.getOffset() == null || request.getOffset() < 0) {
            request.setOffset(0);
        }
        if (request.getLimit() == null || request.getLimit() <= 0) {
            request.setLimit(20);
        }
        try {
            List<MerchantVO> merchantVOS = merchantService.queryPageListBy(request.getOffset(), request.getLimit());
            data.put("merchantList", merchantVOS);
            generalResultMap.setResult(SysReturnCode.SUCC, data);
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("查询商户列表异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    @PostMapping(value = "/merchant/register")
    public GeneralResultMap register(@RequestBody CreateMerchantRequest request) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        try {
            if (merchantService.isExistContactMobile(request.getContactMobile())) {
                generalResultMap.setResult(SysReturnCode.FAIL, "手机号已注册");
                return generalResultMap;
            }
            boolean result = merchantService.register(buildMerchant(request));
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

    @PostMapping(value = "/merchant/createRegisterVerifyCode")
    public GeneralResultMap creatVerifyCode(@RequestBody CreateMerchantRequest request) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        try {
            boolean result = merchantService.createVerifyCode(request.getContactMobile());
            if (result) {
                generalResultMap.setResult(SysReturnCode.SUCC);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL);
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("商户注册获取验证码异常,request:{}", request.getContactMobile(), e);
        }
        return generalResultMap;
    }

    private Merchant buildMerchant(CreateMerchantRequest request) {
        Merchant merchant = new Merchant();
        merchant.setId(IDGenerator.getUniqueId());
        merchant.setContactName(request.getContactName());
        merchant.setContactMobile(request.getContactMobile());
        merchant.setCompanyName(request.getCompanyName());
        merchant.setCompanyAddress(request.getCompanyAddress());
        merchant.setManagerName(request.getManagerName());
        merchant.setAuditStatus(AuditStatusEnum.AWAITAUDIT.getCode());
        return merchant;
    }

    @PostMapping(value = "/merchant/change")
    public GeneralResultMap change(@RequestBody ChangeMerchantRequest request) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        try {
            boolean result = merchantService.change(buildMerchant(request));
            if (result) {
                generalResultMap.setResult(SysReturnCode.SUCC);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL);
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("商户变更异常,request:{}", JSON.toJSON(request), e);
        }
        return generalResultMap;
    }

    private Merchant buildMerchant(ChangeMerchantRequest request) {
        Merchant merchant = new Merchant();
        merchant.setMerchantNo(request.getMerchantNo());
        merchant.setContactName(request.getContactName());
        merchant.setContactMobile(request.getContactMobile());
        merchant.setCompanyName(request.getCompanyName());
        merchant.setCompanyAddress(request.getCompanyAddress());
        return merchant;
    }

    @PostMapping(value = "/merchant/checkVerifyCode")
    public GeneralResultMap checkVerifyCode(@RequestBody CheckVerifyCodeRequest request) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        try {
            boolean result = merchantService.checkVerifyCode(request.getMerchantNo(), request.getVerifyCode());
            if (result) {
                generalResultMap.setResult(SysReturnCode.SUCC);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL, "校验码不正确");
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("校验码验证异常,request:{}", JSON.toJSON(request), e);
        }
        return generalResultMap;
    }

    @PostMapping(value = "/merchant/audit")
    public GeneralResultMap audit(@RequestBody AuditMerchantRequest request) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        try {
            boolean result = merchantService.audit(request.getContactMobile(), request.getAuditUser(), AuditStatusEnum.valueOf(request.getAuditStatus()));
            if (result) {
                generalResultMap.setResult(SysReturnCode.SUCC);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL);
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("商户审核异常,request:{}", JSON.toJSON(request), e);
        }
        return generalResultMap;
    }
}
