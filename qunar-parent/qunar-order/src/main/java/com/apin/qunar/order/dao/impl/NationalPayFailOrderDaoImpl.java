package com.apin.qunar.order.dao.impl;

import com.apin.qunar.order.dao.mapper.NationalPayFailOrderMapper;
import com.apin.qunar.order.dao.model.InternationalPayFailOrder;
import com.apin.qunar.order.dao.model.InternationalPayFailOrderExample;
import com.apin.qunar.order.dao.model.NationalPayFailOrder;
import com.apin.qunar.order.dao.model.NationalPayFailOrderExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class NationalPayFailOrderDaoImpl {
    @Autowired
    private NationalPayFailOrderMapper nationalPayFailOrderMapper;

    public List<NationalPayFailOrder> queryBy(String merchantNo, String orderNo, Date startTime, Date endTime, Integer offset, Integer limit) {
        NationalPayFailOrderExample example = new NationalPayFailOrderExample();
        NationalPayFailOrderExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        if (startTime != null) {
            criteria.andInsertTimeGreaterThanOrEqualTo(startTime);
        }
        if (endTime != null) {
            criteria.andInsertTimeLessThanOrEqualTo(endTime);
        }
        example.setMysqlOffset(offset);
        example.setMysqlLength(limit);
        example.setOrderByClause("insert_time asc");
        return nationalPayFailOrderMapper.selectByExample(example);
    }

    public NationalPayFailOrder queryByOrderNo(String orderNo) {
        if (StringUtils.isBlank(orderNo)) {
            return null;
        }
        NationalPayFailOrderExample example = new NationalPayFailOrderExample();
        NationalPayFailOrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<NationalPayFailOrder> payFailOrders = nationalPayFailOrderMapper.selectByExample(example);
        return CollectionUtils.isEmpty(payFailOrders) ? null : payFailOrders.get(0);
    }

    public boolean updateById(NationalPayFailOrder nationalPayFailOrder) {
        if (nationalPayFailOrder == null || StringUtils.isBlank(nationalPayFailOrder.getOrderNo())) {
            return false;
        }
        return nationalPayFailOrderMapper.updateByPrimaryKey(nationalPayFailOrder) > 0;
    }

    public boolean insert(NationalPayFailOrder nationalPayFailOrder) {
        return nationalPayFailOrderMapper.insert(nationalPayFailOrder) > 0;
    }
}
