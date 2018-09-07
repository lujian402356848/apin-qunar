package com.apin.qunar.order.domain.national.booking;

import java.io.Serializable;

/**
 * Created by stanley on 15-12-1 At 17:35
 */
public class Ins implements Serializable {
    private static final long serialVersionUID = -8676844174727860112L;
    /**
     * 成人最大可卖份数
     */
    private int adultMax;
    /**
     * 儿童最大可卖份数
     */
    private int childMax;
    /**
     * 婴儿最大可卖份数
     */
    private int babyMax;
    /**
     * 成人最小可卖份数
     */
    private int adultMin;
    /**
     * 儿童最小可卖份数
     */
    private int childMin;
    /**
     * 婴儿最小可卖份数
     */
    private int babyMin;
    /**
     * 保险信息
     */
    private String note = "";
    /**
     * 投保公司名
     */
    private String name = "";
    /**
     * 保险价格
     */
    private String price = "";
    /**
     * url
     */
    private String url = "";
    /**
     * 电话
     */
    private String phone = "";

    public int getChildMax() {
        return childMax;
    }

    public void setChildMax(int childMax) {
        this.childMax = childMax;
    }

    public int getAdultMax() {
        return adultMax;
    }

    public void setAdultMax(int adultMax) {
        this.adultMax = adultMax;
    }

    public int getBabyMax() {
        return babyMax;
    }

    public void setBabyMax(int babyMax) {
        this.babyMax = babyMax;
    }

    public int getAdultMin() {
        return adultMin;
    }

    public void setAdultMin(int adultMin) {
        this.adultMin = adultMin;
    }

    public int getChildMin() {
        return childMin;
    }

    public void setChildMin(int childMin) {
        this.childMin = childMin;
    }

    public int getBabyMin() {
        return babyMin;
    }

    public void setBabyMin(int babyMin) {
        this.babyMin = babyMin;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Ins{" +
                "adultMax=" + adultMax +
                ", childMax=" + childMax +
                ", babyMax=" + babyMax +
                ", adultMin=" + adultMin +
                ", childMin=" + childMin +
                ", babyMin=" + babyMin +
                ", note='" + note + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", url='" + url + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
