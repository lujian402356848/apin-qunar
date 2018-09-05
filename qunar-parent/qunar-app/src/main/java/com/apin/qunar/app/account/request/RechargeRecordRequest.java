package com.apin.qunar.app.account.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RechargeRecordRequest extends BaseRequest {
    private Integer offset;
    private Integer limit;
}
