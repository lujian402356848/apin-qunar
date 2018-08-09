package com.apin.qunar.order.domain.national.pay;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangliang.wang on 2018/6/10.
 */
@Data
public class PayResultVO {
    private int code;
    private String errMsg;
    private List<PayFormResult> results = new ArrayList();

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
