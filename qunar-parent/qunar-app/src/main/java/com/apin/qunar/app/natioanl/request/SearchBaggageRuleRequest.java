package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-06-25 6:54
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchBaggageRuleRequest extends BaseRequest {
    private String airlineCode;
    private String cabin;
    private String depCode;
    private String arrCode;
    private String saleDate;
    private String depDate;
}
