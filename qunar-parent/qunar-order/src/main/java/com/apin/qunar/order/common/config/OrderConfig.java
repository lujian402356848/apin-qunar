package com.apin.qunar.order.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @outhor lujian
 * @create 2018-06-21 20:59
 */
@Configuration
public class OrderConfig {
    @Value("${qunar.pay.account}")
    private String payAccount;
    @Value("${qunar.pay.callback}")
    private String payCallbackUrl;
    @Value("${qunar.pay.refund.callback}")
    private String payRefundCallbackUrl;
    @Value("${qunar.pay.type}")
    private String payType;
    @Value("${qunar.pay.bank.code}")
    private String bankCode;
    @Value("${qunar.register.username}")
    private String userName;
    @Value("${qunar.natioanl.source}")
    private String natioanlSource;
    @Value("${qunar.international.source}")
    private String internationalSource;

    public String getPayAccount() {
        return payAccount;
    }

    public String getPayCallbackUrl() {
        return payCallbackUrl;
    }

    public String getPayRefundCallbackUrl() {
        return payRefundCallbackUrl;
    }

    public String getPayType() {
        return payType;
    }

    public String getBankCode() {
        return bankCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getNatioanlSource() {
        return natioanlSource;
    }

    public String getInternationalSource() {
        return internationalSource;
    }
}
