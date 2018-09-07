package com.apin.qunar.app.basic.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-07-25 18:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CreateMerchantPayAccountRequest extends BaseRequest{
    private String merchantNo;
    private String account;
    private Integer accountType;
    private String bankCode;
    private String signedAccount;
}
