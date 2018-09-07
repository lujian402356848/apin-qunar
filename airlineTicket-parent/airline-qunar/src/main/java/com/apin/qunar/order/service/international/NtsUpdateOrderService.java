package com.apin.qunar.order.service.international;

/**
 * @outhor lujian
 * @create 2018-07-09 12:25
 */
public interface NtsUpdateOrderService {
    boolean updatePayInfo(String orderNo, String payId, int orderStatus, String payTime);

    boolean updateStatus(String orderNo, int payStatus);
}
