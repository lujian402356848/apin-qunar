package com.apin.qunar.order.domain.national.createOrder;

/**
 * Created by wjjunjjun.wang on 2017/8/4.
 */
public class CreateOrderResult {
    private long id;
    private int noPayAmount;
    private String orderNo;
    private int status;
    private String clientSite;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNoPayAmount() {
        return noPayAmount;
    }

    public void setNoPayAmount(int noPayAmount) {
        this.noPayAmount = noPayAmount;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getOrderId(){
        return id;
    }

    public String getClientSite() {
        return clientSite;
    }

    public void setClientSite(String clientSite) {
        this.clientSite = clientSite;
    }
}
