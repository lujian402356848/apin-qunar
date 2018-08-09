package com.apin.qunar.order.domain.national.changeApply;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-07-02 15:47
 */
@Data
public class ChangeApplyParam {
    private String orderNo;
    private String changeCauseId;
    private String passengerIds;
    private String applyRemarks;
    private String uniqKey;
    private String gqFee;
    private String upgradeFee;
    private String flightNo;
    private String cabinCode;
    private String startDate;
    private String startTime;
    private String endTime;
    private String callbackUrl;
}