package com.apin.qunar.order.domain.national.changeSearch;

import lombok.Data;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-23 22:19
 */
@Data
public class ChangeSearchResult {
    private List<NationalPassenger> result;

    @Data
    public static class NationalPassenger {
        private long id;
        private String name;
        private String cardType;
        private String cardNum;
        private String ticketNum;
        private String birthday;
        private int gender;
        private CanChangeResult changeSearchResult;
    }

    @Data
    public static class CanChangeResult {
        private boolean canChange;
        private BaseOrderInfo baseOrderInfo;
        private List<FlightInfo> flightSegmentList;
        private ChangeRuleInfo changeRuleInfo;
        private ContactInfo contactInfo;
        private String tgqViewInfoJson;
        private List<TgqReason> tgqReasons;
    }

    @Data
    public static class BaseOrderInfo {
        private int status;
        private String statusDesc;
    }

    @Data
    public static class FlightInfo {
        private int flightNo;
        private boolean flightCo;
        private String flightShortCo;
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
        private boolean stop;
        private String stopCity;
        private String stopAirport;
        private boolean isShared;
        private String realFlightNum;
    }

    @Data
    public static class ChangeRuleInfo {
        private int viewType;
        private String hasTime;
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
        private List<FlightAlterSearchResultWithText> changeFlightSegmentList;
    }

    @Data
    public static class FlightAlterSearchResultWithText {
        private String dptAirportCode;
        private String arrAirportCode;
        private String dptTerminal;
        private String arrTerminal;
        private String stopFlightInfo;
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
        private String gqFeeText;
        private String upgradeFeeText;
        private String allFeeText;
        private String adultUFeeText;
        private String cabinStatusText;
    }
}