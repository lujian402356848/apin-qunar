package com.apin.qunar.order.domain.national.changePay;

import lombok.Data;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-17 17:06
 */
@Data
public class ChangePayResultVO {

        private int code;
        private String errMsg;
        private List<PayFormResult> results;

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
