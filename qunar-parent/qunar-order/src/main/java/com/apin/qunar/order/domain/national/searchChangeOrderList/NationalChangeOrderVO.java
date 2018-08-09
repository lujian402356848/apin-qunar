package com.apin.qunar.order.domain.national.searchChangeOrderList;


import lombok.Data;

import java.util.Date;

/**
 * @outhor ligang
 * @create 2018-08-07 16:46
 */
@Data
public class NationalChangeOrderVO {


    /**
     * 订单id
     */
    private Long id;

    /**
     * 商户号
     */
    private String merchantNo;
    private String passengers;
    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 票号
     */
    private String ticketNo;

    /**
     * 航班号
     */
    private String flightNum;

    /**
     * 主飞航班
     */
    private String actFlightNum;

    /**
     * 飞行时间
     */
    private String flightTime;

    /**
     * 航空公司编号
     */
    private String carrierCode;

    /**
     * 航空公司名称
     */
    private String carrierName;

    /**
     * 出发城市
     */
    private String deptCity;

    /**
     * 到达城市
     */
    private String arriCity;

    /**
     * 起飞机场编号
     */
    private String deptAirportCode;

    /**
     * 到达机场编号
     */
    private String arriAirportCode;

    /**
     * 起飞机场名称
     */
    private String deptAirportName;

    /**
     * 到达机场名称
     */
    private String arriAirportName;

    /**
     * 起飞机场航站楼
     */
    private String deptTerminal;

    /**
     * 到达机场航站楼
     */
    private String arriTerminal;

    /**
     * 出发日期
     */
    private String deptDate;

    /**
     * 出发时间
     */
    private String deptTime;

    /**
     * 到达时间
     */
    private String arriTime;

    /**
     * 改签id
     */
    private String changeId;

    /**
     * 改签金额
     */
    private Integer changeFee;

    /**
     * 改签状态(40:改签申请中,42:改签完成)
     */
    private Integer changeStatus;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 联系人手机号
     */
    private String contactMobile;

    /**
     * 联系人邮件
     */
    private String contactEmail;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 插入时间
     */
    private Date insertTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
