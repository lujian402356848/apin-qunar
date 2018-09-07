package com.apin.qunar.app.natioanl.request;


import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChangeRegularPassengerRequest extends BaseRequest {
    private Long id;
    private String name;
    private int ageType;
    private String cardType;
    private String cardNo;
    private int gender;//0:女,1:男
    private String birthday;
    private String mobileNo;
}
