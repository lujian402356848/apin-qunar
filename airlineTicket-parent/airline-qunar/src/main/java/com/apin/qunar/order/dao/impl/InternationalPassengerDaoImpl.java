package com.apin.qunar.order.dao.impl;

import com.apin.qunar.order.dao.mapper.InternationalPassengerExtMapper;
import com.apin.qunar.order.dao.mapper.InternationalPassengerMapper;
import com.apin.qunar.order.dao.model.InternationalPassenger;
import com.apin.qunar.order.dao.model.InternationalPassengerExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-09 10:16
 */
@Repository
public class InternationalPassengerDaoImpl {
    @Autowired
    private InternationalPassengerMapper internationalPassengerMapper;
    @Autowired
    private InternationalPassengerExtMapper internationalPassengerExtMapper;

    public List<InternationalPassenger> queryByOrderNo(String orderNo) {
        InternationalPassengerExample example = new InternationalPassengerExample();
        InternationalPassengerExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        return internationalPassengerMapper.selectByExample(example);
    }

    public List<InternationalPassenger> queryBy(String merchantNo, String orderNo, String pessengerName) {
        InternationalPassengerExample example = new InternationalPassengerExample();
        InternationalPassengerExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        if (StringUtils.isNotBlank(pessengerName)) {
            criteria.andNameEqualTo(pessengerName);
        }
        return internationalPassengerMapper.selectByExample(example);
    }

    public List<String> queryMobileNoByOrderNo(String orderNo) {
        if (StringUtils.isBlank(orderNo)) {
            return new ArrayList<>();
        }
        return internationalPassengerExtMapper.queryMobileNoByOrderNo(orderNo);
    }

    public List<InternationalPassenger> queryByOrderNos(List<String> orderNos) {
        if (CollectionUtils.isEmpty(orderNos)) {
            return new ArrayList<>();
        }
        StringBuilder orderNoBuilder = new StringBuilder(orderNos.size() * 20);
        for (String orderNo : orderNos) {
            orderNoBuilder.append(",'");
            orderNoBuilder.append(orderNo);
            orderNoBuilder.append("'");
        }
        return internationalPassengerExtMapper.queryByOrderNo(orderNoBuilder.substring(1).toString());
    }

    public boolean insert(InternationalPassenger internationalPassenger) {
        return internationalPassengerMapper.insert(internationalPassenger) > 0;
    }
}
