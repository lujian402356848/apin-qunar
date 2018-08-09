package com.apin.qunar.order.domain.national.payFailOrder;

import lombok.Data;

import java.util.Date;

@Data
public class PayFailOrderVO {
    private String merchantNo;
    private String orderNo;
    private Date orderCreateTime;
    private String flightNum;
    private String deptCity;
    private String arriCity;
    private String deptDate;
    private String deptTime;
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
    private Date updateTime;
}
