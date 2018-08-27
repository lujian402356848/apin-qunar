package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.common.utils.BeanUtil;
import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalPassengerDaoImpl;
import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.dao.model.NationalPassenger;
import com.apin.qunar.order.domain.national.searchOrderList.NationalOrderVO;
import com.apin.qunar.order.service.national.SearchRemoveOrderListService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @outhor lujian
 * @create 2018-07-20 18:59
 */
@Service
public class SearchRemoveOrderListServiceImpl implements SearchRemoveOrderListService {
    @Autowired
    private NationalOrderDaoImpl nationalOrderDao;
    @Autowired
    private NationalPassengerDaoImpl nationalPassengerDao;

    @Override
    public List<NationalOrderVO> queryPageList(final String account, final Integer status, final Integer offset, final Integer limit) {
        List<NationalOrder> nationalOrders = nationalOrderDao.queryPageListBy(account, status, offset, limit);
        List<String> orderNos = nationalOrders.stream().map(p -> p.getOrderNo()).collect(Collectors.toList());
        List<NationalPassenger> passengers = nationalPassengerDao.queryByOrderNos(orderNos);
        return buildNationalOrderDTO(nationalOrders, passengers);
    }

    private List<NationalOrderVO> buildNationalOrderDTO(final List<NationalOrder> orders, final List<NationalPassenger> passengers) {
        List<NationalOrderVO> nationalOrderVOS = new ArrayList<>();
        if (CollectionUtils.isEmpty(orders)) {
            return nationalOrderVOS;
        }
        NationalOrderVO nationalOrderVO = null;
        for (NationalOrder order : orders) {
            nationalOrderVO = BeanUtil.copyProperties(order, NationalOrderVO.class);
            List<NationalPassenger> filterPassenger = passengers.stream().filter(p -> p.getOrderNo().equals(order.getOrderNo())).collect(Collectors.toList());
            nationalOrderVO.setPassengers(buildPassengers(filterPassenger));
            nationalOrderVOS.add(nationalOrderVO);
        }
        return nationalOrderVOS;
    }

    private String buildPassengers(List<NationalPassenger> passengers) {
        StringBuilder passengerBuilder = new StringBuilder(passengers.size() * 5);
        for (NationalPassenger passenger : passengers) {
            passengerBuilder.append("/");
            passengerBuilder.append(passenger.getName());
        }
        return passengerBuilder.length() < 1 ? "" : passengerBuilder.substring(1).toString();
    }

    @Override
    public Integer queryCount(final String merchantNo, final String account, final Integer status) {
        return nationalOrderDao.queryRemoveCount(account, status);
    }
}