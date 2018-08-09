package com.apin.qunar.app.international.request;


import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NtsChangeRegularPassengerRequest extends BaseRequest {
    private Long id;
    private String name;
    private int ageType;
    private String cardType;
    private String cardNo;
    private String gender;
    private String birthday;
    private String mobileNo;
    private String cardIssuePlace;
    private String cardExpired;
    private String nationality;
}
