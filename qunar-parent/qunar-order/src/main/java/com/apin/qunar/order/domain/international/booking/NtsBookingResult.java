package com.apin.qunar.order.domain.international.booking;

import lombok.Data;

import java.util.List;

/**
 * Created by wangliang.wang on 2017/10/27.
 */
@Data
public class NtsBookingResult {
    private int maxSeats;
    private String bookingTagKey;
    private PriceInfo priceInfo;
    private TgqRule tgqRule;
    private List<Segment> segments;

    @Data
    public static class PriceInfo {
        private int adultPrice;
        private int adultTax;
        private int childPrice;
        private int childTax;
    }

    @Data
    public static class TgqRule {
        private String refund;
        private String change;
        private String baggage;
        private String other;
    }

    @Data
    public static class Segment {
        private String carrier;
        private String flightNumber;
        private String departPort;
        private String departDate;
        private String departTime;
        private String arriveDate;
        private String arriveTime;
        private String arrivePort;
        private String stopCities;
        private boolean codeShare;
        private String cabin;
        private String aircraftCode;
        private int cabinClass;
    }
}
