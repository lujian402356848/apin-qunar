package com.apin.qunar.order.domain.international.searchRefundChangeSign;

import lombok.Data;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-27 17:18
 */
@Data
public class NtsSearchRefundChangeSignResult {
    private String refundCondWBDNew;
    private String changeCondWBDNew;
    private String trans;
    private String penalty;
    private String luggageCond;
    private String addtionalDesc;
    private StandardDigitalTgqInfo standardDigitalTgqInfo;

    @Data
    public static class StandardDigitalTgqInfo {
        private Refund refund;
        private Change change;
        private NoShowInfo noShowInfo;
        private int allowPartRefund;
        private int partRefundMoney;
        private int allowPartChange;
        private int partChangeMoney;
        private String trans;
        private String addtionalDesc;
    }

    @Data
    public static class Refund {
        private List<RefundInfo> list;
        private int moneyAfterFlight;
    }

    @Data
    public static class RefundInfo {
        private int price;
        private int lowerEndpoint;
        private int upperEndpoint;
    }

    @Data
    public static class Change {
        private List<ChangeInfo> list;
        private int moneyAfterFlight;
    }

    @Data
    public static class ChangeInfo {
        private int price;
        private int lowerEndpoint;
        private int upperEndpoint;
    }

    @Data
    public static class NoShowInfo {
        private int noShowLimitTime;
        private int hasNoShow;
        private int noshowForChange;
        private int noshowForRefund;
        private int panalty;
    }
}
