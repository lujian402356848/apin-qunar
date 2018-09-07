package com.apin.qunar.order.service.group;


import com.apin.qunar.order.domain.group.searchOrderList.GroupOrderParam;
import com.apin.qunar.order.domain.group.searchOrderList.GroupOrderResultVO;

import java.util.List;

/**
 * @outhor ligang
 * @create 2018-07-19 21:54
 */
public interface GroupOrderService {
    List<GroupOrderResultVO> queryList(GroupOrderParam groupOrderParam);
}
