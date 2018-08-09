package com.apin.qunar.order.domain.national.booking;

import java.io.Serializable;

/**
 * Created by stanley on 15-11-20 At 13:48
 */
public class Inventory implements Serializable{
    private static final long serialVersionUID = 8795277769270373059L;
    /**
     * 成人
     */
    private String adult = "";
    /**
     * 儿童
     */
    private String child = "";
    /**
     * 婴儿
     */
    private String baby = "";
    /**
     * 全部
     */
    private String all = "";

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getBaby() {
        return baby;
    }

    public void setBaby(String baby) {
        this.baby = baby;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "adult='" + adult + '\'' +
                ", child='" + child + '\'' +
                ", baby='" + baby + '\'' +
                ", all='" + all + '\'' +
                '}';
    }
}
