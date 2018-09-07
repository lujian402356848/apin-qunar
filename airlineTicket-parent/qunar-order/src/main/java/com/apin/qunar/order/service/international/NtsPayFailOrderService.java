package com.apin.qunar.order.service.international;

import com.apin.qunar.order.common.enums.PayChannelEnum;
import com.apin.qunar.order.domain.international.payFailOrder.NtsPayFailOrderVO;

import java.util.Date;
import java.util.List;

public interface NtsPayFailOrderService {
    List<NtsPayFailOrderVO> queryPageList(String merchantNo, String orderNo, Date startTime, Date endTime, Integer offset, Integer limit);

    void createOrder(String orderNo, PayChannelEnum payChannelEnum);

    boolean updateOrder(String orderNo, Integer status, Integer payAmount, String desc, String operator);
}
