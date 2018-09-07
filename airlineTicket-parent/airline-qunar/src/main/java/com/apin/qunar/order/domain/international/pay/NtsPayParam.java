package com.apin.qunar.order.domain.international.pay;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-06-25 15:20
 */
@Data
public class NtsPayParam {
    private String source;
    private String orderNo;
    private String pmcode;
    //账号类型，支付宝ALIPAY，mppm余额QUNARPAY
    private String bankcode;
    //支付账号
    private String paymentMerchantCode;
}
