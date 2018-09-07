package com.apin.qunar.order.domain.pay.alipay;

import lombok.Data;


@Data
public class AlipayBO {
    private String merchantNo;
    private String orderNo;
    private Integer totalAmount;
    private boolean hasInlandOrder;
    private Integer orderType;
}