package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.natioanl.request.PayStatusCallbackRequest;
import com.apin.qunar.order.service.national.UpdateOrderService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

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

    @PostMapping(value = "/order/statusCallback")
    public void statusCallback(@RequestBody PayStatusCallbackRequest payStatusCallbackRequest) {
        log.info("国内订单状态回调,request:{}", JSON.toJSON(payStatusCallbackRequest));
        if (payStatusCallbackRequest == null || !"order.status.change".equalsIgnoreCase(payStatusCallbackRequest.getTag())) {
            return;
        }
        try {
            PayStatusCallbackData callbackData = getCallbackData(payStatusCallbackRequest.getData());
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
}
