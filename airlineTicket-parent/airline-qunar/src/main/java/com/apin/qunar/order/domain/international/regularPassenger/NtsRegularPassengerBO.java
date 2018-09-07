package com.apin.qunar.order.domain.international.regularPassenger;


import lombok.Data;

/**
 * @outhor ligang
 * @create 2018-08-04 15:33
 */
@Data
public class NtsRegularPassengerBO {

    private Long id;
    private String name;
    private int ageType;
    private String cardType;
    private String cardNo;
    private int gender;
    private String birthday;
    private String mobileNo;
    private String cardIssuePlace;
    private String cardExpired;
    private String nationality;
    private String operator;

}
