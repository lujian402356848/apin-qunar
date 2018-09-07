package com.apin.qunar.order.dao.impl;

import com.apin.qunar.order.dao.mapper.NationalReturnPassengerExtMapper;
import com.apin.qunar.order.dao.mapper.NationalReturnPassengerMapper;
import com.apin.qunar.order.dao.model.NationalReturnPassenger;
import com.apin.qunar.order.dao.model.NationalReturnPassengerExample;
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
public class NationalReturnPassengerDaoImpl {
    @Autowired
    private NationalReturnPassengerMapper nationalReturnPassengerMapper;
    @Autowired
    private NationalReturnPassengerExtMapper nationalReturnPassengerExtMapper;

    public boolean insert(NationalReturnPassenger nationalReturnPassenger) {
        return nationalReturnPassengerMapper.insert(nationalReturnPassenger) > 0;
    }


    public List<NationalReturnPassenger> queryByOrderNos(List<String> orderNos) {
        if (CollectionUtils.isEmpty(orderNos)) {
            return new ArrayList<>();
        }
        StringBuilder orderNoBuilder = new StringBuilder(orderNos.size() * 20);
        for (String orderNo : orderNos) {
            orderNoBuilder.append(",'");
            orderNoBuilder.append(orderNo);
            orderNoBuilder.append("'");
        }
        return nationalReturnPassengerExtMapper.queryByOrderNo(orderNoBuilder.substring(1).toString());
    }

    public List<NationalReturnPassenger> queryBy(String merchantNo, String orderNo, String pessengerName) {
        NationalReturnPassengerExample example = new NationalReturnPassengerExample();
        NationalReturnPassengerExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        if (StringUtils.isNotBlank(pessengerName)) {
            criteria.andNameEqualTo(pessengerName);
        }
        return nationalReturnPassengerMapper.selectByExample(example);
    }

    public boolean updateByOrderNo(String parentOrderNo, String orderNo) {
        return nationalReturnPassengerExtMapper.updateByOrderNo(parentOrderNo, orderNo) > 0;
    }
}