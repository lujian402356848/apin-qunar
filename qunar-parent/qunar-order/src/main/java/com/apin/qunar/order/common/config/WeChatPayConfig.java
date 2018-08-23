package com.apin.qunar.order.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
public class WeChatPayConfig {
    @Value("${weChatPay.appid}")
    private String appId;
    @Value("${weChatPay.merchantId}")
    private String merchantId;
    @Value("${weChatPay.key}")
    private String key;
    @Value("${weChatPay.pay.url}")
    private String payUrl;
    @Value("${weChatPay.query.url}")
    private String queryUrl;
    @Value("${weChatPay.notify.url}")
    private String notifyUrl;
    @Value("${weChatPay.rufund.url}")
    private String refundUrl;
    @Value("${weChatPay.cert.path}")
    private String certPath;
}
