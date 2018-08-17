package com.apin.qunar.order.service.international.impl;

import com.apin.qunar.basic.dao.impl.UserDaoImpl;
import com.apin.qunar.basic.dao.model.Merchant;
import com.apin.qunar.basic.dao.model.User;
import com.apin.qunar.basic.service.MerchantService;
import com.apin.qunar.common.ids.IDGenerator;
import com.apin.qunar.common.utils.BeanUtil;
import com.apin.qunar.order.common.enums.OrderProcessStatus;
import com.apin.qunar.order.common.enums.PayChannelEnum;
import com.apin.qunar.order.dao.impl.InternationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.InternationalPayFailOrderDaoImpl;
import com.apin.qunar.order.dao.model.InternationalOrder;
import com.apin.qunar.order.dao.model.InternationalPayFailOrder;
import com.apin.qunar.order.domain.international.payFailOrder.NtsPayFailOrderVO;
import com.apin.qunar.order.service.international.NtsPayFailOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class NtsPayFailOrderServiceImpl implements NtsPayFailOrderService {
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private UserDaoImpl userDao;
    @Autowired
    private InternationalOrderDaoImpl internationalOrderDao;
    @Autowired
    private InternationalPayFailOrderDaoImpl internationalPayFailOrderDao;

    @Override
    public List<NtsPayFailOrderVO> queryPageList(String merchantNo, String orderNo, Date startTime, Date endTime, Integer offset, Integer limit) {
        List<InternationalPayFailOrder> payFailOrderVOS = internationalPayFailOrderDao.queryBy(merchantNo, orderNo, startTime, endTime, offset, limit);
        return BeanUtil.copyProperties(payFailOrderVOS, NtsPayFailOrderVO.class);
    }

    @Override
    public void createOrder(String orderNo, PayChannelEnum payChannelEnum) {
        InternationalPayFailOrder payFailOrder = buildPayFailOrder(orderNo, payChannelEnum);
        if (payFailOrder == null) {
            return;
        }
        try {
            internationalPayFailOrderDao.insert(payFailOrder);
        } catch (Exception e) {
            log.error("创建国内支付失败订单异常,orderNo:{}", orderNo, e);
        }
    }

    @Override
    public boolean updateOrder(String orderNo, Integer status, Integer payAmount, String desc, String operator) {
        boolean result = false;
        InternationalPayFailOrder payFailOrder = buildPayFailOrder(orderNo, status, payAmount, desc, operator);
        if (payFailOrder == null) {
            return result;
        }
        try {
            result = internationalPayFailOrderDao.updateById(payFailOrder);
        } catch (Exception e) {
            log.error("更新国际支付异常订单信息异常,orderNo:{}", orderNo, e);
        }
        return result;
    }

    private InternationalPayFailOrder buildPayFailOrder(String orderNo, Integer status, Integer payAmount, String desc, String operator) {
        InternationalPayFailOrder payFailOrder = null;
        if (StringUtils.isBlank(orderNo) || StringUtils.isBlank(operator)) {
            return payFailOrder;
        }
        payFailOrder = internationalPayFailOrderDao.queryByOrderNo(orderNo);
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

    private InternationalPayFailOrder buildPayFailOrder(String orderNo, PayChannelEnum payChannelEnum) {
        InternationalOrder order = internationalOrderDao.queryByOrderNo(orderNo);
        if (order == null) {
            log.error("没有找到该国际订单【{}】", orderNo);
            return null;
        }
        Merchant merchant = merchantService.queryByAccount(order.getMerchantNo());
        if (merchant == null) {
            log.error("找不到该商户号:{}", order.getMerchantNo());
            return null;
        }
        InternationalPayFailOrder payFailOrder = new InternationalPayFailOrder();
        payFailOrder.setId(IDGenerator.getUniqueId());
        payFailOrder.setMerchantNo(order.getMerchantNo());
        payFailOrder.setOrderNo(orderNo);
        payFailOrder.setOrderCreateTime(order.getInsertTime());

        payFailOrder.setGoFlightNum(order.getGoFlightNum());
        payFailOrder.setGoDeptCity(order.getGoDeptCity());
        payFailOrder.setGoArriCity(order.getGoArriCity());
        payFailOrder.setGoDeptDate(order.getGoDeptDate());
        payFailOrder.setGoDeptTime(order.getGoDeptTime());

        payFailOrder.setBackFlightNum(order.getBackFlightNum());
        payFailOrder.setBackDeptCity(order.getBackDeptCity());
        payFailOrder.setBackArriCity(order.getBackArriCity());
        payFailOrder.setBackDeptDate(order.getBackDeptDate());
        payFailOrder.setBackDeptTime(order.getBackDeptTime());

        payFailOrder.setPayChannel(payChannelEnum.getStatus());
        payFailOrder.setPayAmount(order.getPayAmount());
        payFailOrder.setPayTime(order.getPayTime());
        payFailOrder.setContactName(merchant.getContactName());
        payFailOrder.setContactMobile(merchant.getContactMobile());
        payFailOrder.setProcessStatus(OrderProcessStatus.WAIT_PROCESS.getStatus());
        return payFailOrder;
    }
}