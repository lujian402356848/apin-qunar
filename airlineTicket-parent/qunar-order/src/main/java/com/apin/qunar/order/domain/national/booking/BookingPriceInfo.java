package com.apin.qunar.order.domain.national.booking;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by stanley on 15-11-20 At 11:42
 */
@Data
public class BookingPriceInfo implements Serializable {
    /**
     * 票面价
     */
    private String ticketPrice;

    /**
     * 机票价格
     */
    private String price;

    /**
     * 裸票价
     */
    private String barePrice;

    /**
     * TTS原票价
     */
    private String originalBarePrice;

    /**
     * 加价
     */
    private String addPrice;

    /**
     * Y舱价格
     */
    private String basePrice;

    /**
     * 折扣
     */
    private String discount;
    private String childPrice;
    private String childTicketPrice;

    /**
     * TTS原票价
     */
    private String originalChildBarePrice;

    /**
     * 加价
     */
    private String childAddPrice;
    private String babyPrice;
    private String babyTicketPrice;

    /**
     * TTS原票价
     */
    private String originalBabyBarePrice;

    /**
     * 加价
     */
    private String babyAddPrice;
    private String returnMoney;
    private String cutMoney;
    private String babyServiceFee;
    private Inventory inventory;
    private String tof;
    private String arf;
    private String childtof;
    private String prdTag;
    private String dtTag;
    Map<String, List<PackageInfo>> priceTag;
}
