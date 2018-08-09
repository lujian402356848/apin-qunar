package com.apin.qunar.app.international.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by wangliang.wang on 2017/10/26.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NtsPayValidateRequest extends BaseRequest {
    private String orderNo;
}
