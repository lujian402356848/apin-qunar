package com.apin.qunar.app.basic.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-07-30 12:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CheckVerifyCodeRequest extends BaseRequest {
    private String verifyCode;
}
