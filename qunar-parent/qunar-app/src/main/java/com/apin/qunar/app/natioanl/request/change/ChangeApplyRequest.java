package com.apin.qunar.app.natioanl.request.change;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-07-02 16:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChangeApplyRequest extends BaseRequest {
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
    private String account;
}
