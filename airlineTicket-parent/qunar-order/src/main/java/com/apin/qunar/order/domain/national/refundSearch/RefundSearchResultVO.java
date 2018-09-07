package com.apin.qunar.order.domain.national.refundSearch;

import lombok.Data;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-23 22:19
 */
@Data
public class RefundSearchResultVO {
    private long id;
    private String name;
    private String cardType;
    private String cardNum;
    private String ticketNum;
    private String birthday;
    private int gender;
    private RefundSearch refundSearchResult;

    @Data
    public static class RefundSearch {
        private String reason;
        private BaseOrderInfo baseOrderInfo;
        private List<FlightSegment> flightSegmentList;
        private RefundRuleInfo refundRuleInfo;
        private ContactInfo contactInfo;
        private List<TgqReason> tgqReasons;
        private boolean canRefund;
        private boolean noTicket;
        private boolean airChangeAllRefund;
        private boolean needUploadProof;
    }

    @Data
    public static class BaseOrderInfo {
        private int status;
        private String statusDesc;
        private boolean showNotWork;
        private int distributeType;
    }

    @Data
    public static class FlightSegment {
        private String flightNo;
        private String flightCo;
        private String flightShortCo;
        private String flightLogoUrl;
        private String flightPhone;
        private String dptCity;
        private String arrCity;
        private String dptPort;
        private String arrPort;
        private String dptAirport;
        private String arrAirport;
        private String dptDate;
        private String dptTime;
        private String arrDate;
        private String arrTime;
        private String stopCity;
        private String stopAirport;
        private boolean isShared;
        private String realFlightNum;
        private boolean stop;
    }

    @Data
    public static class RefundRuleInfo {
        private int viewType;
        private boolean hasTime;
        private String tgqText;
        private String signText;
        private String childTgqMsg;
        private String timePointCharges;
        private String refundDescription;
    }

    @Data
    public static class ContactInfo {
        private String contactName;
        private String phone;
    }

    @Data
    public static class TgqReason {
        private String code;
        private String msg;
        private String will;
        private List<RefundPassengerPriceInfo> refundPassengerPriceInfoList;
    }

    @Data
    public static class RefundPassengerPriceInfo {
        private BasePassengerPriceInfo basePassengerPriceInfo;
        private RefundFeeInfo refundFeeInfo;
    }

    @Data
    public static class BasePassengerPriceInfo {
        private boolean disabled;
        private String disableReason;
        private Long passengerId;
        private String passengerName;
        private String cardNum;
        private String passengerTypeStr;
        private int ticketPrice;
        private int constructionFee;
        private int fuelTax;
    }

    @Data
    public static class RefundFeeInfo {
        private int refundFee;
        private int nextRefundFee;
        private int retrunRefundFee;
        private int nextReturnRefundFee;
    }
}