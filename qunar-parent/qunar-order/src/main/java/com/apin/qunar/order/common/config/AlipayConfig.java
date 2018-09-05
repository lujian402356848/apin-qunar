package com.apin.qunar.order.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class AlipayConfig {
    @Value("${alipay.appid}")
    private String appId;
    @Value("${alipay.merchant.private.key}")
    private String merchantPrivateKey;
    @Value("${alipay.public.key}")
    private String alipayPublicKey;
    @Value("${alipay.notify.url}")
    private String notifyUrl;
    @Value("${alipay.sign.type}")
    private String signType;
    @Value("${alipay.charset}")
    private String charset;
    @Value("${alipay.gateway.url}")
    private String gatewayUrl;
    @Value("${alipay.format}")
    private String format;
    @Value("${alipay.version}")
    private String version;
    @Value("${alipay.qc_code.timeout.expiress}")
    private String qrCodeTimeoutExpress;
    @Value("${alipay.return.url}")
    private String returnUrl;
    @Value("${alipay.enable.pay.channels}")
    private String enablePayChannels;
}
