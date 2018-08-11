package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.national.searchOrderList.NationalOrderVO;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-20 18:59
 */
public interface SearchOrderListService {
    List<NationalOrderVO> queryPageList(String merchantNo, String account, Integer status, String orderNo, String pessengerName, Integer offset, Integer limit);
}