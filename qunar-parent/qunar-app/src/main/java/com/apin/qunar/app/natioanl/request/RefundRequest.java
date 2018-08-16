package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * @outhor lujian
 * @create 2018-06-23 22:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RefundRequest extends BaseRequest {
    @NotEmpty(message = "orderNo不能为空")
    private String orderNo;
    @NotEmpty(message = "refundCauseId不能为空")
    private String refundCauseId;//16:改变行程,17:填错信息,18:航班延误,19:身体原因
    @NotEmpty(message = "passengerIds不能为空")
    private String passengerIds;
    @NotEmpty(message = "refundCause不能为空")
    private String refundCause;
    @NotEmpty(message = "account不能为空")
    private String account;//退票操作人
}
