package com.apin.qunar.order.domain.international.cancelOrder;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-07-17 16:43
 */
@Data
public class NtsCancelOrderResultVO {
    private OrderDetail result;

    @Data
    public static class OrderDetail {
        private String orderNo;
    }
}
