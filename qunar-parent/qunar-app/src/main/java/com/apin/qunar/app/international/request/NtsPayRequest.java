package com.apin.qunar.app.international.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * Created by wangliang.wang on 2017/10/26.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NtsPayRequest extends BaseRequest {
    @NotEmpty(message = "orderNo不能为空")
    private String orderNo;
}