package com.apin.qunar.app.international.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.natioanl.request.PayStatusCallbackRequest;
import com.apin.qunar.order.service.international.NtsUpdateOrderService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

/**
 * @outhor lujian
 * @create 2018-07-02 19:34
 * 支付回调
 */

@Slf4j
@RestController
@RequestMapping("/qunar")
public class NtsPayCallbackController {
    @Autowired
    private NtsUpdateOrderService ntsUpdateOrderService;

    @PostMapping(value = "/ntsOrder/statusCallback", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void statusCallback(@RequestBody PayStatusCallbackRequest request) {
        log.info("国际订单状态回调,request:{}", JSON.toJSON(request));
        if (request == null || !"flight.international.supply.sl.orderStateChange".equalsIgnoreCase(request.getTag())) {
            return;
        }
        try {
            PayStatusCallbackData callbackData = getCallbackData(request.getData());
            if (callbackData != null) {
                log.info("国际订单状态回调,解析后:{}", JSON.toJSON(callbackData));
                ntsUpdateOrderService.updateStatus(callbackData.getOrderNo(), Integer.parseInt(callbackData.getToStatus()));
            }
        } catch (Exception e) {
            log.error("订单状态回调异常,request:{}", request, e);
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
        private String fromStatus;
        private String toStatus;
    }
}
