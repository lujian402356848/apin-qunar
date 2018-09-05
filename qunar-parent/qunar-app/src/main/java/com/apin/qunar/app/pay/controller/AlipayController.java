package com.apin.qunar.app.pay.controller;


import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.pay.request.alipay.AlipayRequest;
import com.apin.qunar.app.pay.request.alipay.PayRefundRequest;
import com.apin.qunar.app.pay.request.alipay.QueryAlipayRequest;
import com.apin.qunar.basic.domain.ExecuteResult;
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
            ExecuteResult executeResult = null;
            String payOrderNo = "";
            if (request.getOrderType() == OrderTypeEnum.CHANGE.getCode()) {//改签订单不需要支付验证
                payOrderNo = orderNo + "*";
                executeResult = new ExecuteResult(true);
            } else {
                executeResult = request.isHasInlandOrder() ? validatePay(orderNo) : validateNtsPay(orderNo);
                payOrderNo = orderNo;
            }
            if (executeResult.isSuccess()) {
                qrCode = alipayService.generateQrCode(buildAlipayBO(request, payOrderNo));
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL, executeResult.getDesc());
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

    @PostMapping(value = "/alipay/computerPay")
    public GeneralResultMap computerPay(@RequestBody AlipayRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/alipay/generateQrCode接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        if (StringUtils.isBlank(request.getOrderNo())) {
            generalResultMap.setResult(SysReturnCode.FAIL, "订单号不能为空");
            return generalResultMap;
        }
        String result = "";
        String orderNo = request.getOrderNo();
        try {
            ExecuteResult executeResult = null;
            String payOrderNo = "";
            if (request.getOrderType() == OrderTypeEnum.CHANGE.getCode()) {//改签订单不需要支付验证
                payOrderNo = orderNo + "*";
                executeResult = new ExecuteResult(true);
            } else {
                executeResult = request.isHasInlandOrder() ? validatePay(orderNo) : validateNtsPay(orderNo);
                payOrderNo = orderNo;
            }
            if (executeResult.isSuccess()) {
                result = alipayService.computerPayment(buildAlipayBO(request,payOrderNo));
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL, executeResult.getDesc());
                return generalResultMap;
            }
            if (StringUtils.isBlank(result)) {
                generalResultMap.setResult(SysReturnCode.FAIL);
            } else {
                generalResultMap.setData(result);
                generalResultMap.setResult(SysReturnCode.SUCC);
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("支付宝获取支付页面异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private ExecuteResult validatePay(String orderNo) {
        NationalOrder order = nationalOrderDao.queryByOrderNo(orderNo);
        if (order == null) {
            return new ExecuteResult(false, "数据库中没有该笔订单:" + orderNo);
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

    private ExecuteResult validateNtsPay(String orderNo) {
        InternationalOrder order = internationalOrderDao.queryByOrderNo(orderNo);
        if (order == null) {
            return new ExecuteResult(false, "数据库中没有该笔订单:" + orderNo);
        }
        NtsPayParam ntsPayParam = new NtsPayParam();
        ntsPayParam.setOrderNo(order.getOrderNo());
        ntsPayParam.setSource(orderConfig.getInternationalSource());
        ntsPayParam.setPmcode(orderConfig.getPayType());
        ntsPayParam.setBankcode(orderConfig.getBankCode());
        ntsPayParam.setPaymentMerchantCode(orderConfig.getPayAccount());

        return ntsPayService.validatePay(ntsPayParam);
    }

    private AlipayBO buildAlipayBO(AlipayRequest alipayRequest, String payOrderNo) {
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

    @ResponseBody
    @PostMapping(value = "/alipay/refund")
    public GeneralResultMap payRefund(@RequestBody PayRefundRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/alipay/queryPayStatus接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            alipayService.payRefund(request.getParentNo(), request.getOrderNo(), request.getTotalAmount());
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("支付宝支付退款订单状态异常,request:{}", request, e);
        }
        return generalResultMap;
    }
}
