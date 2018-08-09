package com.apin.qunar.order.dao.impl;

import com.apin.qunar.order.dao.mapper.InternationalOrderExtMapper;
import com.apin.qunar.order.dao.mapper.InternationalOrderMapper;
import com.apin.qunar.order.dao.model.InternationalOrder;
import com.apin.qunar.order.dao.model.InternationalOrderExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-09 10:15
 */
@Repository
public class InternationalOrderDaoImpl {
    @Autowired
    private InternationalOrderMapper internationalOrderMapper;
    @Autowired
    private InternationalOrderExtMapper internationalOrderExtMapper;

    public InternationalOrder queryByOrderNo(String orderNo) {
        InternationalOrderExample example = new InternationalOrderExample();
        InternationalOrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<InternationalOrder> internationalOrders = internationalOrderMapper.selectByExample(example);
        return CollectionUtils.isEmpty(internationalOrders) ? null : internationalOrders.get(0);
    }

    public List<InternationalOrder> queryOrderBy(Integer status, Date satrtInsertTime, Date endInsertTime) {
        InternationalOrderExample example = new InternationalOrderExample();
        InternationalOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayStatusEqualTo(status);
        criteria.andInsertTimeBetween(satrtInsertTime, endInsertTime);
        example.setOrderByClause("insert_time asc");
        return internationalOrderMapper.selectByExample(example);
    }

    public List<InternationalOrder> queryOrderBy(List<Integer> status, Date lastTime, Integer limit) {
        InternationalOrderExample example = new InternationalOrderExample();
        InternationalOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayStatusIn(status);
        criteria.andUpdateTimeGreaterThanOrEqualTo(lastTime);
        example.setMysqlOffset(0);
        example.setMysqlLength(limit);
        example.setOrderByClause("insert_time asc");
        return internationalOrderMapper.selectByExample(example);
    }

    public List<InternationalOrder> queryPageListBy(String merchantNo, String account, String orderNo, Integer offset, Integer limit) {
        InternationalOrderExample example = new InternationalOrderExample();
        InternationalOrderExample.Criteria criteria = example.createCriteria();
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
        return internationalOrderMapper.selectByExample(example);
    }

    public List<InternationalOrder> queryPageListBy(String merchantNo, List<String> orderNos, Integer offset, Integer limit) {
        InternationalOrderExample example = new InternationalOrderExample();
        InternationalOrderExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        if (CollectionUtils.isNotEmpty(orderNos)) {
            criteria.andOrderNoIn(orderNos);
        }
        example.setMysqlOffset(offset);
        example.setMysqlLength(limit);
        example.setOrderByClause("insert_time desc");
        return internationalOrderMapper.selectByExample(example);
    }

    public boolean updateStatus(String orderNo, int payStatus) {
        return internationalOrderExtMapper.updateStatus(orderNo, payStatus) > 0;
    }

    public boolean updateStatusAndTicketNo(String orderNo, String ticketNo, int payStatus) {
        return internationalOrderExtMapper.updateStatusAndTicketNo(orderNo, ticketNo, payStatus) > 0;
    }

    public boolean updatePayInfo(String orderNo, String payId, int payStatus, String payTime) {
        return internationalOrderExtMapper.updatePayInfo(orderNo, payId, payStatus, payTime) > 0;
    }

    public boolean insert(InternationalOrder internationalOrder) {
        return internationalOrderMapper.insert(internationalOrder) > 0;
    }
}