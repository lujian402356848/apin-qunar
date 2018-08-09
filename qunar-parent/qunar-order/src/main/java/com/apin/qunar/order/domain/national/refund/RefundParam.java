package com.apin.qunar.order.domain.national.refund;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-06-26 10:11
 */
@Data
public class RefundParam {
    private String orderNo;
    private String refundCauseId = "16";//16:改变行程,17:填错信息,18:航班延误,19:身体原因
    private String passengerIds;
    private String refundCause;
    private String callbackUrl;
    private String operator;
}
