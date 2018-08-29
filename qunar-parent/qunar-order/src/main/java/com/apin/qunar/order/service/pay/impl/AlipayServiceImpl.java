package com.apin.qunar.order.service.pay.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.apin.qunar.basic.common.config.SmsConfig;
import com.apin.qunar.basic.common.constant.SmsConstants;
import com.apin.qunar.basic.common.enums.SmsSendTypeEnum;
import com.apin.qunar.basic.domain.ExecuteResult;
import com.apin.qunar.basic.service.SmsService;
import com.apin.qunar.common.utils.DateUtil;
import com.apin.qunar.common.utils.UUIDUtil;
import com.apin.qunar.order.common.config.AlipayConfig;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.common.enums.*;
import com.apin.qunar.order.dao.impl.*;
import com.apin.qunar.order.dao.model.*;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.pay.NtsPayParam;
import com.apin.qunar.order.domain.international.pay.NtsPayResultVO;
import com.apin.qunar.order.domain.national.changePay.ChangePayParam;
import com.apin.qunar.order.domain.national.changePay.ChangePayResultVO;
import com.apin.qunar.order.domain.national.pay.PayParam;
import com.apin.qunar.order.domain.national.pay.PayResultVO;
import com.apin.qunar.order.domain.pay.alipay.AlipayBO;
import com.apin.qunar.order.service.international.NtsPayFailOrderService;
import com.apin.qunar.order.service.international.NtsPayService;
import com.apin.qunar.order.service.national.ChangePayService;
import com.apin.qunar.order.service.national.PayFailOrderService;
import com.apin.qunar.order.service.national.PayService;
import com.apin.qunar.order.service.pay.AlipayService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Slf4j
@Service
public class AlipayServiceImpl implements AlipayService {
    @Autowired
    private AlipayConfig alipayConfig;
    @Autowired
    private AlipayDaoImpl alipayPayDao;
    @Autowired
    private NationalOrderDaoImpl nationalOrderDao;
    @Autowired
    private InternationalOrderDaoImpl internationalOrderDao;
    @Autowired
    private PayFailOrderService payFailOrderService;
    @Autowired
    private NtsPayFailOrderService ntsPayFailOrderService;
    @Autowired
    private PayService payService;
    @Autowired
    private NtsPayService ntsPayService;
    @Autowired
    private SmsService smsService;
    @Autowired
    private SmsConfig smsConfig;
    @Autowired
    private OrderConfig orderConfig;
    @Autowired
    private NationalChangeOrderDaoImpl nationalChangeOrderDao;
    @Autowired
    private ChangePayService changePayService;
    @Autowired
    private NationalChangePassengerDaoImpl nationalChangePassengerDao;
    @Autowired
    private NationalReturnOrderDaoImpl nationalReturnOrderDao;

    private AlipayClient alipayClient;

    private AlipayClient newAlipayClient;

    @PostConstruct
    public void init() {
        alipayClient = new DefaultAlipayClient(alipayConfig.getGatewayUrl(), alipayConfig.getAppId(),
                alipayConfig.getMerchantPrivateKey(), "json",
                alipayConfig.getCharset(),
                alipayConfig.getAlipayPublicKey(),
                alipayConfig.getSignType());

        newAlipayClient = new DefaultAlipayClient(alipayConfig.getGatewayUrl(), alipayConfig.getNewAppId(),
                alipayConfig.getNewMerchantPrivateKey(), "json",
                alipayConfig.getCharset(),
                alipayConfig.getNewAlipayPublicKey(),
                alipayConfig.getSignType());

    }

    @Override
    public String generateQrCode(AlipayBO alipayBO) {
        if (alipayBO == null || StringUtils.isBlank(alipayBO.getOrderNo())) {
            return "";
        }
        String orderNo = alipayBO.getOrderNo();// 去哪儿的订单号，商户网站订单系统中唯一订单号，必填
        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
        model.setBody("飞机票");
        model.setSubject("爱拼机-代订飞机票");
        model.setTotalAmount(String.valueOf(alipayBO.getTotalAmount()));
        model.setStoreId("apin");
        model.setTimeoutExpress("5m");
        model.setOutTradeNo(orderNo);
        model.setQrCodeTimeoutExpress(alipayConfig.getQrCodeTimeoutExpress());
        String qrCode = "";
        try {
            qrCode = tradePrecreatePay(model, alipayConfig.getNotifyUrl());
            if (StringUtils.isNotBlank(qrCode)) {
                if (!createAliPayRecord(alipayBO)) {
                    qrCode = "";
                }
            }
        } catch (Exception e) {
            log.error("支付宝获取二维码失败,params:{}", JSON.toJSON(alipayBO), e);
        }
        return qrCode;
    }

    private boolean createAliPayRecord(AlipayBO aliPayBO) {
        boolean result = false;
        try {
            AliPay aliPay = alipayPayDao.queryByOrderNo(aliPayBO.getOrderNo());
            if (aliPay == null) {
                result = alipayPayDao.insert(buildAliPay(aliPayBO));// 添加一条支付宝的交易流水记录到数据库
            } else {
                if (aliPay.getAliPayStatus() == AlipayStatusEnum.PAY_SUCCESS.getStatus()) {
                    log.warn("该订单【{}】支付宝已经支付成功，不能重复支付", aliPay.getOrderNo());
                } else {
                    result = alipayPayDao.deleteByOrderNo(aliPayBO.getOrderNo());
                    if (result) {
                        result = alipayPayDao.insert(buildAliPay(aliPayBO));// 添加一条支付宝的交易流水记录到数据库
                    }
                }
            }
        } catch (Exception e) {
            log.error("订单【{}】生成支付宝二维码的时候创建支付请求失败", aliPayBO.getOrderNo(), e);
        }
        return result;
    }

    private AliPay buildAliPay(AlipayBO alipayBO) {
        AliPay aliPay = new AliPay();
        aliPay.setId(UUIDUtil.getUUID());
        aliPay.setMerchantNo(alipayBO.getMerchantNo());
        aliPay.setOrderNo(alipayBO.getOrderNo());
        aliPay.setOrderType(alipayBO.getOrderType());
        aliPay.setPayAmount(alipayBO.getTotalAmount());
        aliPay.setAliPayStatus(AlipayStatusEnum.NO_PAY.getStatus());
        aliPay.setQunarPayStatus(QunarPayStatusEnum.NO_PAY.getStatus());
        aliPay.setHasInlandOrder(alipayBO.isHasInlandOrder() ? 1 : 0);
        return aliPay;
    }

    private String tradePrecreatePay(AlipayTradePrecreateModel model, String notifyUrl) {
        String qrCode = "";
        try {
            AlipayTradePrecreateResponse response = tradePrecreatePayToResponse(model, notifyUrl);
            if (response != null) {
                String resultStr = response.getBody();
                JSONObject jsonObject = JSONObject.parseObject(resultStr);
                qrCode = jsonObject.getJSONObject("alipay_trade_precreate_response").getString("qr_code");
            }
        } catch (Exception e) {
            log.error("调用支付宝接口异常,params:{}", JSON.toJSON(model), e);
        }
        return qrCode;
    }

    private AlipayTradePrecreateResponse tradePrecreatePayToResponse(AlipayTradePrecreateModel model, String notifyUrl) {
        AlipayTradePrecreateResponse response = null;
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setBizModel(model);
        request.setNotifyUrl(notifyUrl);
        try {
            response = newAlipayClient.execute(request);
        } catch (AlipayApiException e) {
            log.error("调用支付宝接口异常,params:{}", JSON.toJSON(model), e);
        }
        return response;
    }

    /**
     * 扫码支付通知
     */
    public boolean payCallback(HttpServletRequest request) {
        boolean result = false;
        Map<String, String> params = buildMap(request);
        log.info("alipay callback params:{}", JSON.toJSON(params));
        try {
            boolean signVerified = AlipaySignature.rsaCheckV1(params, alipayConfig.getNewAlipayPublicKey(), "UTF-8", alipayConfig.getSignType());
            if (!signVerified) {
                log.info("支付宝回调验证签名失败");
                return result;
            }
            String orderNo = params.get("out_trade_no");
            if (StringUtils.isBlank(orderNo)) {
                log.warn("支付回调获取的订单号为空");
                return result;
            }
            AliPay aliPay = alipayPayDao.queryByOrderNo(orderNo);
            if (aliPay == null) {
                log.warn("数据库无此订单【{}】", orderNo);
                return result;
            }
            if (aliPay.getPayAmount() != Double.parseDouble(params.get("total_amount"))) {
                log.warn("支付宝与付款时的金额不同,数据库金额:{},支付宝回调金额:{}", aliPay.getPayAmount(), params.get("total_amount"));
                return result;
            }
            if (aliPay.getAliPayStatus() == AlipayStatusEnum.PAY_SUCCESS.getStatus()) {
                log.warn("支付宝已经支付成功，无需再次支付,param:{}", JSON.toJSON(params));
                return true;
            }
            String status = params.get("trade_status");
            switch (status) {
                case "WAIT_BUYER_PAY"://正在等待用户付款
                    result = alipayPayDao.updateAliPayStatus(aliPay.getId(), AlipayStatusEnum.PAYING.getStatus());
                    break;
                case "TRADE_CLOSED"://未付款交易超时关闭，或支付完成后全额退款
                    result = alipayPayDao.updateAliPayStatus(aliPay.getId(), AlipayStatusEnum.NO_PAY.getStatus());
                    break;
                case "TRADE_SUCCESS":
                case "TRADE_FINISHED"://已经支付成功/结束
                    String tradeNo = params.get("out_trade_no");
                    String payTime = params.get("gmt_payment");
                    result = alipayPayDao.updateAliPayInfo(aliPay.getId(), tradeNo, AlipayStatusEnum.PAY_SUCCESS.getStatus(), payTime);
                    if (result) {//先通过支付宝状态
                        qunarOrderPay(aliPay);
                    }
                    break;
                default:
                    log.warn("订单号为:{}支付宝返回未知状态:{}", orderNo, status);
                    break;
            }
            if (result) {
                log.info("订单号为:{}的状态已经修改为:{}", orderNo, status);
            }
        } catch (Exception e) {
            log.error("支付宝回调处理异常,params:{}", JSON.toJSON(params), e);
        }
        return result;
    }

    @Override
    public boolean qunarOrderPay(AliPay aliPay) {
        if (aliPay == null || StringUtils.isBlank(aliPay.getOrderNo())) {
            return false;
        }
        ExecuteResult result = new ExecuteResult();
        if (aliPay.getOrderType() == OrderTypeEnum.CHANGE.getCode()) {
            result = changeOrderPay(aliPay);//改签订单
        } else {
            if (aliPay.getHasInlandOrder() == 1) {
                result = nationalOrderPay(aliPay);//国内订单
            } else {
                result = internationalOrderPay(aliPay);//国际订单
            }
        }
        if (!result.isSuccess()) {
            String content = StringUtils.isBlank(result.getDesc()) ? String.format("支付宝支付成功，但去哪儿支付失败，订单号:%s，订单金额:%s", aliPay.getOrderNo(), aliPay.getPayAmount()) : result.getDesc();
            smsService.sendSms(smsConfig.getMobileNos(), content, SmsSendTypeEnum.QUNAER_PAY_FAIL_NOTIFY);
            if (aliPay.getHasInlandOrder() == OrderCountryEnum.internal.getStatus()) {
                payFailOrderService.createOrder(aliPay.getOrderNo(), PayChannelEnum.ALIPAY);
            } else {
                ntsPayFailOrderService.createOrder(aliPay.getOrderNo(), PayChannelEnum.ALIPAY);
            }
        }
        return result.isSuccess();
    }

    private ExecuteResult nationalOrderPay(AliPay aliPay) {
        ExecuteResult result = new ExecuteResult();
        NationalOrder nationalOrder = nationalOrderDao.queryByOrderNo(aliPay.getOrderNo());
        if (nationalOrder == null) {
            log.info("支付宝付款成功，但是数据库中未找到该笔订单,alipayId:{},ordrNo:{}", aliPay.getId(), aliPay.getOrderNo());
            return result;
        }
        nationalOrderDao.updatePayType(aliPay.getOrderNo(), PayTypeEnum.ALIPAY.getCode());
        QunarPayStatusEnum payStatus = QunarPayStatusEnum.NO_PAY;
        PayParam payParam = buildPayParam(nationalOrder.getClientSite(), nationalOrder.getPayOrderId());
        try {
            ApiResult<PayResultVO> apiResult = payService.pay(payParam);
            if (apiResult.isSuccess() && apiResult.getResult() != null && CollectionUtils.isNotEmpty(apiResult.getResult().getResults())) {
                PayResultVO.PayFormResult payResult = apiResult.getResult().getResults().get(0);
                if ("SUCCESS".equalsIgnoreCase(payResult.getPayStatus())) {
                    payStatus = QunarPayStatusEnum.PAY_SUCCESS;
                } else {
                    payStatus = QunarPayStatusEnum.PAY_FAIL;
                }
            } else {
                payStatus = QunarPayStatusEnum.PAY_FAIL;
            }
            alipayPayDao.updateQunarPayInfo(aliPay.getId(), payStatus.getStatus(), DateUtil.getCurrDate());
            if (payStatus == QunarPayStatusEnum.PAY_SUCCESS) {
                result.setSuccess(true);
            } else {
                result.setSuccess(false);
                if (apiResult != null && apiResult.getResult() != null) {
                    String desc = String.format(SmsConstants.QUNAR_PAY_FAIL_ALI, aliPay.getOrderNo(), apiResult.getResult().getErrMsg());
                    result.setDesc(desc);
                    log.error(desc);
                }
            }
        } catch (Exception e) {
            result.setSuccess(false);
            String desc = String.format(SmsConstants.QUNAR_PAY_FAIL_ALI, aliPay.getOrderNo(), e.getMessage());
            result.setDesc(desc);
            log.error(desc, e);
        }
        return result;
    }

    private ExecuteResult internationalOrderPay(AliPay aliPay) {
        ExecuteResult result = new ExecuteResult();
        InternationalOrder internationalOrder = internationalOrderDao.queryByOrderNo(aliPay.getOrderNo());
        if (internationalOrderDao == null) {
            log.info("支付宝付款成功，但是数据库中未找到该笔订单,alipayId:{},orderNo:{}", aliPay.getId(), aliPay.getOrderNo());
            result.setSuccess(false);
            return result;
        }
        QunarPayStatusEnum payStatus = QunarPayStatusEnum.NO_PAY;
        NtsPayParam ntsPayParam = buildNtsPayParam(internationalOrder.getOrderNo());
        try {
            ApiResult<NtsPayResultVO> apiResult = ntsPayService.pay(ntsPayParam);
            if (apiResult != null && apiResult.isSuccess()) {
                payStatus = QunarPayStatusEnum.PAY_SUCCESS;
            } else {
                payStatus = QunarPayStatusEnum.PAY_FAIL;
            }
            alipayPayDao.updateQunarPayInfo(aliPay.getId(), payStatus.getStatus(), DateUtil.formatYYYYMM(new Date(apiResult.getCreateTime())));
            if (payStatus == QunarPayStatusEnum.PAY_SUCCESS) {
                result.setSuccess(true);
            } else {
                result.setSuccess(false);
                if (apiResult != null) {
                    String desc = String.format(SmsConstants.QUNAR_PAY_FAIL_ALI, aliPay.getOrderNo(), apiResult.getMessage());
                    result.setDesc(desc);
                    log.error(desc);
                }
            }
        } catch (Exception e) {
            result.setSuccess(false);
            String desc = String.format(SmsConstants.QUNAR_PAY_FAIL_ALI, aliPay.getOrderNo(), e.getMessage());
            result.setDesc(desc);
            log.error(desc, e);
        }
        return result;
    }

    private ExecuteResult changeOrderPay(AliPay aliPay) {
        ExecuteResult result = new ExecuteResult();
        String payOrderNo = aliPay.getOrderNo();
        String orderNo = payOrderNo.substring(0, payOrderNo.length() - 1);
        NationalChangeOrder nationalChangeOrder = nationalChangeOrderDao.queryByOrderNo(orderNo);
        if (nationalChangeOrder == null) {
            log.info("支付宝改签付款成功，但是数据库中未找到该笔订单,alipayId:{},ordrNo:{}", aliPay.getId(), aliPay.getOrderNo());
            return result;
        }
        QunarPayStatusEnum payStatus = QunarPayStatusEnum.NO_PAY;
        ChangePayParam changePayParam = buildChangePayParam(nationalChangeOrder, aliPay.getPayAmount());
        try {
            ApiResult<ChangePayResultVO> apiResult = changePayService.changePay(changePayParam);
            if (apiResult.isSuccess() && apiResult.getResult() != null) {
                ChangePayResultVO changePayResult = apiResult.getResult();
                if (changePayResult.getCode() == 0) {
                    payStatus = QunarPayStatusEnum.PAY_SUCCESS;
                } else {
                    payStatus = QunarPayStatusEnum.PAY_FAIL;
                }
            } else {
                payStatus = QunarPayStatusEnum.PAY_FAIL;
            }
            alipayPayDao.updateQunarPayInfo(aliPay.getId(), payStatus.getStatus(), DateUtil.getCurrDate());
            if (payStatus == QunarPayStatusEnum.PAY_SUCCESS) {
                result.setSuccess(true);
            } else {
                result.setSuccess(false);
                if (apiResult != null && apiResult.getResult() != null) {
                    String desc = String.format(SmsConstants.QUNAR_PAY_FAIL_ALI, aliPay.getOrderNo(), apiResult.getResult());
                    result.setDesc(desc);
                    log.error(desc);
                }
            }
        } catch (Exception e) {
            result.setSuccess(false);
            String desc = String.format(SmsConstants.QUNAR_PAY_FAIL_ALI, aliPay.getOrderNo(), e.getMessage());
            result.setDesc(desc);
            log.error(desc, e);
        }
        return result;
    }


    private NtsPayParam buildNtsPayParam(String orderNo) {
        NtsPayParam ntsPayParam = new NtsPayParam();
        ntsPayParam.setOrderNo(orderNo);
        ntsPayParam.setSource(orderConfig.getInternationalSource());
        ntsPayParam.setPmcode(orderConfig.getPayType());
        ntsPayParam.setBankcode(orderConfig.getBankCode());
        ntsPayParam.setPaymentMerchantCode(orderConfig.getPayAccount());
        return ntsPayParam;
    }

    private PayParam buildPayParam(String clientSize, String orderNo) {
        PayParam payParam = new PayParam();
        payParam.setClientSite(clientSize);
        payParam.setOrderId(orderNo);
        payParam.setPmCode(orderConfig.getPayType());
        payParam.setBankCode(orderConfig.getBankCode());
        payParam.setPaymentMerchantCode(orderConfig.getPayAccount());
        payParam.setCurId("CNY");
        payParam.setBgRetUrl(orderConfig.getPayCallbackUrl());
        return payParam;
    }


    private ChangePayParam buildChangePayParam(NationalChangeOrder nationalChangeOrder, Integer payAmount) {
        ChangePayParam changePayParam = new ChangePayParam();
        changePayParam.setOrderNo(nationalChangeOrder.getOrderNo());
        changePayParam.setGqId(nationalChangeOrder.getChangeId());
        changePayParam.setPassengerIds(bulidPassengerIds(nationalChangeOrder.getOrderNo()));
        changePayParam.setTotalAmount(payAmount.toString());
        changePayParam.setPmCode(orderConfig.getPayType());
        changePayParam.setBankCode(orderConfig.getBankCode());
        changePayParam.setPaymentMerchantCode(orderConfig.getPayAccount());
        changePayParam.setCallbackUrl(orderConfig.getPayCallbackUrl());
        changePayParam.setCurId("CNY");
        return changePayParam;
    }

    private String bulidPassengerIds(String orderNo) {
        String passengerIds = "";
        List<NationalChangePassenger> nationalChangePassengers = nationalChangePassengerDao.queryByOrderNo(orderNo);
        for (NationalChangePassenger nationalChangePassenger : nationalChangePassengers) {
            String id = nationalChangePassenger.getId();
            passengerIds = id + ",";
        }
        return passengerIds.substring(0, passengerIds.length() - 1);
    }

    @Override
    public AlipayStatusEnum queryOrderPayStatus(String orderNo) {
        AlipayStatusEnum alipayStatusEnum = AlipayStatusEnum.NO_PAY;
        AlipayTradeQueryRequest alipayTradeQueryRequest = new AlipayTradeQueryRequest();
        alipayTradeQueryRequest.setBizContent("{" + "\"out_trade_no\":\"" + orderNo + "\"" + "}");
        try {
            AlipayTradeQueryResponse alipayTradeQueryResponse = newAlipayClient.execute(alipayTradeQueryRequest);
            if (alipayTradeQueryResponse.isSuccess()) {
                switch (alipayTradeQueryResponse.getTradeStatus()) // 判断交易结果
                {
                    case "TRADE_SUCCESS": // 交易支付成功
                    case "TRADE_FINISHED": // 交易结束并不可退款
                        alipayStatusEnum = AlipayStatusEnum.PAY_SUCCESS;
                        break;
                    case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        alipayStatusEnum = AlipayStatusEnum.NO_PAY;
                        break;
                    case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
                        alipayStatusEnum = AlipayStatusEnum.PAYING;
                        break;
                }
            }
        } catch (Exception e) {
            log.error("支付宝支付获取订单状态异常,orderNo:{}", orderNo, e);
        }
        return alipayStatusEnum;
    }

    /**
     * 将异步通知的参数转化为Map
     *
     * @param request
     * @return
     */
    private static Map<String, String> buildMap(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        return params;
    }

    /*
    * 支付宝退款
    * */
    @Override
    public void payRefund(String parentOrderNo, String orderNo, Integer refundAmount) {
        String content = "";
        ReturnStatusEnum returnStatus = ReturnStatusEnum.NO_RETURN;
        AlipayTradeRefundRequest request = buildAlipayTradeRefundRequest(parentOrderNo, orderNo, refundAmount);
        try {
            Date insertTime = DateUtil.getDate("2018-08-29", "19:00:00");
            boolean hasBefore = nationalOrderDao.queryBy(parentOrderNo, insertTime);
            AlipayTradeRefundResponse response;
            if (hasBefore) {
                response = alipayClient.execute(request);
            } else {
                response = newAlipayClient.execute(request);
            }
            if (response == null) {
                log.error("支付宝退款返回内容为空,订单号:{},金额:{}", orderNo, refundAmount);
                return;
            }
            if ("10000".equals(response.getCode())) {
                returnStatus = ReturnStatusEnum.RETURN_SUCCESS;
                log.info("支付宝退款成功，orderNo:{},refundAmount:{}", orderNo, refundAmount);
            } else {
                returnStatus = ReturnStatusEnum.NO_RETURN;
                content = String.format("支付宝退款失败，orderNo:%s，,refundAmount:%s,errorMsg：%s", orderNo, refundAmount, response.getMsg() + response.getSubMsg());
            }
        } catch (Exception e) {
            content = String.format("支付宝退款异常，orderNo:%s,refundAmount:%s", orderNo, refundAmount);
            returnStatus = ReturnStatusEnum.NO_RETURN;
        }
        if (returnStatus != ReturnStatusEnum.RETURN_SUCCESS) {
            smsService.sendSms(smsConfig.getMobileNos(), content, SmsSendTypeEnum.ALIPAY_REFUND_FAIL_NOTIFY);
            log.error(content);
        }
        nationalReturnOrderDao.updateReturnPayTypeAndstatus(orderNo, PayTypeEnum.ALIPAY.getCode(), returnStatus.getStatus());
    }


    private AlipayTradeRefundRequest buildAlipayTradeRefundRequest(final String parentOrderNo, final String orderNo, final Integer refundAmount) {
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        AlipayTradeRefundModel refundModel = new AlipayTradeRefundModel();
        refundModel.setOutTradeNo(parentOrderNo);
        refundModel.setRefundAmount(String.valueOf(refundAmount));
        refundModel.setOutRequestNo(orderNo);
        refundModel.setRefundReason("飞机票退款");
        request.setBizModel(refundModel);
        return request;
    }
}