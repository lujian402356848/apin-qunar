package com.apin.qunar.app.natioanl.request.change;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-07-02 18:51
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChangePayRequest extends BaseRequest {
    private String orderNo;
    private String gqId;
    private String passengerIds;
    private String totalAmount;
    private String validTime;
    private String applyRemarks;
}
