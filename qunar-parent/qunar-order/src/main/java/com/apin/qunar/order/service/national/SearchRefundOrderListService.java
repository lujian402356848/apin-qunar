package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.national.searchRefundOrderList.NationRefundOrderVO;

import java.util.List;

public interface SearchRefundOrderListService {
    List<NationRefundOrderVO> queryPageList(String merchantNo, String account, String orderNo, String pessengerName, Integer offset, Integer limit);
}
