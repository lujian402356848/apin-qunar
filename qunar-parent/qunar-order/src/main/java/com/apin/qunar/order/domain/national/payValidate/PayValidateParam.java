package com.apin.qunar.order.domain.national.payValidate;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-06-26 11:16
 */
@Data
public class PayValidateParam {
    private String clientSite;
    private String orderId;
    private String pmCode;
    private String bankCode;
}
