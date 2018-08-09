package com.apin.qunar.app.basic.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-07-25 19:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChangeMerchantPayPasswordRequest extends BaseRequest {
    private String password;
}
