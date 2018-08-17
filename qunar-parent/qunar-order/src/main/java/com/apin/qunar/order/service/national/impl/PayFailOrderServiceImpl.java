package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.basic.dao.impl.UserDaoImpl;
import com.apin.qunar.basic.dao.model.Merchant;
import com.apin.qunar.basic.dao.model.User;
import com.apin.qunar.basic.service.MerchantService;
import com.apin.qunar.common.ids.IDGenerator;
import com.apin.qunar.common.utils.BeanUtil;
import com.apin.qunar.order.common.enums.OrderProcessStatus;
import com.apin.qunar.order.common.enums.PayChannelEnum;
import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalPayFailOrderDaoImpl;
import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.dao.model.NationalPayFailOrder;
import com.apin.qunar.order.domain.national.payFailOrder.PayFailOrderVO;
import com.apin.qunar.order.service.national.PayFailOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class PayFailOrderServiceImpl implements PayFailOrderService {
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private UserDaoImpl userDao;
    @Autowired
    private NationalOrderDaoImpl nationalOrderDao;
    @Autowired
    private NationalPayFailOrderDaoImpl nationalPayFailOrderDao;

    @Override
    public List<PayFailOrderVO> queryPageList(String merchantNo, String orderNo, Date startTime, Date endTime, Integer offset, Integer limit) {
        List<NationalPayFailOrder> nationalPayFailOrders = nationalPayFailOrderDao.queryBy(merchantNo, orderNo, startTime, endTime, offset, limit);
        return BeanUtil.copyProperties(nationalPayFailOrders, PayFailOrderVO.class);
    }

    @Override
    public void createOrder(String orderNo, PayChannelEnum payChannelEnum) {
        NationalPayFailOrder payFailOrder = buildPayFailOrder(orderNo, payChannelEnum);
        if (payFailOrder == null) {
            return;
        }
        try {
            nationalPayFailOrderDao.insert(payFailOrder);
        } catch (Exception e) {
            log.error("创建国内支付失败订单异常,orderNo:{}", orderNo, e);
        }
    }

    @Override
    public boolean updateOrder(String orderNo, Integer status, Integer payAmount, String desc, String operator) {
        boolean result = false;
        NationalPayFailOrder payFailOrder = buildPayFailOrder(orderNo, status, payAmount, desc, operator);
        if (payFailOrder == null) {
            return result;
        }
        try {
            result = nationalPayFailOrderDao.updateById(payFailOrder);
        } catch (Exception e) {
            log.error("更新国内支付异常订单信息异常,orderNo:{}", orderNo, e);
        }
        return result;
    }

    private NationalPayFailOrder buildPayFailOrder(String orderNo, Integer status, Integer payAmount, String desc, String operator) {
        NationalPayFailOrder payFailOrder = null;
        if (StringUtils.isBlank(orderNo) || StringUtils.isBlank(operator)) {
            return payFailOrder;
        }
        payFailOrder = nationalPayFailOrderDao.queryByOrderNo(orderNo);
        if (payFailOrder == null) {
            return payFailOrder;
        }
        User user = userDao.queryByAccount(operator);
        if (user == null) {
            return payFailOrder;
        }
        if (status > 0) {
            payFailOrder.setProcessStatus(status);
        }
        if (payAmount > 0) {
            payFailOrder.setProcessPayAmount(payAmount);
        }
        if (StringUtils.isNotBlank(desc)) {
            payFailOrder.setProcessDesc(desc);
        }
        payFailOrder.setProcessDepartment(user.getDepartment());
        payFailOrder.setProcessPerson(operator);
        payFailOrder.setUpdateTime(new Date());

        return payFailOrder;
    }

    private NationalPayFailOrder buildPayFailOrder(String orderNo, PayChannelEnum payChannelEnum) {
        NationalOrder order = nationalOrderDao.queryByOrderNo(orderNo);
        if (order == null) {
            log.error("没有找到该国内订单【{}】", orderNo);
            return null;
        }
        Merchant merchant = merchantService.queryByAccount(order.getMerchantNo());
        if (merchant == null) {
            log.error("找不到该商户号:{}", order.getMerchantNo());
            return null;
        }
        NationalPayFailOrder payFailOrder = new NationalPayFailOrder();
        payFailOrder.setId(IDGenerator.getUniqueId());
        payFailOrder.setMerchantNo(order.getMerchantNo());
        payFailOrder.setOrderNo(orderNo);
        payFailOrder.setOrderCreateTime(order.getInsertTime());
        payFailOrder.setFlightNum(order.getFlightNum());
        payFailOrder.setDeptCity(order.getDeptCity());
        payFailOrder.setArriCity(order.getArriCity());
        payFailOrder.setDeptDate(order.getDeptDate());
        payFailOrder.setDeptTime(order.getDeptTime());
        payFailOrder.setPayChannel(payChannelEnum.getStatus());
        payFailOrder.setPayAmount(order.getPayAmount());
        payFailOrder.setPayTime(order.getPayTime());
        payFailOrder.setContactName(merchant.getContactName());
        payFailOrder.setContactMobile(merchant.getContactMobile());
        payFailOrder.setProcessStatus(OrderProcessStatus.WAIT_PROCESS.getStatus());
        return payFailOrder;
    }
}
