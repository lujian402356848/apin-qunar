package com.apin.qunar.order.service.national;

import com.apin.qunar.basic.domain.ExecuteResult;

public interface RemoveOrderService {
    /**
     * 删除订单
     * @param orderNo
     * @param account
     * @return
     */
    ExecuteResult remove(String orderNo, String account);
}
