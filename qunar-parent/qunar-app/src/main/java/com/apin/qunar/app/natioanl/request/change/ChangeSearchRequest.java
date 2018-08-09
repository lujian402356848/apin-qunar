package com.apin.qunar.app.natioanl.request.change;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-07-02 16:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChangeSearchRequest extends BaseRequest {
    private String orderNo;
    private String changeDate;
}
