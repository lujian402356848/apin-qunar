package com.apin.qunar.order.domain.international.searchFlight;

import lombok.Data;

import java.util.List;

/**
 * Created by zhuangxiong on 17-10-27.
 */
@Data
public class NtsSearchFlightResult {
    private String flightCode;
    private NtsFlightTrip goTrip;
    private NtsFlightTrip backTrip;
    private int price;
    private int tax;
    private int cprice;
    private int ctax;
    private String depTime;//ui需要

    @Data
    public static class NtsFlightTrip {
        private List<NtsTransitCity> transitCities;
        private List<NtsFlightSegment> flightSegments;
        private String duration;
    }

    @Data
    public static class NtsTransitCity {
        private String transitAirportCode;
        private String transitAirportName;
        private String transitCityName;
        private String transitCityCode;
        private String transitCountryName;
        private String stayTime;
        private int crossDays;
    }

    @Data
    public static class NtsFlightSegment {
        private String source;
        private String carrierCode;
        private String carrierCodeName;
        private String flightNum;
        private String depAirportCode;
        private String depTerminal;
        private String arrAirportCode;
        private String arrTerminal;
        private String depDate;
        private String depTime;
        private String arrDate;
        private String arrTime;
        private String codeShareStatus;
        private String mainCode;
        private String mainCarrierCode;
        private String planeTypeCode;
        private String planeTypeName;
    }
}
