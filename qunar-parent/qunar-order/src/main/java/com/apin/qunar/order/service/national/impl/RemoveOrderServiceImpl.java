package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.basic.domain.ExecuteResult;
import com.apin.qunar.order.common.enums.OrderShowEnum;
import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.service.national.RemoveOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RemoveOrderServiceImpl implements RemoveOrderService {
    @Autowired
    private NationalOrderDaoImpl nationalOrderDao;

    @Override
    public ExecuteResult remove(String orderNo, String account) {
        ExecuteResult executeResult = new ExecuteResult();
        if (StringUtils.isBlank(orderNo)) {
            executeResult.setDesc("订单号不能位空");
            return executeResult;
        }
        NationalOrder order = nationalOrderDao.queryByOrderNo(orderNo);
        if (order == null) {
            executeResult.setDesc("该订单号不存在");
            return executeResult;
        }
        if (order.getHasShow() != null && order.getHasShow() == OrderShowEnum.NOSHOW.getStatus()) {
            executeResult.setDesc("该订单号已被删除，不能重复删除");
            return executeResult;
        }
        if (StringUtils.isNotBlank(order.getOperator()) && !order.getOperator().equals(account)) {
            executeResult.setDesc("该订单不是你创建，不能删除");
            return executeResult;
        }
        boolean result = nationalOrderDao.updateShowStatus(orderNo, OrderShowEnum.NOSHOW.getStatus());
        executeResult.setSuccess(result);
        return executeResult;
    }
}
