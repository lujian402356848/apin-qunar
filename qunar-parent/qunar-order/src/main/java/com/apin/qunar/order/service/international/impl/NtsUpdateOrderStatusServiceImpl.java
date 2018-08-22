package com.apin.qunar.order.service.international.impl;

import com.apin.qunar.basic.domain.ExecuteResult;
import com.apin.qunar.order.common.enums.OrderShowEnum;
import com.apin.qunar.order.dao.impl.InternationalOrderDaoImpl;
import com.apin.qunar.order.dao.model.InternationalOrder;
import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.service.international.NtsUpdateOrderStatusService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NtsUpdateOrderStatusServiceImpl implements NtsUpdateOrderStatusService {
    @Autowired
    private InternationalOrderDaoImpl internationalOrderDao;

    @Override
    public ExecuteResult remove(String orderNo, String account) {
        ExecuteResult executeResult = new ExecuteResult();
        if (StringUtils.isBlank(orderNo)) {
            executeResult.setDesc("订单号不能位空");
            return executeResult;
        }
        InternationalOrder order = internationalOrderDao.queryByOrderNo(orderNo);
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
        boolean result = internationalOrderDao.updateShowStatus(orderNo, OrderShowEnum.NOSHOW.getStatus());
        executeResult.setSuccess(result);
        return executeResult;
    }

    @Override
    public ExecuteResult cancelRemove(String orderNo, String account) {
        ExecuteResult executeResult = new ExecuteResult();
        if (StringUtils.isBlank(orderNo)) {
            executeResult.setDesc("订单号不能位空");
            return executeResult;
        }
        InternationalOrder order = internationalOrderDao.queryByOrderNo(orderNo);
        if (order == null) {
            executeResult.setDesc("该订单号不存在");
            return executeResult;
        }
        if (order.getHasShow() != null && order.getHasShow() != OrderShowEnum.NOSHOW.getStatus()) {
            executeResult.setDesc("该订单号已经是恢复状态，不能重复恢复");
            return executeResult;
        }
        if (StringUtils.isNotBlank(order.getOperator()) && !order.getOperator().equals(account)) {
            executeResult.setDesc("该订单不是你创建，不能恢复");
            return executeResult;
        }
        boolean result = internationalOrderDao.updateShowStatus(orderNo, OrderShowEnum.SHOW.getStatus());
        executeResult.setSuccess(result);
        return executeResult;
    }
}
