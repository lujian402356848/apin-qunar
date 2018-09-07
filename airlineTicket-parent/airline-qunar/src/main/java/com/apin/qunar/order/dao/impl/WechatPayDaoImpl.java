package com.apin.qunar.order.dao.impl;

import com.apin.qunar.order.dao.mapper.WechatPayExtMapper;
import com.apin.qunar.order.dao.mapper.WechatPayMapper;
import com.apin.qunar.order.dao.model.WechatPay;
import com.apin.qunar.order.dao.model.WechatPayExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public class WechatPayDaoImpl {
    @Autowired
    private WechatPayMapper wechatPayMapper;
    @Autowired
    private WechatPayExtMapper wechatPayExtMapper;

    public boolean insert(WechatPay wechatPay) {
        return wechatPayMapper.insert(wechatPay) > 0;
    }


    public List<WechatPay> queryBy(Integer wechatPayStatus, Date startTime, Date endTime) {
        WechatPayExample example = new WechatPayExample();
        WechatPayExample.Criteria criteria = example.createCriteria();
        criteria.andWechatPayStatusEqualTo(wechatPayStatus);
        criteria.andInsertTimeBetween(startTime, endTime);
        return wechatPayMapper.selectByExample(example);
    }

    public boolean updateWeCharPayStatus(String id, Integer payStatus) {
        return wechatPayExtMapper.updateWeChatPayStatus(id, payStatus) > 0;
    }

    public boolean updateWecharPayInfo(String id, String tradeNo, Integer payStatus, String payTime) {
        return wechatPayExtMapper.updateWeChatPayInfo(id, tradeNo, payStatus, payTime) > 0;
    }

    public boolean updateQunarPayInfo(String id, Integer payStatus, String payTime) {
        return wechatPayExtMapper.updateQunarPayInfo(id, payStatus, payTime) > 0;
    }

    public WechatPay queryByOrderNo(String orderNo) {
        if (StringUtils.isBlank(orderNo)) {
            return null;
        }
        WechatPayExample example = new WechatPayExample();
        WechatPayExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<WechatPay> wechatPays = wechatPayMapper.selectByExample(example);
        return CollectionUtils.isEmpty(wechatPays) ? null : wechatPays.get(0);
    }

    public boolean deleteByOrderNo(String orderNo) {
        return wechatPayExtMapper.deleteByOrderNo(orderNo) > 0;
    }
}
