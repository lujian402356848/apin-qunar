package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by wjjunjjun.wang on 2017/8/4.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PayRequest extends BaseRequest {
    private String clientSite;
    private String orderId;
}