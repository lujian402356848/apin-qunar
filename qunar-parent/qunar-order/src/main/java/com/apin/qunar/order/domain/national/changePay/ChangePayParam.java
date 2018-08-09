package com.apin.qunar.order.domain.national.changePay;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-07-02 15:47
 */
@Data
public class ChangePayParam {
    private String orderNo;
    private String gqId;
    private String passengerIds;
    private String totalAmount;
    private String pmCode;
    private String bankCode;
    private String paymentMerchantCode;
    private String curId;
    private String callbackUrl;
    private String validTime;
    private String applyRemarks;
}