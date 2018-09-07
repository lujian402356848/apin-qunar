package com.apin.qunar.app.basic.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-07-23 15:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChangeMerchantRequest extends BaseRequest {
    private String contactName;
    private String contactMobile;
    private String companyName;
    private String companyAddress;
}
