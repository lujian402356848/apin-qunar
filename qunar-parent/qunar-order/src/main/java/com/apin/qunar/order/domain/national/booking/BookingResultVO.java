package com.apin.qunar.order.domain.national.booking;

import lombok.Data;

import java.util.List;

/**
 * Created by wjjunjjun.wang on 2017/8/1.
 */
@Data
public class BookingResultVO {

    /**
     * booking 状态
     */
    private String bookingStatus = "";
    /**
     * booking失败信息
     */
    private String errMsg = "";

    /**
     * booking　Tag
     */
    private String bookingTag = "";
    /**
     * 航班信息
     */
    private List<BookingFlightInfo> flightInfo;
    /**
     * 报价信息
     */
    private BookingPriceInfo priceInfo;
    /**
     * Booking 扩展信息
     */
    private ExtInfo extInfo;
    /**
     * 退改签说明
     */
    private TgqShowData tgqShowData;
    /**
     * 出票时间说明
     */
    private String ticketTime = "";
    /**
     * 保险信息
     */
    private Ins bookingIns;

    /**
     * 报销信息与快递费用信息
     */
    private ExpressInfo expressInfo;
}
