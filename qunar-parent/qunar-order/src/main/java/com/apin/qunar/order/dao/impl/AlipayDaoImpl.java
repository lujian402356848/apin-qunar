package com.apin.qunar.order.dao.impl;

import com.apin.qunar.order.dao.mapper.AliPayMapper;
import com.apin.qunar.order.dao.mapper.AliPayExtMapper;
import com.apin.qunar.order.dao.model.AliPay;
import com.apin.qunar.order.dao.model.AliPayExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class AlipayDaoImpl {
    @Autowired
    private AliPayMapper aliPayMapper;
    @Autowired
    private AliPayExtMapper aliPayExtMapper;

    public boolean insert(AliPay aliPay) {
        return aliPayMapper.insert(aliPay) > 0;
    }

    public List<AliPay> queryBy(Integer aliPayStatus, Date startTime, Date endTime) {
        AliPayExample example = new AliPayExample();
        AliPayExample.Criteria criteria = example.createCriteria();
        criteria.andAliPayStatusEqualTo(aliPayStatus);
        criteria.andInsertTimeBetween(startTime, endTime);
        return aliPayMapper.selectByExample(example);
    }

    public boolean updateAliPayStatus(String id, Integer payStatus) {
        return aliPayExtMapper.updateAliPayStatus(id, payStatus) > 0;
    }

    public boolean updateAliPayInfo(String id, String tradeNo, Integer payStatus, String payTime) {
        return aliPayExtMapper.updateAliPayInfo(id, tradeNo, payStatus, payTime) > 0;
    }

    public boolean updateQunarPayInfo(String id, Integer payStatus, String payTime) {
        return aliPayExtMapper.updateQunarPayInfo(id, payStatus, payTime) > 0;
    }

    public AliPay queryByOrderNo(String orderNo) {
        if (StringUtils.isBlank(orderNo)) {
            return null;
        }
        AliPayExample example = new AliPayExample();
        AliPayExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<AliPay> alipays = aliPayMapper.selectByExample(example);
        return CollectionUtils.isEmpty(alipays) ? null : alipays.get(0);
    }

    public boolean deleteByOrderNo(String orderNo) {
        return aliPayExtMapper.deleteByOrderNo(orderNo) > 0;
    }
}
