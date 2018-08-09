package com.apin.qunar.order.domain.international.regularPassenger;


import lombok.Data;

/**
 * @outhor ligang
 * @create 2018-08-04 15:33
 */
@Data
public class NtsRegularPassengerVO {
    private String id;
    private String name;
    private String firstName;
    private String lastName;
    private int ageType;
    private String cardType;
    private String cardNo;
    private String gender;
    private String birthday;
    private String mobileNo;
    private String cardIssueplace;
    private String cardExpired;
    private String nationality;

}
