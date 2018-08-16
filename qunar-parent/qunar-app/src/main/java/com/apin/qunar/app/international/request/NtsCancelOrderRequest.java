package com.apin.qunar.app.international.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * @outhor lujian
 * @create 2018-06-25 14:51
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NtsCancelOrderRequest extends BaseRequest {

    @NotEmpty(message = "orderNo不能为空")
    private String orderNo;
}
