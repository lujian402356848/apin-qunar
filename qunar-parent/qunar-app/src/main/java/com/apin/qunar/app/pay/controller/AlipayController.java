package com.apin.qunar.app.pay.controller;


import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.pay.request.alipay.AlipayRequest;
import com.apin.qunar.app.pay.request.alipay.QueryAlipayRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.common.enums.AlipayStatusEnum;
import com.apin.qunar.order.common.enums.OrderTypeEnum;
import com.apin.qunar.order.dao.impl.InternationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.dao.model.InternationalOrder;
import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.domain.international.pay.NtsPayParam;
import com.apin.qunar.order.domain.national.pay.PayParam;
import com.apin.qunar.order.domain.pay.alipay.AlipayBO;
import com.apin.qunar.order.service.international.NtsPayService;
import com.apin.qunar.order.service.national.PayService;
import com.apin.qunar.order.service.pay.AlipayService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @outhor wubo
 * @create 2018-07-30 17:40
 */

@Slf4j
@RestController
@RequestMapping(AppConstants.ROOT_URL)
public class AlipayController extends BaseController {
    @Autowired
    private AlipayService alipayService;
    @Autowired
    private PayService payService;
    @Autowired
    private NtsPayService ntsPayService;
    @Autowired
    private NationalOrderDaoImpl nationalOrderDao;
    @Autowired
    private InternationalOrderDaoImpl internationalOrderDao;
    @Autowired
    private OrderConfig orderConfig;

    @PostMapping(value = "/alipay/generateQrCode")
    public GeneralResultMap generateQrCode(@RequestBody AlipayRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/alipay/generateQrCode接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        if (StringUtils.isBlank(request.getOrderNo())) {
            generalResultMap.setResult(SysReturnCode.FAIL, "订单号不能为空");
            return generalResultMap;
        }
        String qrCode = "";
        String orderNo = request.getOrderNo();
        try {
            boolean validateResult = false;
            String payOrderNo = "";
            if (request.getOrderType() == OrderTypeEnum.CHANGE.getCode()) {//改签订单不需要支付验证
                payOrderNo = orderNo + "*";
                validateResult = true;
            } else {
                validateResult = request.isHasInlandOrder() ? validatePay(orderNo) : validateNtsPay(orderNo);
                payOrderNo = orderNo;
            }
            if (validateResult) {
                qrCode = alipayService.generateQrCode(bulidAipayBO(request, payOrderNo));
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL, "航班或价格已发生变化，无法生成二维码，请重新下单");
                return generalResultMap;
            }
            if (StringUtils.isBlank(qrCode)) {
                generalResultMap.setResult(SysReturnCode.FAIL);
            } else {
                generalResultMap.setData(qrCode);
                generalResultMap.setResult(SysReturnCode.SUCC);
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("支付宝获取支付二维码异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private boolean validatePay(String orderNo) {
        boolean validateResult = false;
        NationalOrder order = nationalOrderDao.queryByOrderNo(orderNo);
        if (order == null) {
            return validateResult;
        }
        PayParam payParam = new PayParam();
        payParam.setClientSite(order.getClientSite());
        payParam.setOrderId(order.getPayOrderId());
        payParam.setPmCode(orderConfig.getPayType());
        payParam.setBankCode(orderConfig.getBankCode());
        payParam.setPaymentMerchantCode(orderConfig.getPayAccount());
        payParam.setCurId("CNY");
        payParam.setBgRetUrl(orderConfig.getPayCallbackUrl());

        return payService.validatePay(payParam);
    }

    private boolean validateNtsPay(String orderNo) {
        boolean validateResult = false;
        InternationalOrder order = internationalOrderDao.queryByOrderNo(orderNo);
        if (order == null) {
            return validateResult;
        }
        NtsPayParam ntsPayParam = new NtsPayParam();
        ntsPayParam.setOrderNo(order.getOrderNo());
        ntsPayParam.setSource(orderConfig.getInternationalSource());
        ntsPayParam.setPmcode(orderConfig.getPayType());
        ntsPayParam.setBankcode(orderConfig.getBankCode());
        ntsPayParam.setPaymentMerchantCode(orderConfig.getPayAccount());

        return ntsPayService.validatePay(ntsPayParam);
    }

    private AlipayBO bulidAipayBO(AlipayRequest alipayRequest, String payOrderNo) {
        AlipayBO alipayBO = new AlipayBO();
        alipayBO.setMerchantNo(alipayRequest.getMerchantNo());
        alipayBO.setTotalAmount(alipayRequest.getTotalAmount());
        alipayBO.setOrderNo(payOrderNo);
        alipayBO.setHasInlandOrder(alipayRequest.isHasInlandOrder());
        alipayBO.setOrderType(alipayRequest.getOrderType());
        return alipayBO;
    }

    /**
     * 支付宝网站支付异步回调
     */
    @ResponseBody
    @PostMapping(value = "/alipay/payCallback")
    public String payCallback(HttpServletRequest request) {
        boolean result = false;
        try {
            result = alipayService.payCallback(request);
        } catch (Exception e) {
            log.error("支付宝支付接口信息异常,request:{}", JSON.toJSON(request.getParameterMap()), e);
        }
        return result ? "success" : "fail";
    }

    @ResponseBody
    @PostMapping(value = "/alipay/queryPayStatus")
    public GeneralResultMap queryPayStatus(@RequestBody QueryAlipayRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/alipay/queryPayStatus接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            AlipayStatusEnum alipayStatusEnum = alipayService.queryOrderPayStatus(request.getOutTradeNo());
            generalResultMap.setResult(SysReturnCode.SUCC, "", alipayStatusEnum.getStatus());
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("支付宝支付查询订单状态异常,request:{}", request, e);
        }
        return generalResultMap;
    }
}
