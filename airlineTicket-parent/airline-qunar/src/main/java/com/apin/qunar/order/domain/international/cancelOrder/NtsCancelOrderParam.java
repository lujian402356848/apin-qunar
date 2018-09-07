package com.apin.qunar.order.domain.international.cancelOrder;

/**
 * @outhor lujian
 * @create 2018-06-25 14:48
 */
public class NtsCancelOrderParam {
    private String source;
    private String orderNo;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
