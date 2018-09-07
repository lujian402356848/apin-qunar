package com.apin.qunar.order.dao.impl;

import com.apin.qunar.order.dao.mapper.NationalRefundOrderExtMapper;
import com.apin.qunar.order.dao.mapper.NationalReturnOrderMapper;
import com.apin.qunar.order.dao.model.NationalReturnOrder;
import com.apin.qunar.order.dao.model.NationalReturnOrderExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @outhor ligang
 * @create 2018-07-27 18:56
 */
@Repository
public class NationalReturnOrderDaoImpl {
    @Autowired
    private NationalReturnOrderMapper nationalReturnOrderMapper;
    @Autowired
    private NationalRefundOrderExtMapper nationalRefundOrderExtMapper;


    public NationalReturnOrder queryByOrderNo(String orderNo) {
        NationalReturnOrderExample example = new NationalReturnOrderExample();
        NationalReturnOrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<NationalReturnOrder> nationalReturnOrders = nationalReturnOrderMapper.selectByExample(example);
        return CollectionUtils.isEmpty(nationalReturnOrders) ? null : nationalReturnOrders.get(0);
    }

    public List<NationalReturnOrder> queryPageListBy(String merchantNo, String account, String orderNo, Integer offset, Integer limit) {
        NationalReturnOrderExample example = new NationalReturnOrderExample();
        NationalReturnOrderExample.Criteria criteria = example.createCriteria();
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
        return nationalReturnOrderMapper.selectByExample(example);
    }

    public List<NationalReturnOrder> queryPageListBy(String merchantNo, List<String> orderNos, Integer offset, Integer limit) {
        NationalReturnOrderExample example = new NationalReturnOrderExample();
        NationalReturnOrderExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        if (CollectionUtils.isNotEmpty(orderNos)) {
            criteria.andOrderNoIn(orderNos);
        }
        example.setMysqlOffset(offset);
        example.setMysqlLength(limit);

        example.setOrderByClause("insert_time desc");
        return nationalReturnOrderMapper.selectByExample(example);
    }

    public boolean updateStatus(String orderNo, int payStatus) {
        return nationalRefundOrderExtMapper.updateStatus(orderNo, payStatus) > 0;
    }

    public boolean isExist(String orderNo, int returnStatus) {
        return nationalRefundOrderExtMapper.isExist(orderNo, returnStatus) > 0;
    }

    public boolean updateStatusAndTicketNo(String parentOrderNo, String orderNo, int payStatus, String ticketNo) {
        return nationalRefundOrderExtMapper.updateStatusAndTicketNo(parentOrderNo, orderNo, payStatus, ticketNo) > 0;
    }

    public boolean updatePayInfo(String orderNo, String payId, int payStatus, String payTime) {
        return nationalRefundOrderExtMapper.updatePayInfo(orderNo, payId, payStatus, payTime) > 0;
    }

    public boolean insert(NationalReturnOrder nationalReturnOrder) {
        return nationalReturnOrderMapper.insert(nationalReturnOrder) > 0;
    }

    public boolean updateReturnPayTypeAndstatus(String orderNo, Integer returnType, Integer returnStauts) {
        return nationalRefundOrderExtMapper.updateReturnPayTypeAndstatus(orderNo, returnType, returnStauts) > 0;
    }

    public Integer queryCount(final String account, final String orderNo) {
        NationalReturnOrderExample example = new NationalReturnOrderExample();
        NationalReturnOrderExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(account)) {
            criteria.andOperatorEqualTo(account);
        }
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        return nationalReturnOrderMapper.countByExample(example);
    }

    public Integer queryListCount(List<String> orderNos, String account) {
        NationalReturnOrderExample example = new NationalReturnOrderExample();
        NationalReturnOrderExample.Criteria criteria = example.createCriteria();
        if (CollectionUtils.isNotEmpty(orderNos)) {
            criteria.andOrderNoIn(orderNos);
        }
        if (StringUtils.isNotBlank(account)) {
            criteria.andOperatorEqualTo(account);
        }
        example.setOrderByClause("insert_time desc");
        return nationalReturnOrderMapper.countByExample(example);
    }
}