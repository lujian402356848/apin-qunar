package com.apin.qunar.app.basic.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChangePassengerRequest extends BaseRequest {
    private Long id;
    private String name;
    private int ageType;
    private String card_type;
    private String card_no;
    private int gender;
    private String birthday;
    private String mobileNo;
}
