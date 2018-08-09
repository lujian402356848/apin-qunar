package com.apin.qunar.order.domain.international.searchFlight;

import lombok.Data;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-17 17:16
 */
@Data
public class NtsSearchFlightResultVO {
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
        private List<NtsTransitCity> transitCities; //转飞
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
        private int stops;
        private List<Stop> stop;//经停
    }

    @Data
    public static class Stop
    {
        private String airportCode;
        private String airportName;
        private String cityCode;
        private String cityName;
        private String arrDate;
        private String arrTime;
        private String depDate;
        private String depTime;
        private String stopTime;
        private String crossDays;
    }
}
