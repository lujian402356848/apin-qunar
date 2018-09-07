package com.apin.qunar.order.domain.national.booking;

import java.io.Serializable;

/**
 * Created by stanley on 16-3-10 At 18:54
 */
public class PackageInfo implements Serializable{
    private static final long serialVersionUID = 2752367175364948498L;
    /**
     * 票面价
     */
    private double viewPrice;
    /**
     * 政策价
     */
    private double policyPrice;
    /**
     * 裸票价
     */
    private double barePrice;
    /**
     * 原裸票价
     */
    private double originalBarePrice;
    /**
     * 包装价
     */
    private double packagePrice;

    /**
     * 原包装价
     */
    private double originalPackagePrice;

    private double addPrice;

    /**
     * 产品tag
     */
    private String tag;

    public double getViewPrice() {
        return viewPrice;
    }

    public void setViewPrice(int viewPrice) {
        this.viewPrice = viewPrice;
    }

    public double getPolicyPrice() {
        return policyPrice;
    }

    public void setPolicyPrice(double policyPrice) {
        this.policyPrice = policyPrice;
    }

    public double getBarePrice() {
        return barePrice;
    }

    public void setBarePrice(double barePrice) {
        this.barePrice = barePrice;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(double packagePrice) {
        this.packagePrice = packagePrice;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public double getOriginalBarePrice() {
        return originalBarePrice;
    }

    public void setOriginalBarePrice(double originalBarePrice) {
        this.originalBarePrice = originalBarePrice;
    }

    public double getOriginalPackagePrice() {
        return originalPackagePrice;
    }

    public void setOriginalPackagePrice(double originalPackagePrice) {
        this.originalPackagePrice = originalPackagePrice;
    }

    public double getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(double addPrice) {
        this.addPrice = addPrice;
    }

    @Override
    public String toString() {
        return "PackageInfo{" +
                "viewPrice=" + viewPrice +
                ", policyPrice=" + policyPrice +
                ", barePrice=" + barePrice +
                ", packagePrice=" + packagePrice +
                ", tag='" + tag + '\'' +
                '}';
    }
}
