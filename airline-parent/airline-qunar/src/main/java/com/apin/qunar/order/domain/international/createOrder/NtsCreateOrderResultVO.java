package com.apin.qunar.order.domain.international.createOrder;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-07-17 16:44
 */
@Data
public class NtsCreateOrderResultVO {
    private String orderNo;
    private String payDeadline;
    private String totalPrice;
    private boolean priceChange;
}
