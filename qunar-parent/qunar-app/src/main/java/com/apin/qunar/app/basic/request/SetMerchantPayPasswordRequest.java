package com.apin.qunar.app.basic.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-07-25 19:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SetMerchantPayPasswordRequest extends BaseRequest {
    private String account;
    private String password;
}
