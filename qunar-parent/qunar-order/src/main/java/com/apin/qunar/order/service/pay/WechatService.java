package com.apin.qunar.order.service.pay;

import com.apin.qunar.basic.domain.ExecuteResult;
import com.apin.qunar.order.common.enums.WechatPayStatusEnum;
import com.apin.qunar.order.domain.pay.wechat.WechatBO;

import javax.servlet.http.HttpServletRequest;

public interface WechatService {
    /**
     * 生成二维码
     *
     * @param wechatBO
     * @return
     */
    String generateQrCode(WechatBO wechatBO);

    /**
     * 微信网站支付回调
     *
     * @param request
     * @return
     */
    boolean payCallback(HttpServletRequest request);

    /**
     * 查询微信订单支付状态
     *
     * @outhor wubo
     * @create 2018-07-30 10:57
     */
    WechatPayStatusEnum queryOrderPayStatus(String orderNo);
    /*
    * 微信退款
    * @param orderNo:父订单订单号，outRefundNo:订单号，totalFee:交易总价，refundFee:退款金额
    * */
    void payRefund(String orderNo, String outRefundNo, Integer totalFee, Integer refundFee);
}
