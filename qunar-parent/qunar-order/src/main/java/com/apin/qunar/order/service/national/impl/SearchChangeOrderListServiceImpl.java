package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.common.utils.BeanUtil;
import com.apin.qunar.order.dao.impl.NationalChangeOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalChangePassengerDaoImpl;
import com.apin.qunar.order.dao.model.NationalChangeOrder;
import com.apin.qunar.order.dao.model.NationalChangePassenger;
import com.apin.qunar.order.domain.national.searchChangeOrderList.NationalChangeOrderVO;
import com.apin.qunar.order.service.national.SearchChangeOrderListService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @outhor ligang
 * @create 2018-08-07 15:16
 */
@Service
public class SearchChangeOrderListServiceImpl implements SearchChangeOrderListService {
    @Autowired
    private NationalChangeOrderDaoImpl nationalChangeOrderDao;
    @Autowired
    private NationalChangePassengerDaoImpl nationalChangePassengerDao;

    @Override
    public List<NationalChangeOrderVO> queryPageList(String merchantNo, String account, Integer status, String orderNo, String pessengerName, Integer offset, Integer limit) {
        List<NationalChangeOrder> nationalChangeOrders = null;
        List<NationalChangePassenger> passengers = null;
        if (StringUtils.isNotBlank(pessengerName)) {
            passengers = nationalChangePassengerDao.queryBy("", orderNo, pessengerName);
            if (CollectionUtils.isNotEmpty(passengers)) {
                List<String> orderNos = passengers.stream().map(p -> p.getOrderNo()).collect(Collectors.toList());
                nationalChangeOrders = nationalChangeOrderDao.queryPageListBy(merchantNo, status, orderNos, offset, limit);
            }
        } else {
            nationalChangeOrders = nationalChangeOrderDao.queryPageListBy("", account, status, orderNo, offset, limit);
            List<String> orderNos = nationalChangeOrders.stream().map(p -> p.getOrderNo()).collect(Collectors.toList());
            passengers = nationalChangePassengerDao.queryByOrderNos(orderNos);
        }
        return buildNationalOrderDTO(nationalChangeOrders, passengers);
    }

    private List<NationalChangeOrderVO> buildNationalOrderDTO(final List<NationalChangeOrder> orders, final List<NationalChangePassenger> passengers) {
        List<NationalChangeOrderVO> NationalChangeOrderVOS = new ArrayList<>();
        if (CollectionUtils.isEmpty(orders)) {
            return NationalChangeOrderVOS;
        }
        NationalChangeOrderVO nationalChangeOrderVO = null;
        for (NationalChangeOrder order : orders) {
            nationalChangeOrderVO = BeanUtil.copyProperties(order, NationalChangeOrderVO.class);
            List<NationalChangePassenger> filterPassenger = passengers.stream().filter(p -> p.getOrderNo().equals(order.getOrderNo())).collect(Collectors.toList());
            nationalChangeOrderVO.setPassengers(buildPassengers(filterPassenger));
            NationalChangeOrderVOS.add(nationalChangeOrderVO);
        }
        return NationalChangeOrderVOS;
    }

    private String buildPassengers(List<NationalChangePassenger> passengers) {
        StringBuilder passengerBuilder = new StringBuilder(passengers.size() * 5);
        for (NationalChangePassenger passenger : passengers) {
            passengerBuilder.append("/");
            passengerBuilder.append(passenger.getName());
        }
        return passengerBuilder.length() < 1 ? "" : passengerBuilder.substring(1).toString();
    }
}
