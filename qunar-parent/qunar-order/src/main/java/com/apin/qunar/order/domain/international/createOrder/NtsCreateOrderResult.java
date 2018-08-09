package com.apin.qunar.order.domain.international.createOrder;

import lombok.Data;

/**
 * Created by wangliang.wang on 2017/10/28.
 */
@Data
public class NtsCreateOrderResult {
    private String orderNo;
    private String payDeadline;
    private String totalPrice;
}
