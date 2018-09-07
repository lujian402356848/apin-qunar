package com.apin.qunar.order.dao.impl;

import com.apin.qunar.order.dao.mapper.NationalPassengerExtMapper;
import com.apin.qunar.order.dao.mapper.NationalPassengerMapper;
import com.apin.qunar.order.dao.model.NationalPassenger;
import com.apin.qunar.order.dao.model.NationalPassengerExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-24 16:00
 */
@Repository
public class NationalPassengerDaoImpl {
    @Autowired
    private NationalPassengerMapper nationalPassengerMapper;
    @Autowired
    private NationalPassengerExtMapper nationalPassengerExtMapper;

    public List<NationalPassenger> queryByOrderNo(String orderNo) {
        if (StringUtils.isBlank(orderNo)) {
            return new ArrayList<>();
        }
        NationalPassengerExample example = new NationalPassengerExample();
        NationalPassengerExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        return nationalPassengerMapper.selectByExample(example);
    }

    public List<NationalPassenger> queryByOrderNos(List<String> orderNos) {
        if (CollectionUtils.isEmpty(orderNos)) {
            return new ArrayList<>();
        }
        StringBuilder orderNoBuilder = new StringBuilder(orderNos.size() * 20);
        for (String orderNo : orderNos) {
            orderNoBuilder.append(",'");
            orderNoBuilder.append(orderNo);
            orderNoBuilder.append("'");
        }
        return nationalPassengerExtMapper.queryByOrderNo(orderNoBuilder.substring(1).toString());
    }

    public List<String> queryMobileNoByOrderNo(String orderNo) {
        if (StringUtils.isBlank(orderNo)) {
            return new ArrayList<>();
        }
        return nationalPassengerExtMapper.queryMobileNoByOrderNo(orderNo);
    }

    public List<NationalPassenger> queryBy(String merchantNo, String orderNo, String pessengerName) {
        NationalPassengerExample example = new NationalPassengerExample();
        NationalPassengerExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        if (StringUtils.isNotBlank(pessengerName)) {
            criteria.andNameEqualTo(pessengerName);
        }
        return nationalPassengerMapper.selectByExample(example);
    }

    public NationalPassenger queryBy( String orderNo, String pessengerName) {
        NationalPassengerExample example = new NationalPassengerExample();
        NationalPassengerExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        if (StringUtils.isNotBlank(pessengerName)) {
            criteria.andNameEqualTo(pessengerName);
        }
        List<NationalPassenger> nationalPassengers = nationalPassengerMapper.selectByExample(example);
        return CollectionUtils.isEmpty(nationalPassengers) ? null : nationalPassengers.get(0);
    }
    public boolean insert(NationalPassenger nationalPassenger) {
        return nationalPassengerMapper.insert(nationalPassenger) > 0;
    }
}