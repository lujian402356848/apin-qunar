package com.apin.qunar.basic.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @outhor lujian
 * @create 2018-07-30 9:23
 */
@Data
@Configuration
public class SmsConfig {
    @Value("${sms.send.url}")
    private String url;
    @Value("${sms.send.userId}")
    private String userId;
    @Value("${sms.send.account}")
    private String account;
    @Value("${sms.send.password}")
    private String password;
    @Value("${sms.send.enable}")
    private int enable;
    @Value("${sms.notify.mobileNos}")
    private String mobileNos;
}
