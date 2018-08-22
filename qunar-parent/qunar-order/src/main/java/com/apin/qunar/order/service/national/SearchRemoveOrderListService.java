package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.national.searchOrderList.NationalOrderVO;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-20 18:59
 */
public interface SearchRemoveOrderListService {
    List<NationalOrderVO> queryPageList(String account, Integer status, Integer offset, Integer limit);
}