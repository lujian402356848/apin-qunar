package com.apin.qunar.order.dao.impl;

import com.apin.qunar.order.dao.mapper.NationalChangeOrderExtMapper;
import com.apin.qunar.order.dao.mapper.NationalChangeOrderMapper;
import com.apin.qunar.order.dao.model.NationalChangeOrder;
import com.apin.qunar.order.dao.model.NationalChangeOrderExample;
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
public class NationalChangeOrderDaoImpl {
    @Autowired
    private NationalChangeOrderMapper nationalChangeOrderMapper;
    @Autowired
    private NationalChangeOrderExtMapper nationalChangeOrderExtMapper;

    public NationalChangeOrder queryByOrderNo(String orderNo) {
        NationalChangeOrderExample example = new NationalChangeOrderExample();
        NationalChangeOrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<NationalChangeOrder> nationalChangeOrders = nationalChangeOrderMapper.selectByExample(example);
        return CollectionUtils.isEmpty(nationalChangeOrders) ? null : nationalChangeOrders.get(0);
    }

    public NationalChangeOrder queryByParentOrderNo(String parentOrderNo) {
        NationalChangeOrderExample example = new NationalChangeOrderExample();
        NationalChangeOrderExample.Criteria criteria = example.createCriteria();
        criteria.andParentOrderNoEqualTo(parentOrderNo);
        List<NationalChangeOrder> nationalChangeOrders = nationalChangeOrderMapper.selectByExample(example);
        return CollectionUtils.isEmpty(nationalChangeOrders) ? null : nationalChangeOrders.get(0);
    }

    public List<NationalChangeOrder> queryPageListBy(String merchantNo, String account, Integer status, String orderNo, Integer offset, Integer limit) {
        NationalChangeOrderExample example = new NationalChangeOrderExample();
        NationalChangeOrderExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        if (StringUtils.isNotBlank(account)) {
            criteria.andOperatorEqualTo(account);
        }
        if (status >= 0) {
            criteria.andChangeStatusEqualTo(status);
        }
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        example.setMysqlOffset(offset);
        example.setMysqlLength(limit);
        example.setOrderByClause("insert_time desc");
        return nationalChangeOrderMapper.selectByExample(example);
    }

    public List<NationalChangeOrder> queryPageListBy(String merchantNo, Integer status, List<String> orderNos, Integer offset, Integer limit) {
        NationalChangeOrderExample example = new NationalChangeOrderExample();
        NationalChangeOrderExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        if (status >= 0) {
            criteria.andChangeStatusEqualTo(status);
        }
        if (CollectionUtils.isNotEmpty(orderNos)) {
            criteria.andOrderNoIn(orderNos);
        }
        example.setMysqlOffset(offset);
        example.setMysqlLength(limit);

        example.setOrderByClause("insert_time desc");
        return nationalChangeOrderMapper.selectByExample(example);
    }

    public boolean updateStatus(String orderNo, int payStatus) {
        return nationalChangeOrderExtMapper.updateStatus(orderNo, payStatus) > 0;
    }

    public boolean updateStatusAndTicketNo(String orderNo, int payStatus, String ticketNo) {
        return nationalChangeOrderExtMapper.updateStatusAndTicketNo(orderNo, payStatus, ticketNo) > 0;
    }


    public boolean insert(NationalChangeOrder nationalChangeOrder) {
        return nationalChangeOrderMapper.insert(nationalChangeOrder) > 0;
    }

    public boolean delete(String orderNo) {
        NationalChangeOrderExample example = new NationalChangeOrderExample();
        NationalChangeOrderExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        return nationalChangeOrderMapper.deleteByExample(example) > 0;
    }

    public Integer queryCount(String account, Integer status, String orderNo) {
        NationalChangeOrderExample example = new NationalChangeOrderExample();
        NationalChangeOrderExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(account)) {
            criteria.andOperatorEqualTo(account);
        }
        if (status >= 0) {
            criteria.andChangeStatusEqualTo(status);
        }
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        example.setOrderByClause("insert_time desc");
        return nationalChangeOrderMapper.countByExample(example);
    }

    public Integer queryListCount(Integer status, List<String> orderNos) {
        NationalChangeOrderExample example = new NationalChangeOrderExample();
        NationalChangeOrderExample.Criteria criteria = example.createCriteria();
        if (status >= 0) {
            criteria.andChangeStatusEqualTo(status);
        }
        if (CollectionUtils.isNotEmpty(orderNos)) {
            criteria.andOrderNoIn(orderNos);
        }
        example.setOrderByClause("insert_time desc");
        return nationalChangeOrderMapper.countByExample(example);
    }

}