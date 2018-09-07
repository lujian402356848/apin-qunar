package com.apin.qunar.order.domain.national.booking;

import java.io.Serializable;

/**
 * Created by stanley on 15-11-27 At 18:22
 */
public class TgqPointCharge implements Serializable{
    private static final long serialVersionUID = -4116568447005811852L;
    /**
     * 时间点
     */
    private int time;
    /**
     * 时间点描述
     */
    private String timeText;
    /**
     * 退票费用
     */
    private int returnFee;
    /**
     * 改期费用
     */
    private int changeFee;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getTimeText() {
        return timeText;
    }

    public void setTimeText(String timeText) {
        this.timeText = timeText;
    }

    public int getReturnFee() {
        return returnFee;
    }

    public void setReturnFee(int returnFee) {
        this.returnFee = returnFee;
    }

    public int getChangeFee() {
        return changeFee;
    }

    public void setChangeFee(int changeFee) {
        this.changeFee = changeFee;
    }

    @Override
    public String toString() {
        return "TgqPointCharge{" +
                "time=" + time +
                ", timeText='" + timeText + '\'' +
                ", returnFee=" + returnFee +
                ", changeFee=" + changeFee +
                '}';
    }
}
