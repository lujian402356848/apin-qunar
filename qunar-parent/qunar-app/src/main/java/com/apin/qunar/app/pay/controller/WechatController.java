package com.apin.qunar.app.pay.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.pay.request.wechat.QueryWebchatPayRequest;
import com.apin.qunar.app.pay.request.wechat.WechatPayRequest;
import com.apin.qunar.basic.domain.ExecuteResult;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.common.utils.HostUtil;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.common.enums.OrderTypeEnum;
import com.apin.qunar.order.common.enums.WechatPayStatusEnum;
import com.apin.qunar.order.dao.impl.InternationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.dao.model.InternationalOrder;
import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.domain.international.pay.NtsPayParam;
import com.apin.qunar.order.domain.national.pay.PayParam;
import com.apin.qunar.order.domain.pay.wechat.WechatBO;
import com.apin.qunar.order.service.international.NtsPayService;
import com.apin.qunar.order.service.national.PayService;
import com.apin.qunar.order.service.pay.WechatService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;

@Slf4j
@RestController
@RequestMapping(AppConstants.ROOT_URL)
public class WechatController extends BaseController {
    private static final String SUCCESS_XML = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
    private static final String FAIL_XML = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[报文为空]]></return_msg></xml>";
    @Autowired
    private WechatService wechatService;
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

    @PostMapping(value = "/wechatPay/generateQrCode")
    public GeneralResultMap generateQrCode(@RequestBody WechatPayRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/wechatPay/generateQrCode接口基础验证不通过，request:{}", JSON.toJSON(request));
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
                qrCode = wechatService.generateQrCode(buildWechatBO(request, payOrderNo));
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
            log.error("微信获取支付二维码异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private WechatBO buildWechatBO(WechatPayRequest wechatPayRequest, String payOrderNo) {
        WechatBO wechatBO = new WechatBO();
        wechatBO.setMerchantNo(wechatPayRequest.getMerchantNo());
        wechatBO.setOrderNo(payOrderNo);
        wechatBO.setTotalAmount(wechatPayRequest.getTotalAmount());
        wechatBO.setHasInlandOrder(wechatPayRequest.isHasInlandOrder());
        wechatBO.setIp(HostUtil.getLocalIp());
        wechatBO.setOrderType(wechatPayRequest.getOrderType());
        return wechatBO;
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

    /**
     * 支付宝网站支付异步回调
     */
    @ResponseBody
    @PostMapping(value = "/wechatPay/payCallback")
    public void payCallback(HttpServletRequest request, HttpServletResponse response) {
        boolean result = false;
        try {
            result = wechatService.payCallback(request);
        } catch (Exception e) {
            log.error("微信支付接口信息异常,request:{}", JSON.toJSON(request.getParameterMap()), e);
        }
        String resXml = result ? SUCCESS_XML : FAIL_XML;
        try {
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            out.write(resXml.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            log.error("微信支付回调失败", e);
        }
    }

    @ResponseBody
    @PostMapping(value = "/wechatPay/queryPayStatus")
    public GeneralResultMap queryPayStatus(@RequestBody QueryWebchatPayRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/wechatPay/queryPayStatus接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            WechatPayStatusEnum wechatPayStatusEnum = wechatService.queryOrderPayStatus(request.getOutTradeNo());
            generalResultMap.setResult(SysReturnCode.SUCC, "", wechatPayStatusEnum.getStatus());
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("微信支付查询订单状态异常,request:{}", request, e);
        }
        return generalResultMap;
    }
}
