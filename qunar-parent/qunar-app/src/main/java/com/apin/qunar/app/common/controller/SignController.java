package com.apin.qunar.app.common.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.common.domain.SearchSignRequest;
import com.apin.qunar.app.common.domain.SignRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.common.searchSign.SearchSignParam;
import com.apin.qunar.order.domain.common.searchSign.SearchSignResultVO;
import com.apin.qunar.order.domain.common.sign.SignParam;
import com.apin.qunar.order.service.common.SearchSignService;
import com.apin.qunar.order.service.common.SignService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping(AppConstants.ROOT_URL)
public class SignController extends BaseController {
    @Autowired
    SignService signService;

    @Autowired
    SearchSignService searchSignService;

    @PostMapping(value = "/alipay/sign")
    public GeneralResultMap sign(@RequestBody SignRequest signRequest) {
        GeneralResultMap generalResultMap = validateCommonParam(signRequest);
        if (!generalResultMap.isSuccess()) {
            log.warn("/alipay/sign接口基础验证不通过，request:{}", JSON.toJSON(signRequest));
            return generalResultMap;
        }
        try {
            String html = signService.sign(buildSignParam(signRequest));

            if (StringUtils.isBlank(html)) {
                generalResultMap.setResult(SysReturnCode.FAIL);
            } else {
                generalResultMap.setData(html);
                generalResultMap.setResult(SysReturnCode.SUCC);
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("支付签约异常,request:{}", signRequest, e);
        }
        return generalResultMap;
    }
    @PostMapping(value = "/alipay/searchSign")
    public GeneralResultMap searchSign(@RequestBody SearchSignRequest searchSignRequest) {
        GeneralResultMap generalResultMap = validateCommonParam(searchSignRequest);
        if (!generalResultMap.isSuccess()) {
            log.warn("/alipay/searchSign接口基础验证不通过，request:{}", JSON.toJSON(searchSignRequest));
            return generalResultMap;
        }
        try {
            ApiResult<SearchSignResultVO> searchSignResultVOApiResult = searchSignService.searchSign(buildSearchSignParam(searchSignRequest));

            if (searchSignResultVOApiResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC);
                generalResultMap.setData(searchSignResultVOApiResult.getResult());
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL);
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("支付签约查询异常,request:{}", searchSignRequest, e);
        }
        return generalResultMap;
    }
    private SearchSignParam buildSearchSignParam(SearchSignRequest request) {
        SearchSignParam searchSignParam = new SearchSignParam();
        searchSignParam.setBankCode("ALIPAY_SN");
        searchSignParam.setSignedAccount(request.getSignedAccount());
        return searchSignParam;
    }
    private SignParam buildSignParam(SignRequest request) {
        SignParam signParam = new SignParam();
        signParam.setBankCode("ALIPAY_SN");
        signParam.setSignedAccount(request.getSignedAccount());
        return signParam;
    }
}
