package com.apin.qunar.order.dao.impl;

import com.apin.qunar.order.dao.mapper.NationalChangePassengerExtMapper;
import com.apin.qunar.order.dao.mapper.NationalChangePassengerMapper;
import com.apin.qunar.order.dao.model.NationalChangePassenger;
import com.apin.qunar.order.dao.model.NationalChangePassengerExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @outhor ligang
 * @create 2018-08-07 16:00
 */
@Repository
public class NationalChangePassengerDaoImpl {
    @Autowired
    private NationalChangePassengerMapper nationalChangePassengerMapper;
    @Autowired
    private NationalChangePassengerExtMapper nationalChangePassengerExtMapper;

    public boolean insert(NationalChangePassenger nationalChangePassenger) {
        return nationalChangePassengerMapper.insert(nationalChangePassenger) > 0;
    }


    public List<NationalChangePassenger> queryByOrderNos(List<String> orderNos) {
        if (CollectionUtils.isEmpty(orderNos)) {
            return new ArrayList<>();
        }
        StringBuilder orderNoBuilder = new StringBuilder(orderNos.size() * 20);
        for (String orderNo : orderNos) {
            orderNoBuilder.append(",'");
            orderNoBuilder.append(orderNo);
            orderNoBuilder.append("'");
        }
        return nationalChangePassengerExtMapper.queryByOrderNo(orderNoBuilder.substring(1).toString());
    }

    public List<NationalChangePassenger> queryBy(String merchantNo, String orderNo, String pessengerName) {
        NationalChangePassengerExample example = new NationalChangePassengerExample();
        NationalChangePassengerExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        if (StringUtils.isNotBlank(pessengerName)) {
            criteria.andNameEqualTo(pessengerName);
        }
        return nationalChangePassengerMapper.selectByExample(example);
    }


    public List<NationalChangePassenger> queryByOrderNo(String orderNo) {
        NationalChangePassengerExample example = new NationalChangePassengerExample();
        NationalChangePassengerExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        return nationalChangePassengerMapper.selectByExample(example);
    }

}