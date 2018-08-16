package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * @outhor lujian
 * @create 2018-06-23 22:19
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RefundSearchRequest extends BaseRequest {
    @NotEmpty(message = "orderNo不能为空")
    private String orderNo;
}