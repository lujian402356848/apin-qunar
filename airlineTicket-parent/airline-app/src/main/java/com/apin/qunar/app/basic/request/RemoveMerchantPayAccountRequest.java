package com.apin.qunar.app.basic.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-07-27 18:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RemoveMerchantPayAccountRequest extends BaseRequest {
    private String payAccount;
}
