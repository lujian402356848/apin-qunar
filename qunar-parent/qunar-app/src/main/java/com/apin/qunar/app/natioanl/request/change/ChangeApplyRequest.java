package com.apin.qunar.app.natioanl.request.change;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * @outhor lujian
 * @create 2018-07-02 16:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChangeApplyRequest extends BaseRequest {
    @NotEmpty(message = "orderNo不能为空")
    private String orderNo;
    @NotEmpty(message = "changeCauseId不能为空")
    private String changeCauseId;
    @NotEmpty(message = "passengerIds不能为空")
    private String passengerIds;
    @NotEmpty(message = "applyRemarks不能为空")
    private String applyRemarks;
    @NotEmpty(message = "uniqKey不能为空")
    private String uniqKey;
    @NotEmpty(message = "gqFee不能为空")
    private String gqFee;
    @NotEmpty(message = "startTime不能为空")
    private String startTime;
    @NotEmpty(message = "endTime不能为空")
    private String endTime;
    private String account;
    private String dptAirportCode;
    private String arrAirportCode;
    private String dptTerminal;
    private String arrTerminal;
    private String changeDate;
    private String flight;
    @NotEmpty(message = "flightNo不能为空")
    private String flightNo;
    private String flightType;
    private String startPlace;
    private String endPlace;
    private String cabin;
    @NotEmpty(message = "cabinCode不能为空")
    private String cabinCode;
    private String carrier;
    @NotEmpty(message = "upgradeFee不能为空")
    private String upgradeFee;
    private String allFee;
    private String cabinStatus;
    private String actFlightNo;
    private String share;
}
