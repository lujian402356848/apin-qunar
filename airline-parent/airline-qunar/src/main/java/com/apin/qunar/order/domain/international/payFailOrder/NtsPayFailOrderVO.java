package com.apin.qunar.order.domain.international.payFailOrder;

import lombok.Data;

import java.util.Date;

@Data
public class NtsPayFailOrderVO {
    private String merchantNo;
    private String orderNo;
    private Date orderCreateTime;
    private String goFlightNum;
    private String goDeptCity;
    private String goArriCity;
    private String goDeptDate;
    private String goDeptTime;
    private String backFlightNum;
    private String backDeptCity;
    private String backArriCity;
    private String backDeptDate;
    private String backDeptTime;
    private Integer payChannel;
    private Integer payAmount;
    private String payTime;
    private String contactName;
    private String contactMobile;
    private String processDepartment;
    private Integer processPayAmount;
    private String processPerson;
    private Integer processStatus;
    private String processDesc;
    private Date insertTime;
    private Date updateTime;
}
