package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.national.searchChangeOrderList.NationalChangeOrderVO;

import java.util.List;


public interface SearchChangeOrderListService {
    List<NationalChangeOrderVO> queryPageList(String merchantNo, String account, Integer status, String orderNo, String pessengerName, Integer offset, Integer limit);

    Integer queryCount(String merchantNo, String account, Integer status, String orderNo, String pessengerName);
}
