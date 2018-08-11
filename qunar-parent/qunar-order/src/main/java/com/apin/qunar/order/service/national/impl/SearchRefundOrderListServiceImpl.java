package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.common.utils.BeanUtil;
import com.apin.qunar.order.dao.impl.NationalReturnOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalReturnPassengerDaoImpl;
import com.apin.qunar.order.dao.model.NationalReturnOrder;
import com.apin.qunar.order.dao.model.NationalReturnPassenger;
import com.apin.qunar.order.domain.national.searchRefundOrderList.NationRefundOrderVO;
import com.apin.qunar.order.service.national.SearchRefundOrderListService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @outhor ligang
 * @create 2018-07-30 16:36
 */
@Service
public class SearchRefundOrderListServiceImpl implements SearchRefundOrderListService {
    @Autowired
    private NationalReturnOrderDaoImpl nationalReturnOrderDao;
    @Autowired
    private NationalReturnPassengerDaoImpl nationalReturnPassengerDao;

    @Override
    public List<NationRefundOrderVO> queryPageList(String merchantNo, String account, String orderNo, String pessengerName, Integer offset, Integer limit) {
        merchantNo="20180726460336";
        List<NationalReturnOrder> nationalReturnOrders = null;
        List<NationalReturnPassenger> passengers = null;
        if (StringUtils.isNotBlank(pessengerName)) {
            passengers = nationalReturnPassengerDao.queryBy(merchantNo, orderNo, pessengerName);
            if (CollectionUtils.isNotEmpty(passengers)) {
                List<String> orderNos = passengers.stream().map(p -> p.getOrderNo()).collect(Collectors.toList());
                nationalReturnOrders = nationalReturnOrderDao.queryPageListBy(merchantNo, orderNos, offset, limit);
            }
        } else {
            nationalReturnOrders = nationalReturnOrderDao.queryPageListBy(merchantNo, account, orderNo, offset, limit);
            List<String> orderNos = nationalReturnOrders.stream().map(p -> p.getOrderNo()).collect(Collectors.toList());
            passengers = nationalReturnPassengerDao.queryByOrderNos(orderNos);
        }
        return buildNationalOrderDTO(nationalReturnOrders, passengers);
    }

    private List<NationRefundOrderVO> buildNationalOrderDTO(final List<NationalReturnOrder> orders, final List<NationalReturnPassenger> passengers) {
        List<NationRefundOrderVO> nationRefundOrderVOS = new ArrayList<>();
        if (CollectionUtils.isEmpty(orders)) {
            return nationRefundOrderVOS;
        }
        NationRefundOrderVO nationRefundOrderVO = null;
        for (NationalReturnOrder order : orders) {
            nationRefundOrderVO = BeanUtil.copyProperties(order, NationRefundOrderVO.class);
            List<NationalReturnPassenger> filterPassenger = passengers.stream().filter(p -> p.getOrderNo().equals(order.getOrderNo())).collect(Collectors.toList());
            nationRefundOrderVO.setPassengers(buildPassengers(filterPassenger));
            nationRefundOrderVOS.add(nationRefundOrderVO);
        }
        return nationRefundOrderVOS;
    }

    private String buildPassengers(List<NationalReturnPassenger> passengers) {
        StringBuilder passengerBuilder = new StringBuilder(passengers.size() * 5);
        for (NationalReturnPassenger passenger : passengers) {
            passengerBuilder.append("/");
            passengerBuilder.append(passenger.getName());
        }
        return passengerBuilder.length() < 1 ? "" : passengerBuilder.substring(1).toString();
    }
}
