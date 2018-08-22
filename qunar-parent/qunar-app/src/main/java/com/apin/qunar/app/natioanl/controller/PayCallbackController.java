package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.natioanl.request.PayStatusCallbackRequest;
import com.apin.qunar.common.utils.Md5Util;
import com.apin.qunar.order.service.national.UpdateOrderService;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Collections;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-23 22:29
 * 订单支付回调
 */
@Slf4j
@RestController
@RequestMapping("/qunar")
public class PayCallbackController {
    @Autowired
    private UpdateOrderService dbOrderService;
    @Value("${qunar.natioanl.key}")
    private String key;

    @PostMapping(value = "/order/statusCallback")
    public void statusCallback(@RequestBody PayStatusCallbackRequest payStatusCallbackRequest) {
        log.info("国内订单状态回调,request:{}", JSON.toJSON(payStatusCallbackRequest));
        if (payStatusCallbackRequest == null || !"order.status.change".equalsIgnoreCase(payStatusCallbackRequest.getTag())) {
            return;
        }
        try {
            PayStatusCallbackData callbackData = getCallbackData(payStatusCallbackRequest.getData());
            if (!validateSign(payStatusCallbackRequest)) {
                log.error("国内订单状态回调签名验证不通过,request:{}",JSON.toJSON(callbackData));
                return;
            }
            if (callbackData != null) {
                log.info("国内订单状态回调,解析后:{}", JSON.toJSON(callbackData));
                dbOrderService.updateStatus(callbackData.getOrderNo(), callbackData.getStatus());
            }
        } catch (Exception e) {
            log.error("订单状态回调异常,request:{}", payStatusCallbackRequest, e);
        }
    }

    private PayStatusCallbackData getCallbackData(String data) {
        PayStatusCallbackData payStatusCallbackData = null;
        final Base64.Decoder decoder = Base64.getDecoder();
        try {
            payStatusCallbackData = JSON.parseObject(new String(decoder.decode(data), "UTF-8"), PayStatusCallbackData.class);
        } catch (Exception e) {
            log.error("订单状态回调解码失败,data:{}", data);
        }
        return payStatusCallbackData;
    }

    @Data
    public static class PayStatusCallbackData {
        private String orderNo;
        private int status;
    }

    private boolean validateSign(PayStatusCallbackRequest payStatusCallbackRequest) {

        boolean result = false;
        if (StringUtils.isBlank(payStatusCallbackRequest.getSign())) {
            return result;
        }
        List<String> requestParams  = getSortedList(payStatusCallbackRequest);
        Collections.sort(requestParams);
        String newSign = Md5Util.encrypt(getSignData(requestParams));
        if (newSign != null && !newSign.equalsIgnoreCase(payStatusCallbackRequest.getSign())) {
            return result;
        }
        result = true;
        return result;
    }

    private List<String> getSortedList(PayStatusCallbackRequest payStatusCallbackRequest) {
        List<String> signParams = null;
        try {
            signParams = Lists.newArrayList("data="+payStatusCallbackRequest.getData(),
                    "tag="+payStatusCallbackRequest.getTag(),
                    "createTime="+payStatusCallbackRequest.getCreateTime(),
                    "key="+key);
        } catch (Exception e) {
            signParams.clear();
            log.error("设置SortedList异常,request:{}", payStatusCallbackRequest, e);
        }
        return signParams;
    }

    private String getSignData(final List<String> requestParams) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String request:requestParams) {
            stringBuffer.append(request);
        }
        return stringBuffer.toString();
    }
}
