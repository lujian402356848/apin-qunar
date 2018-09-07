package com.apin.qunar.order.service.national;

/**
 * @outhor lujian
 * @create 2018-07-02 11:07
 */
public interface UpdateOrderService {

    boolean updatePayInfo(String orderNo, String payId, int orderStatus, String payTime);

    boolean updateStatus(String orderNo, int payStatus);
}
