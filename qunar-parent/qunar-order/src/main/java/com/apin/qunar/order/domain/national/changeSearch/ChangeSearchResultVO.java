package com.apin.qunar.order.domain.national.changeSearch;

import lombok.Data;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-23 22:19
 */
@Data
public class ChangeSearchResultVO {
    private long id;
    private String name;
    private String cardType;
    private String cardNum;
    private String ticketNum;
    private String birthday;
    private int gender;//1:女,0:男
    private String changeApplyResult;
    private String passengerTypeStr;
    private ChangeSearchResult changeSearchResult;

    @Data
    public static class ChangeSearchResult {
        private String reason;
        private boolean disabled;
        private String disableReason;
        private BaseOrderInfo baseOrderInfo;
        private List<FlightInfo> flightSegmentList;
        private ChangeRuleInfo changeRuleInfo;
        private ContactInfo contactInfo;
        private String tgqViewInfoJson;
        private List<TgqReason> tgqReasons;
        private boolean canChange;
        private int airChangeCode;
        private String airChangeDesc;
        private String passengerTypeStr;
    }

    @Data
    public static class BaseOrderInfo {
        private int status;
        private String statusDesc;
        private boolean showNotWork;
        private int distributeType;
    }

    @Data
    public static class FlightInfo {
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
        private String dptTerminal;
        private String arrTerminal;
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
    public static class ChangeRuleInfo {
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
        private int code;
        private String msg;
        private boolean will;
        private List<ChangeFlightSegment> changeFlightSegmentList;
    }

    @Data
    public static class ChangeFlightSegment {
        private String dptAirportCode;
        private String arrAirportCode;
        private String dptTerminal;
        private String arrTerminal;
        private StopFlightInfo stopFlightInfo;
        private String changeDate;
        private String startTime;
        private String endTime;
        private String flight;
        private String flightNo;
        private String flightType;
        private String startPlace;
        private String endPlace;
        private String cabin;
        private String cabinCode;
        private String uniqKey;
        private String carrier;
        private String extraPrice;
        private String gqFee;
        private String upgradeFee;
        private String allFee;
        private String cabinStatus;
        private String actFlightNo;
        private boolean share;
        private String adultUFee;
        private String childGqFee;
        private String childUpgradeFee;
        private String childAllFee;
        private String extraPriceText;
        private String gqFeeText;
        private String upgradeFeeText;
        private String allFeeText;
        private String adultUFeeText;
        private String cabinStatusText;
    }

    @Data
    private static class StopFlightInfo {
        private int stopType;
        private String stopTypeDesc;
        private List<StopCityInfo> stopCityInfoList;
    }

    @Data
    private static class StopCityInfo {
        private String stopCityCode;
        private String stopCityName;
        private String stopAirportCode;
        private String stopAirportName;
    }
}