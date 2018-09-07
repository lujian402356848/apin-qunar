package com.apin.qunar.app.common.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SearchSignRequest extends BaseRequest {
    private String merchantNo;
    private String account;
    private Integer accountType;
    private String bankCode;
    private String signedAccount;
}
