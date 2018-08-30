package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * Created by wjjunjjun.wang on 2017/8/3.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PayValidateRequest extends BaseRequest {
    @NotEmpty(message = "clientSite不能为空")
    private String clientSite;
    @NotEmpty(message = "orderId不能为空")
    private String orderId;
}
