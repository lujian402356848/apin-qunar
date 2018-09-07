package com.apin.qunar.app.basic.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-07-23 15:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AuditMerchantRequest extends BaseRequest {
    private String merchantNo;
    private String auditUser;
    private Integer auditStatus;
    private String contactMobile;
}
