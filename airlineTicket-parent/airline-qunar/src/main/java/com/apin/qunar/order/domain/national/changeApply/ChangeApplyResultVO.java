package com.apin.qunar.order.domain.national.changeApply;

import lombok.Data;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-17 17:13
 */
@Data
public class ChangeApplyResultVO {
        private long id;
        private String name;
        private String cardType;
        private String cardNum;
        private String ticketNum;
        private String birthday;
        private int gender;
        private ChangeApplyResult changeApplyResult;


    @Data
    public static class ChangeApplyResult {
        private boolean success;
        private String orderNo;
        private String orderId;
        private boolean createProduct;
        private String gqId;
    }
}
