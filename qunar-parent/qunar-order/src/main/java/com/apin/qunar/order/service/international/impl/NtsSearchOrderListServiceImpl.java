package com.apin.qunar.order.service.international.impl;

import com.apin.qunar.basic.service.MerchantPriceConfigService;
import com.apin.qunar.common.utils.BeanUtil;
import com.apin.qunar.order.dao.impl.InternationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.InternationalPassengerDaoImpl;
import com.apin.qunar.order.dao.model.InternationalOrder;
import com.apin.qunar.order.dao.model.InternationalPassenger;
import com.apin.qunar.order.domain.international.searchOrderList.InternationalOrderVO;
import com.apin.qunar.order.service.international.NtsSearchOrderListService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @outhor lujian
 * @create 2018-07-27 6:45
 */
@Slf4j
@Service
public class NtsSearchOrderListServiceImpl implements NtsSearchOrderListService {
    @Autowired
    private InternationalOrderDaoImpl internationalOrderDao;
    @Autowired
    private InternationalPassengerDaoImpl internationalPassengerDao;
    @Autowired
    private MerchantPriceConfigService merchantPriceConfigService;

    @Override
    public List<InternationalOrderVO> queryPageList(String merchantNo, String account, String orderNo, String pessengerName, Integer offset, Integer limit) {
        merchantNo="20180726460336";
        List<InternationalOrder> internationalOrders = null;
        List<InternationalPassenger> passengers = null;
        if (StringUtils.isNotBlank(pessengerName)) {
            passengers = internationalPassengerDao.queryBy(merchantNo, orderNo, pessengerName);
            if (CollectionUtils.isNotEmpty(passengers)) {
                List<String> orderNos = passengers.stream().map(p -> p.getOrderNo()).collect(Collectors.toList());
                internationalOrders = internationalOrderDao.queryPageListBy(merchantNo, orderNos, offset, limit);
            }
        } else {
            internationalOrders = internationalOrderDao.queryPageListBy(merchantNo, account, orderNo, offset, limit);
            List<String> orderNos = internationalOrders.stream().map(p -> p.getOrderNo()).collect(Collectors.toList());
            passengers = internationalPassengerDao.queryByOrderNos(orderNos);
        }
        return buildInternationalOrder(internationalOrders, passengers, merchantNo);
    }

    private List<InternationalOrderVO> buildInternationalOrder(final List<InternationalOrder> internationalOrders, final List<InternationalPassenger> passengers, final String merchantNo) {
//        double ratio = merchantPriceConfigService.queryPriceRatio(merchantNo, false);
        List<InternationalOrderVO> internationalOrderVOS = new ArrayList<>();
        InternationalOrderVO internationalOrderVO = null;
        for (InternationalOrder internationalOrder : internationalOrders) {
//            internationalOrder.setPayAmount((int) (internationalOrder.getPayAmount() * ratio));
            internationalOrderVO = BeanUtil.copyProperties(internationalOrder, InternationalOrderVO.class);
            List<InternationalPassenger> filterPassengerVOS = passengers.stream().filter(p -> p.getOrderNo().equals(internationalOrder.getOrderNo())).collect(Collectors.toList());
            internationalOrderVO.setPassengers(buildPassengers(filterPassengerVOS));
            internationalOrderVOS.add(internationalOrderVO);
        }
        return internationalOrderVOS;
    }

    private String buildPassengers(List<InternationalPassenger> internationalPassengers) {
        StringBuilder passengerBuilder = new StringBuilder(internationalPassengers.size() * 5);
        for (InternationalPassenger internationalPassenger : internationalPassengers) {
            passengerBuilder.append("/");
            passengerBuilder.append(internationalPassenger.getName());
        }
        return passengerBuilder.length() < 1 ? "" : passengerBuilder.substring(1).toString();
    }
}
