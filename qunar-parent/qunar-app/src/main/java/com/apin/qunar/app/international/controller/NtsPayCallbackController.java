package com.apin.qunar.app.international.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.natioanl.request.PayStatusCallbackRequest;
import com.apin.qunar.common.utils.Md5Util;
import com.apin.qunar.order.service.international.NtsUpdateOrderService;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Collections;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-02 19:34
 * 支付回调
 */

@Slf4j
@RestController
@RequestMapping("/qunar")
public class NtsPayCallbackController {
    @Value("${qunar.international.key}")
    private String key;
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
            if(!validateSign(request)) {
                log.info("国际订单状态回调验证签名不通过:{}", JSON.toJSON(request));
                return;
            }
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

    private boolean validateSign(PayStatusCallbackRequest request){
        boolean result = false;
        if(StringUtils.isBlank(request.getSign())){
            return result;
        }
        List<String> list = getSortedList(request);
        Collections.sort(list);
        String newSign = Md5Util.encrypt(getSignData(list));
        if (newSign != null && !newSign.equalsIgnoreCase(request.getSign())) {
            return result;
        }
        result = true;
        return result;
    }

    private List<String> getSortedList(PayStatusCallbackRequest request){
        List<String> list = null;
        try{
            list = Lists.newArrayList("data="+request.getData(),
                    "tag="+request.getTag(),
                    "createTime="+request.getCreateTime(),
                    "key="+key);
        }catch (Exception e) {
            list.clear();
            log.error("设置SortedList异常,request:{}", request, e);
        }
        return list;
    }

    private String getSignData(List<String> lists){
        StringBuffer stringBuffer = new StringBuffer();
        for (String list:
             lists) {
            stringBuffer.append(list);
        }
        return stringBuffer.toString();
    }
}
