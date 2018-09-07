package com.apin.qunar.order.domain.national.createOrder;

import com.apin.qunar.order.common.enums.CardTypeEnum;

/**
 * Created by wjjunjjun.wang on 2017/8/1.
 */
public class Passenger {

    private String name;
    private int ageType;
    private String cardType = CardTypeEnum.IDENTIFICATION_CARD.code;
    private String cardNo;
    private int sex;
    private String birthday;
    private String passengerPriceTag;
    private boolean bx;
    private boolean flightDelaybx;
    private boolean tuipiaoBx;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeType() {
        return ageType;
    }

    public void setAgeType(int ageType) {
        this.ageType = ageType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassengerPriceTag() {
        return passengerPriceTag;
    }

    public void setPassengerPriceTag(String passengerPriceTag) {
        this.passengerPriceTag = passengerPriceTag;
    }

    public boolean isBx() {
        return bx;
    }

    public void setBx(boolean bx) {
        this.bx = bx;
    }

    public boolean isFlightDelaybx() {
        return flightDelaybx;
    }

    public void setFlightDelaybx(boolean flightDelaybx) {
        this.flightDelaybx = flightDelaybx;
    }

    public boolean isTuipiaoBx() {
        return tuipiaoBx;
    }

    public void setTuipiaoBx(boolean tuipiaoBx) {
        this.tuipiaoBx = tuipiaoBx;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
