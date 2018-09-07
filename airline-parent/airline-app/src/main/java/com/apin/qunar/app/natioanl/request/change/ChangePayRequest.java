package com.apin.qunar.app.natioanl.request.change;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * @outhor lujian
 * @create 2018-07-02 18:51
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChangePayRequest extends BaseRequest {
    @NotEmpty(message = "orderNo不能为空")
    private String orderNo;
    @NotEmpty(message = "gqId不能为空")
    private String gqId;
    @NotEmpty(message = "passengerIds不能为空")
    private String passengerIds;
    @NotEmpty(message = "totalAmount不能为空")
    private String totalAmount;
    @NotEmpty(message = "validTime不能为空")
    private String validTime;
    @NotEmpty(message = "applyRemarks不能为空")
    private String applyRemarks;
}
