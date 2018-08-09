package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateRegularPassengerRequest extends BaseRequest {
    private String name;
    private int ageType;
    private String cardType;
    private String cardNo;
    private int gender;
    private String birthday;
    private String mobileNo;
    private String account;
}
