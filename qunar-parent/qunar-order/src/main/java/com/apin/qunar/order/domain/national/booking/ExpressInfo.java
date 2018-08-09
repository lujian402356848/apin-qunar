package com.apin.qunar.order.domain.national.booking;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by stanley on 15-12-16 At 11:48
 */
public class ExpressInfo implements Serializable {
    private static final long serialVersionUID = -8146501337973023981L;
    private int id;
    private int price;
    private Map<String, String> invoiceType;
    private Map<String, String> receiverType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Map<String, String> getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Map<String, String> invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Map<String, String> getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(Map<String, String> receiverType) {
        this.receiverType = receiverType;
    }

    @Override
    public String toString() {
        return "ExpressInfo{" +
                "id=" + id +
                ", price=" + price +
                ", invoiceType=" + invoiceType +
                ", receiverType=" + receiverType +
                '}';
    }
}
