package com.apin.qunar.order.domain.national.changeApply;

import lombok.Data;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-23 22:19
 */
@Data
public class ChangeApplyResult {
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
        private ChangeResult changeApplyResult;
    }

    @Data
    public static class ChangeResult {
        private boolean success;
        private String orderNo;
        private String orderId;
        private boolean createProduct;
        private String gqId;
    }
}