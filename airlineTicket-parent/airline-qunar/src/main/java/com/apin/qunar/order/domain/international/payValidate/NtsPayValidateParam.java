package com.apin.qunar.order.domain.international.payValidate;

/**
 * @outhor lujian
 * @create 2018-06-25 15:53
 */
public class NtsPayValidateParam {
    private String orderNo;
    private String source;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
