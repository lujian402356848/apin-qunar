package com.apin.qunar.order.service.pay;


import com.apin.qunar.order.common.enums.AlipayStatusEnum;
import com.apin.qunar.order.dao.model.AliPay;
import com.apin.qunar.order.domain.pay.alipay.AlipayBO;

import javax.servlet.http.HttpServletRequest;

public interface AlipayService {

    /**
     * 生成二维码
     *
     * @outhor wubo
     * @create 2018-07-30 10:57
     */
    String generateQrCode(AlipayBO alipayBO);

    /**
     * 支付宝网站支付回调
     *
     * @outhor wubo
     * @create 2018-07-30 13:57
     */
    boolean payCallback(HttpServletRequest request);

    /**
     * 查询支付宝订单支付状态
     *
     * @outhor wubo
     * @create 2018-07-30 10:57
     */
    AlipayStatusEnum queryOrderPayStatus(String orderNo);

    /**
     * 去哪儿订单支付
     *
     * @param aliPay
     */
    boolean qunarOrderPay(AliPay aliPay);
}