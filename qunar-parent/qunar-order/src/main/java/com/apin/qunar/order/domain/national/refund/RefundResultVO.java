package com.apin.qunar.order.domain.national.refund;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-06-23 23:01
 */
@Data
public class RefundResultVO {
    private long id;
    private String name;
    private String cardType;
    private String cardNum;
    private String ticketNum;
    private String birthday;
    private int gender;
    private RefundApplyResult refundApplyResult;

    @Data
    public static class RefundApplyResult {
        private boolean success;
        private String reason;
        private boolean volunteer;
        private boolean noTicket;
    }
}