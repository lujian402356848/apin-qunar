package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-06-23 18:05
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchSignRequest extends BaseRequest {
    private String bankCode;
    private String signedAccount;
}
