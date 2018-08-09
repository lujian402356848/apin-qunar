package com.apin.qunar.order.domain.national.changePay;

import lombok.Data;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-23 22:19
 */
@Data
public class ChangePayResult {
    private PayResult result;

    @Data
    public static class PayResult {
        private int code;
        private List<PayFormResult> results;
    }

    @Data
    public static class PayFormResult {
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
}