package com.apin.qunar.order.domain.international.cancelOrder;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-06-25 14:49
 */
@Data
public class NtsCancelOrderResult {
    private OrderDetail result;

    @Data
    public static class OrderDetail {
        private String orderNo;
    }
}