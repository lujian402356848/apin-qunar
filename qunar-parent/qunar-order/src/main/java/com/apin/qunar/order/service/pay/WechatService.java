package com.apin.qunar.order.service.pay;

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
}
