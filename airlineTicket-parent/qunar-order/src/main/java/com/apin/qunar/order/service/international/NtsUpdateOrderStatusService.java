package com.apin.qunar.order.service.international;

import com.apin.qunar.basic.domain.ExecuteResult;

public interface NtsUpdateOrderStatusService {
    /**
     * 删除订单
     *
     * @param orderNo
     * @param account
     * @return
     */
    ExecuteResult remove(String orderNo, String account);
    /**
     * 取消删除订单
     *
     * @param orderNo
     * @param account
     * @return
     */
    ExecuteResult cancelRemove(String orderNo, String account);
}