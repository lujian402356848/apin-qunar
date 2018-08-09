package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-06-23 22:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RefundRequest extends BaseRequest {
    private String orderNo;
    private String refundCauseId;//16:改变行程,17:填错信息,18:航班延误,19:身体原因
    private String passengerIds;
    private String refundCause;
    private String account;//退票操作人
}
