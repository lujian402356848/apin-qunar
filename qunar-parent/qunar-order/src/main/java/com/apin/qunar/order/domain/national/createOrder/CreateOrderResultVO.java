package com.apin.qunar.order.domain.national.createOrder;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-07-17 17:05
 */
@Data
public class CreateOrderResultVO {
    private long id;
    private int noPayAmount;
    private String orderNo;
    private int status;
    private String clientSite;
}
