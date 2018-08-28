package com.apin.qunar.order.dao.impl;

import com.apin.qunar.order.common.enums.OrderShowEnum;
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

    public int queryCntBy(String account, List<Integer> payStatusList, Date startTime, Date endTime) {
        String payStatusStr = StringUtils.join(payStatusList, ",");
        return nationalOrderExtMapper.queryCntBy(account, payStatusStr, startTime, endTime);
    }

    public int queryTotalAmountBy(String account, List<Integer> payStatusList, Date startTime, Date endTime) {
        String payStatusStr = StringUtils.join(payStatusList, ",");
        return nationalOrderExtMapper.queryTotalAmountBy(account, payStatusStr, startTime, endTime);
    }

    public List<NationalOrder> queryPageListBy(String merchantNo, String account, Integer status, String orderNo, Integer offset, Integer limit) {
        NationalOrderExample example = new NationalOrderExample();
        NationalOrderExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        if (StringUtils.isNotBlank(account)) {
            criteria.andOperatorEqualTo(account);
        }
        if (status >= 0) {
            criteria.andPayStatusEqualTo(status);
        }
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        criteria.andHasShowEqualTo(OrderShowEnum.SHOW.getStatus());
        example.setMysqlOffset(offset);
        example.setMysqlLength(limit);
        example.setOrderByClause("insert_time desc");
        return nationalOrderMapper.selectByExample(example);
    }

    public List<NationalOrder> queryPageListBy(String account, Integer status, Integer offset, Integer limit) {
        NationalOrderExample example = new NationalOrderExample();
        NationalOrderExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(account)) {
            criteria.andOperatorEqualTo(account);
        }
        if (status >= 0) {
            criteria.andPayStatusEqualTo(status);
        }
        criteria.andHasShowEqualTo(OrderShowEnum.NOSHOW.getStatus());
        example.setMysqlOffset(offset);
        example.setMysqlLength(limit);
        example.setOrderByClause("update_time desc");
        return nationalOrderMapper.selectByExample(example);
    }

    public List<NationalOrder> queryPageListBy(String merchantNo, Integer status, List<String> orderNos, Integer offset, Integer limit, String account) {
        NationalOrderExample example = new NationalOrderExample();
        NationalOrderExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        if (status >= 0) {
            criteria.andPayStatusEqualTo(status);
        }
        if (CollectionUtils.isNotEmpty(orderNos)) {
            criteria.andOrderNoIn(orderNos);
        }
        if (StringUtils.isNotBlank(account)) {
            criteria.andOperatorEqualTo(account);
        }
        criteria.andHasShowEqualTo(OrderShowEnum.SHOW.getStatus());
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

    public boolean updateTicketNo(String orderNo, String oldTicketNo, String newTicketNo) {
        return nationalOrderExtMapper.updateTicketNo(orderNo, oldTicketNo, newTicketNo) > 0;
    }

    public boolean updatePayInfo(String orderNo, String payId, int payStatus, String payTime) {
        return nationalOrderExtMapper.updatePayInfo(orderNo, payId, payStatus, payTime) > 0;
    }

    public boolean updateShowStatus(String orderNo, int showStatus) {
        return nationalOrderExtMapper.updateShowStatus(orderNo, showStatus) > 0;
    }

    public boolean insert(NationalOrder nationalOrder) {
        return nationalOrderMapper.insert(nationalOrder) > 0;
    }

    public boolean updatePayType(String orderNo, Integer payType) {
        return nationalOrderExtMapper.updatePayType(orderNo, payType) > 0;
    }

    public Integer queryCount(final String account, final Integer status, final String orderNo) {
        NationalOrderExample example = new NationalOrderExample();
        NationalOrderExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(account)) {
            criteria.andOperatorEqualTo(account);
        }
        if (status >= 0) {
            criteria.andPayStatusEqualTo(status);
        }
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        criteria.andHasShowEqualTo(OrderShowEnum.SHOW.getStatus());
        return nationalOrderMapper.countByExample(example);
    }

    public Integer queryListCount(Integer status, List<String> orderNos) {
        NationalOrderExample example = new NationalOrderExample();
        NationalOrderExample.Criteria criteria = example.createCriteria();
        if (status >= 0) {
            criteria.andPayStatusEqualTo(status);
        }
        if (CollectionUtils.isNotEmpty(orderNos)) {
            criteria.andOrderNoIn(orderNos);
        }
        criteria.andHasShowEqualTo(OrderShowEnum.SHOW.getStatus());
        example.setOrderByClause("insert_time desc");
        return nationalOrderMapper.countByExample(example);
    }

    public Integer queryRemoveCount(final String account, final Integer status) {
        NationalOrderExample example = new NationalOrderExample();
        NationalOrderExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(account)) {
            criteria.andOperatorEqualTo(account);
        }
        if (status >= 0) {
            criteria.andPayStatusEqualTo(status);
        }
        criteria.andHasShowEqualTo(OrderShowEnum.NOSHOW.getStatus());
        return nationalOrderMapper.countByExample(example);
    }

    public void updateOldOrder(String orderNo) {
        nationalOrderExtMapper.updateOldOrder(orderNo);
    }

    public void updataNewOrder(String orderNo, Integer newPayAmount, String operator) {
        nationalOrderExtMapper.updataNewOrder(orderNo, newPayAmount, operator);
    }
}