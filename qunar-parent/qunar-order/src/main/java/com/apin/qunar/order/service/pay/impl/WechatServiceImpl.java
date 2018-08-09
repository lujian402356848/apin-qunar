package com.apin.qunar.order.service.pay.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.basic.common.config.SmsConfig;
import com.apin.qunar.basic.common.constant.SmsConstants;
import com.apin.qunar.basic.common.enums.SmsSendTypeEnum;
import com.apin.qunar.basic.domain.ExecuteResult;
import com.apin.qunar.basic.service.SmsService;
import com.apin.qunar.common.utils.DateUtil;
import com.apin.qunar.common.utils.HttpUtil;
import com.apin.qunar.common.utils.UUIDUtil;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.common.config.WeChatPayConfig;
import com.apin.qunar.order.common.enums.OrderCountryEnum;
import com.apin.qunar.order.common.enums.PayChannelEnum;
import com.apin.qunar.order.common.enums.QunarPayStatusEnum;
import com.apin.qunar.order.common.enums.WechatPayStatusEnum;
import com.apin.qunar.order.common.utils.WechatPayUtil;
import com.apin.qunar.order.dao.impl.InternationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.WechatPayDaoImpl;
import com.apin.qunar.order.dao.model.InternationalOrder;
import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.dao.model.WechatPay;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.pay.NtsPayParam;
import com.apin.qunar.order.domain.international.pay.NtsPayResultVO;
import com.apin.qunar.order.domain.national.pay.PayParam;
import com.apin.qunar.order.domain.national.pay.PayResultVO;
import com.apin.qunar.order.domain.pay.wechat.WechatBO;
import com.apin.qunar.order.service.international.NtsPayFailOrderService;
import com.apin.qunar.order.service.international.NtsPayService;
import com.apin.qunar.order.service.national.PayFailOrderService;
import com.apin.qunar.order.service.national.PayService;
import com.apin.qunar.order.service.pay.WechatService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@Slf4j
@Service
public class WechatServiceImpl implements WechatService {

    @Autowired
    private WeChatPayConfig weChatPayConfig;
    @Autowired
    private WechatPayDaoImpl wechatPayDao;
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

    @Override
    public String generateQrCode(WechatBO wechatBO) {
        if (wechatBO == null || wechatBO.getTotalAmount() <= 0) {
            return "";
        }
        wechatBO.setTotalAmount(wechatBO.getTotalAmount() * 100);//微信支付以分为单位
        String requestXML = WechatPayUtil.getRequestXml(buildSortedMap(wechatBO));
        String resXml = HttpUtil.postData(weChatPayConfig.getPayUrl(), requestXML);
        Map map = WechatPayUtil.xmlToMap(resXml);
        if (CollectionUtils.isEmpty(map) || "FAIL".equals(map.get("return_code"))) {
            log.error("生成微信二维码异常:{}", requestXML);
            return "";
        }
        return createWechatPayRecord(wechatBO) ? (String) map.get("code_url") : "";
    }

    private SortedMap<Object, Object> buildSortedMap(WechatBO wechatBO) {
        String currTime = WechatPayUtil.getCurrTime();
        String strTime = currTime.substring(8, currTime.length());
        String nonce_str = strTime + String.valueOf(WechatPayUtil.buildRandom(4));

        String order_price = String.valueOf(wechatBO.getTotalAmount()); // 微信支付的金额以分为单位
        String body = "爱拼机-代订飞机票";   // 商品名称
        SortedMap<Object, Object> packageParams = new TreeMap<>();
        packageParams.put("appid", weChatPayConfig.getAppId());
        packageParams.put("mch_id", weChatPayConfig.getMerchantId());
        packageParams.put("nonce_str", nonce_str);
        packageParams.put("body", body);
        packageParams.put("out_trade_no", wechatBO.getOrderNo());
        packageParams.put("total_fee", order_price);
        packageParams.put("spbill_create_ip", wechatBO.getIp());
        packageParams.put("notify_url", weChatPayConfig.getNotifyUrl());
        packageParams.put("trade_type", "NATIVE");
        String sign = WechatPayUtil.createSign(packageParams, weChatPayConfig.getKey());
        packageParams.put("sign", sign);

        return packageParams;
    }

    @Override
    public WechatPayStatusEnum queryOrderPayStatus(String orderNo) {
        WechatPayStatusEnum wechatPayStatusEnum = WechatPayStatusEnum.NO_PAY;
        SortedMap<Object, Object> stringSortedMap = buildSortedMap(orderNo);
        String requestXML = WechatPayUtil.getRequestXml(stringSortedMap);
        String resXml = HttpUtil.postData(weChatPayConfig.getQueryUrl(), requestXML);
        Map resp = WechatPayUtil.xmlToMap(resXml);
        String trade_state = (String) resp.get("trade_state");
        switch (trade_state) {
            case "SUCCESS":
                wechatPayStatusEnum = WechatPayStatusEnum.PAY_SUCCESS;
                break;
            case "FAIL":
                wechatPayStatusEnum = WechatPayStatusEnum.NO_PAY;
                log.warn("订单【{}】微信支付失败，失败原因:{}", orderNo, resp.get("err_code_des"));
                break;
        }
        return wechatPayStatusEnum;
    }

    private SortedMap<Object, Object> buildSortedMap(String orderNo) {
        SortedMap<Object, Object> stringSortedMap = new TreeMap<>();
        String currTime = WechatPayUtil.getCurrTime();
        String strTime = currTime.substring(8, currTime.length());
        String nonce_str = strTime + String.valueOf(WechatPayUtil.buildRandom(4));
        stringSortedMap.put("appid", weChatPayConfig.getAppId());
        stringSortedMap.put("mch_id", weChatPayConfig.getMerchantId());
        stringSortedMap.put("nonce_str", nonce_str);
        stringSortedMap.put("out_trade_no", orderNo);//订单号
        String sign = WechatPayUtil.createSign(stringSortedMap, weChatPayConfig.getKey());
        stringSortedMap.put("sign", sign);
        return stringSortedMap;
    }

    private boolean createWechatPayRecord(WechatBO wechatBO) {
        boolean result = false;
        try {
            WechatPay wechatPay = wechatPayDao.queryByOrderNo(wechatBO.getOrderNo());
            if (wechatPay == null) {
                result = wechatPayDao.insert(buildWechatPay(wechatBO));// 添加一条微信的交易流水记录到数据库
            } else {
                if (wechatPay.getWechatPayStatus() == WechatPayStatusEnum.PAY_SUCCESS.getStatus()) {
                    log.warn("该订单【{}】微信已经支付成功，不能重复支付", wechatPay.getOrderNo());
                } else {
                    result = wechatPayDao.deleteByOrderNo(wechatBO.getOrderNo());
                    if (result) {
                        result = wechatPayDao.insert(buildWechatPay(wechatBO));// 添加一条微信的交易流水记录到数据库
                    }
                }
            }
        } catch (Exception e) {
            log.error("订单【{}】生成微信二维码的时候创建支付请求失败", wechatBO.getOrderNo(), e);
        }
        return result;
    }

    private WechatPay buildWechatPay(WechatBO wechatBO) {
        WechatPay wechatPay = new WechatPay();
        wechatPay.setId(UUIDUtil.getUUID());
        wechatPay.setMerchantNo(wechatBO.getMerchantNo());
        wechatPay.setHasInlandOrder(wechatBO.isHasInlandOrder() ? 1 : 0);
        wechatPay.setOrderNo(wechatBO.getOrderNo());
        wechatPay.setPayAmount(wechatBO.getTotalAmount() / 100);
        wechatPay.setWechatPayStatus(WechatPayStatusEnum.NO_PAY.getStatus());
        wechatPay.setQunarPayStatus(QunarPayStatusEnum.NO_PAY.getStatus());
        return wechatPay;
    }

    private String getPayCallbackParam(HttpServletRequest request) {
        StringBuffer params = new StringBuffer();
        InputStream inputStream;
        try {
            inputStream = request.getInputStream();
            String s;
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while ((s = in.readLine()) != null) {
                params.append(s);
            }
            in.close();
            inputStream.close();
        } catch (Exception e) {
            log.error("微信获取回调参数异常", e);
        }
        return params.toString();
    }

    /**
     * 扫码支付回调
     *
     * @param request
     * @return
     */
    @Override
    public boolean payCallback(HttpServletRequest request) {
        boolean result = false;
        String params = getPayCallbackParam(request);
        if (StringUtils.isBlank(params)) {
            return result;
        }
        Map<String, String> mapXML = WechatPayUtil.xmlToMap(params);
        SortedMap<Object, Object> packageParams = WechatPayUtil.buildSorteddMap(mapXML);
        log.info("微信支付回调,params:{}", JSON.toJSON(packageParams));
        String key = weChatPayConfig.getKey();
        try {
            if (!WechatPayUtil.validateSign(packageParams, key)) {
                log.warn("微信回调验证签名失败");
                return result;
            }
            String merchantId = (String) packageParams.get("mch_id");
            if (StringUtils.isBlank(merchantId) || !merchantId.equals(weChatPayConfig.getMerchantId())) {
                log.warn("微信回调merchantId参数为空或不正确,merchantId:{}", merchantId);
                return result;
            }
            String orderNo = (String) packageParams.get("out_trade_no");
            if (StringUtils.isBlank(orderNo)) {
                log.warn("支付回调获取的订单号为空");
                return result;
            }
            WechatPay wechatPay = wechatPayDao.queryByOrderNo(orderNo);
            if (wechatPay == null) {
                log.warn("数据库无此订单【{}】", orderNo);
                return result;
            }
            String total_fee = (String) packageParams.get("total_fee");
            Integer payAmount = wechatPay.getPayAmount() * 100;
            if (payAmount != Integer.parseInt(total_fee)) {
                log.warn("微信支付与付款时的金额不同,数据库金额:{},微信回调金额:{}", wechatPay.getPayAmount(), Integer.parseInt(total_fee) / 100);
                return result;
            }
            if (wechatPay.getWechatPayStatus() == WechatPayStatusEnum.PAY_SUCCESS.getStatus()) {
                log.warn("微信已经支付成功，无需再次支付,param:{}", JSON.toJSON(packageParams));
                return true;
            }
            String status = (String) packageParams.get("result_code");
            switch (status) {
                case "FAIL"://支付失败
                    result = wechatPayDao.updateWeCharPayStatus(wechatPay.getId(), WechatPayStatusEnum.NO_PAY.getStatus());
                    log.info("微信支付失败,错误代码：" + packageParams.get("err_code"));
                    break;
                case "SUCCESS"://支付成功
                    String tradeNo = (String) packageParams.get("transaction_id");
                    String payTime = (String) packageParams.get("time_end");
                    result = wechatPayDao.updateWecharPayInfo(wechatPay.getId(), tradeNo, WechatPayStatusEnum.PAY_SUCCESS.getStatus(), DateUtil.getDate(payTime));
                    if (result) {
                        qunarOrderPay(wechatPay);
                    }
                    break;
                default:
                    log.warn("订单号为:{}微信返回未知状态:{}", orderNo, status);
                    break;
            }
            if (result) {
                log.info("订单号为:{}的状态已经修改为:{}", orderNo, status);
            }
        } catch (Exception e) {
            log.error("微信回调处理异常，params{}", JSON.toJSON(packageParams));
        }
        return result;
    }

    private boolean qunarOrderPay(WechatPay wechatPay) {
        ExecuteResult result = new ExecuteResult();
        if (wechatPay.getHasInlandOrder() == 1) {
            result = nationalOrderPay(wechatPay);//国内订单
        } else {
            result = internationalOrderPay(wechatPay);//国际订单
        }
        if (!result.isSuccess()) {
            smsService.sendSms(smsConfig.getMobileNos(), result.getDesc(), SmsSendTypeEnum.QUNAER_PAY_FAIL_NOTIFY);
            if (wechatPay.getHasInlandOrder() == OrderCountryEnum.internal.getStatus()) {
                payFailOrderService.createOrder(wechatPay.getOrderNo(), PayChannelEnum.WECHAT);
            } else {
                ntsPayFailOrderService.createOrder(wechatPay.getOrderNo(), PayChannelEnum.WECHAT);
            }
        }
        return result.isSuccess();
    }

    private ExecuteResult nationalOrderPay(WechatPay wechatPay) {
        ExecuteResult result = new ExecuteResult();
        NationalOrder nationalOrder = nationalOrderDao.queryByOrderNo(wechatPay.getOrderNo());
        if (nationalOrder == null) {
            log.info("微信付款成功，但是数据库中未找到该笔订单,alipayId:{},ordrNo:{}", wechatPay.getId(), wechatPay.getOrderNo());
            return result;
        }
        QunarPayStatusEnum payStatus = QunarPayStatusEnum.NO_PAY;
        PayParam payParam = buildPayParam(nationalOrder.getClientSite(), nationalOrder.getPayOrderId());
        try {
            ApiResult<PayResultVO> apiResult = payService.pay(payParam);
            if (apiResult.isSuccess() && apiResult.getResult() != null && org.apache.commons.collections.CollectionUtils.isNotEmpty(apiResult.getResult().getResults())) {
                PayResultVO.PayFormResult payResult = apiResult.getResult().getResults().get(0);
                if ("SUCCESS".equalsIgnoreCase(payResult.getPayStatus())) {
                    payStatus = QunarPayStatusEnum.PAY_SUCCESS;
                } else {
                    payStatus = QunarPayStatusEnum.PAY_FAIL;
                }
            } else {
                payStatus = QunarPayStatusEnum.PAY_FAIL;
            }
            wechatPayDao.updateQunarPayInfo(wechatPay.getId(), payStatus.getStatus(), DateUtil.getCurrDate());
            if (payStatus == QunarPayStatusEnum.PAY_SUCCESS) {
                result.setSuccess(true);
            } else {
                result.setSuccess(false);
                if (apiResult != null && apiResult.getResult() != null) {
                    String desc = String.format(SmsConstants.QUNAR_PAY_FAIL_WECHAT, wechatPay.getOrderNo(), apiResult.getResult().getErrMsg());
                    result.setDesc(desc);
                    log.error(desc);
                }
            }
        } catch (Exception e) {
            result.setSuccess(false);
            String desc = String.format(SmsConstants.QUNAR_PAY_FAIL_WECHAT, wechatPay.getOrderNo(), e.getMessage());
            result.setDesc(desc);
            log.error(desc, e);
        }
        return result;
    }

    private ExecuteResult internationalOrderPay(WechatPay wechatPay) {
        ExecuteResult result = new ExecuteResult();
        InternationalOrder internationalOrder = internationalOrderDao.queryByOrderNo(wechatPay.getOrderNo());
        if (internationalOrderDao == null) {
            log.info("微信付款成功，但是数据库中未找到该笔订单,alipayId:{},orderNo:{}", wechatPay.getId(), wechatPay.getOrderNo());
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
            wechatPayDao.updateQunarPayInfo(wechatPay.getId(), payStatus.getStatus(), DateUtil.formatYYYYMM(new Date(apiResult.getCreateTime())));
            if (payStatus == QunarPayStatusEnum.PAY_SUCCESS) {
                result.setSuccess(true);
            } else {
                result.setSuccess(false);
                if (apiResult != null) {
                    String desc = String.format(SmsConstants.QUNAR_PAY_FAIL_WECHAT, wechatPay.getOrderNo(), apiResult.getMessage());
                    result.setDesc(desc);
                    log.error(desc);
                }
            }
        } catch (Exception e) {
            result.setSuccess(false);
            String desc = String.format(SmsConstants.QUNAR_PAY_FAIL_WECHAT, wechatPay.getOrderNo(), e.getMessage());
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
}
