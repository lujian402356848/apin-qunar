package com.apin.qunar.app.basic.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RemoveRegularPassengerRequest extends BaseRequest {
    private Long id;
}
