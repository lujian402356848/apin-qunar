package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.common.utils.BeanUtil;
import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalPassengerDaoImpl;
import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.dao.model.NationalPassenger;
import com.apin.qunar.order.domain.national.searchOrderList.NationalOrderVO;
import com.apin.qunar.order.service.national.SearchOrderListService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
public class SearchOrderListServiceImpl implements SearchOrderListService {
    @Autowired
    private NationalOrderDaoImpl nationalOrderDao;
    @Autowired
    private NationalPassengerDaoImpl nationalPassengerDao;

    @Override
    public List<NationalOrderVO> queryPageList(String merchantNo, final String account, final String orderNo, final String pessengerName, final Integer offset, final Integer limit) {
        merchantNo="20180726460336";
        List<NationalOrder> nationalOrders = null;
        List<NationalPassenger> passengers = null;
        if (StringUtils.isNotBlank(pessengerName)) {
            passengers = nationalPassengerDao.queryBy(merchantNo, orderNo, pessengerName);
            if (CollectionUtils.isNotEmpty(passengers)) {
                List<String> orderNos = passengers.stream().map(p -> p.getOrderNo()).collect(Collectors.toList());
                nationalOrders = nationalOrderDao.queryPageListBy(merchantNo, orderNos, offset, limit);
            }
        } else {
            nationalOrders = nationalOrderDao.queryPageListBy(merchantNo, account, orderNo, offset, limit);
            List<String> orderNos = nationalOrders.stream().map(p -> p.getOrderNo()).collect(Collectors.toList());
            passengers = nationalPassengerDao.queryByOrderNos(orderNos);
        }
        return buildNationalOrderDTO(nationalOrders, passengers, merchantNo);
    }

    private List<NationalOrderVO> buildNationalOrderDTO(final List<NationalOrder> orders, final List<NationalPassenger> passengers, final String merchantNo) {
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
}