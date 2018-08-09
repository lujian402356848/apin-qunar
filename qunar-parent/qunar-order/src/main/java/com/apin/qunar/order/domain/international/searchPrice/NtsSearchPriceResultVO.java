package com.apin.qunar.order.domain.international.searchPrice;

import lombok.Data;

import java.util.List;

/**
 * Created by zhuangxiong on 17-10-31.
 */
@Data
public class NtsSearchPriceResultVO {

    private NtsFlightTrip goTrip;
    private NtsFlightTrip backTrip;
    private List<PriceInfo> priceInfo;

    @Data
    public static class NtsFlightTrip {
        private List<TransitCity> transitCities;
        private List<FlightSegment> flightSegments;
        private String duration;
        private int crossDays;
    }

    @Data
    public static class TransitCity {
        private String transitAirportCode;
        private String transitAirportName;
        private String transitCityName;
        private String transitCityCode;
        private String transitCountryName;
        private String stayTime;
        private int crossDays;
    }

    @Data
    public static class PriceInfo {
        private String packName;
        private int price;
        private int tax;
        private int taxType;
        private int cPrice;
        private int cTax;
        private int cTaxType;
        private String cabin;
        private String cabinLevel;
        private String priceKey;
    }

    @Data
    public static class FlightSegment {
        private String carrierCode;
        private String carrierShortName;
        private String carrierFullName;
        private String flightNum;
        private String depAirportCode;
        private String depAirportName;
        private String depTerminal;
        private String arrAirportCode;
        private String arrAirportName;
        private String arrTerminal;
        private String depCityName;
        private String arrCityName;
        private String depCityCode;
        private String arrCityCode;
        private String depDate;
        private String depTime;
        private String arrDate;
        private String arrTime;
        private String codeShareStatus;
        private String mainCode;
        private String mainCarrierCode;
        private String mainCarrierFullName;
        private String planeTypeCode;
        private String planeTypeName;
        private String duration;
    }
}
