package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * @outhor lujian
 * @create 2018-06-25 6:54
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchBaggageRuleRequest extends BaseRequest {
    @NotEmpty(message = "airlineCode不能为空")
    private String airlineCode;
    @NotEmpty(message = "cabin不能为空")
    private String cabin;
    @NotEmpty(message = "depCode不能为空")
    private String depCode;
    @NotEmpty(message = "arrCode不能为空")
    private String arrCode;
    @NotEmpty(message = "saleDate不能为空")
    private String saleDate;
    @NotEmpty(message = "depDate不能为空")
    private String depDate;
}
