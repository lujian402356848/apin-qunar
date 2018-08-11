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

    public List<NationalChangeOrder> queryPageListBy(String merchantNo, String account, String orderNo, Integer offset, Integer limit) {
        NationalChangeOrderExample example = new NationalChangeOrderExample();
        NationalChangeOrderExample.Criteria criteria = example.createCriteria();
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
        return nationalChangeOrderMapper.selectByExample(example);
    }

    public List<NationalChangeOrder> queryPageListBy(String merchantNo, List<String> orderNos, Integer offset, Integer limit) {
        NationalChangeOrderExample example = new NationalChangeOrderExample();
        NationalChangeOrderExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
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


}