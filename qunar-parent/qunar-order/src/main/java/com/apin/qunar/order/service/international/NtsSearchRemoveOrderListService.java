package com.apin.qunar.order.service.international;

import com.apin.qunar.order.domain.international.searchOrderList.InternationalOrderVO;

import java.util.List;

public interface NtsSearchRemoveOrderListService {
    List<InternationalOrderVO> queryPageList(String account, Integer status, Integer offset, Integer limit);

    Integer queryCount(String account, Integer status);
}