package com.apin.qunar.order.dao.impl;

import com.apin.qunar.order.dao.mapper.NationalOrderExtMapper;
import com.apin.qunar.order.dao.mapper.NationalOrderMapper;
import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.dao.model.NationalOrderExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-26 18:56
 */
@Repository
public class NationalOrderDaoImpl {
    @Autowired
    private NationalOrderMapper nationalOrderMapper;
    @Autowired
    private NationalOrderExtMapper nationalOrderExtMapper;

    public NationalOrder queryByOrderNo(String orderNo) {
        NationalOrderExample example = new NationalOrderExample();
        NationalOrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<NationalOrder> nationalOrders = nationalOrderMapper.selectByExample(example);
        return CollectionUtils.isEmpty(nationalOrders) ? null : nationalOrders.get(0);
    }

    public int queryCntBy(String merchantNo, List<Integer> payStatusList, Date startTime, Date endTime) {
        String payStatusStr = StringUtils.join(payStatusList, ",");
        if (StringUtils.isBlank(merchantNo)) {
            return nationalOrderExtMapper.queryCntBy(payStatusStr, startTime, endTime);
        } else {
            return nationalOrderExtMapper.queryCntBy(merchantNo, payStatusStr, startTime, endTime);
        }
    }

    public int queryTotalAmountBy(String merchantNo, List<Integer> payStatusList, Date startTime, Date endTime) {
        String payStatusStr = StringUtils.join(payStatusList, ",");
        if (StringUtils.isBlank(merchantNo)) {
            return nationalOrderExtMapper.queryTotalAmountBy(payStatusStr, startTime, endTime);
        } else {
            return nationalOrderExtMapper.queryTotalAmountBy(merchantNo, payStatusStr, startTime, endTime);
        }
    }

    public List<NationalOrder> queryPageListBy(String merchantNo, String account, String orderNo, Integer offset, Integer limit) {
        NationalOrderExample example = new NationalOrderExample();
        NationalOrderExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        if (StringUtils.isNotBlank(account)) {
            criteria.andOperatorEqualTo(account);
        }
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        example.setMysqlOffset(offset);
        example.setMysqlLength(limit);
        example.setOrderByClause("insert_time desc");
        return nationalOrderMapper.selectByExample(example);
    }

    public List<NationalOrder> queryPageListBy(String merchantNo, List<String> orderNos, Integer offset, Integer limit) {
        NationalOrderExample example = new NationalOrderExample();
        NationalOrderExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        if (CollectionUtils.isNotEmpty(orderNos)) {
            criteria.andOrderNoIn(orderNos);
        }
        example.setMysqlOffset(offset);
        example.setMysqlLength(limit);

        example.setOrderByClause("insert_time desc");
        return nationalOrderMapper.selectByExample(example);
    }

    public NationalOrder queryRelationOrderBy(Long id, String orderNo, String orderRelationNo) {
        NationalOrderExample example = new NationalOrderExample();
        NationalOrderExample.Criteria criteria = example.createCriteria();
        criteria.andIdNotEqualTo(id);
        criteria.andOrderNoEqualTo(orderNo);
        criteria.andOrderRelationNoEqualTo(orderRelationNo);
        List<NationalOrder> nationalOrders = nationalOrderMapper.selectByExample(example);
        return CollectionUtils.isEmpty(nationalOrders) ? null : nationalOrders.get(0);
    }

    public boolean updateStatus(String orderNo, int payStatus) {
        return nationalOrderExtMapper.updateStatus(orderNo, payStatus) > 0;
    }

    public boolean updateStatusAndTicketNo(String orderNo, String ticketNo, int payStatus) {
        return nationalOrderExtMapper.updateStatusAndTicketNo(orderNo, ticketNo, payStatus) > 0;
    }

    public boolean updatePayInfo(String orderNo, String payId, int payStatus, String payTime) {
        return nationalOrderExtMapper.updatePayInfo(orderNo, payId, payStatus, payTime) > 0;
    }

    public boolean insert(NationalOrder nationalOrder) {
        return nationalOrderMapper.insert(nationalOrder) > 0;
    }
}