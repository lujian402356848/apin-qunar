package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by wjjunjjun.wang on 2017/8/3.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PayValidateRequest extends BaseRequest {
    private String clientSite;
    private String orderId;
    private String pmCode;
    private String bankCode;
}
