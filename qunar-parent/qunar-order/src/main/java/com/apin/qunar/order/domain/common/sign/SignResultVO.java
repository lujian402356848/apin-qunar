package com.apin.qunar.order.domain.common.sign;

import lombok.Data;

@Data
public class SignResultVO {
    private String bankCode;
    private String signedAccount;
    private String signStatus;
    private String finishSignTime;
    private String charSet;
    private String retHtml;
    private int errCode;
    private String errMsg;
}
