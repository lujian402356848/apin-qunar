package com.apin.qunar.order.domain.national.refund;

import lombok.Data;

@Data
public class RefundRequestBO {
    private String merchantNo;
    private String orderNo;
    private String refundCauseId;//16:改变行程,17:填错信息,18:航班延误,19:身体原因
    private String passengerIds;
    private String refundCause;
    private String account;//退票操作人
}
