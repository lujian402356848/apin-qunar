package com.apin.qunar.app.natioanl.request;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-06-27 21:20
 */
@Data
public class PayCallbackRequest {
    private String orderNo;
    private String orderDate;
    private String pmCode;
    private String bankCode;
    private String payId;
    private String payAmount;
    private String payStatus;
    private String payTime;
    private String errCode;
    private String errMsg;
}
