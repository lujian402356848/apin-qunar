package com.apin.qunar.order.dao.impl;

import com.apin.qunar.order.dao.mapper.InternationalPayFailOrderMapper;
import com.apin.qunar.order.dao.model.InternationalPayFailOrder;
import com.apin.qunar.order.dao.model.InternationalPayFailOrderExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class InternationalPayFailOrderDaoImpl {
    @Autowired
    private InternationalPayFailOrderMapper internationalPayFailOrderMapper;

    public List<InternationalPayFailOrder> queryBy(String merchantNo, String orderNo, Date startTime, Date endTime, Integer offset, Integer limit) {
        InternationalPayFailOrderExample example = new InternationalPayFailOrderExample();
        InternationalPayFailOrderExample.Criteria criteria = example.createCriteria();
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
        return internationalPayFailOrderMapper.selectByExample(example);
    }

    public InternationalPayFailOrder queryByOrderNo(String orderNo) {
        if (StringUtils.isBlank(orderNo)) {
            return null;
        }
        InternationalPayFailOrderExample example = new InternationalPayFailOrderExample();
        InternationalPayFailOrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<InternationalPayFailOrder> payFailOrders = internationalPayFailOrderMapper.selectByExample(example);
        return CollectionUtils.isEmpty(payFailOrders) ? null : payFailOrders.get(0);
    }

    public boolean updateById(InternationalPayFailOrder internationalPayFailOrder) {
        if (internationalPayFailOrder == null || StringUtils.isBlank(internationalPayFailOrder.getOrderNo())) {
            return false;
        }
        return internationalPayFailOrderMapper.updateByPrimaryKey(internationalPayFailOrder) > 0;
    }

    public boolean insert(InternationalPayFailOrder internationalPayFailOrder) {
        return internationalPayFailOrderMapper.insert(internationalPayFailOrder) > 0;
    }
}
