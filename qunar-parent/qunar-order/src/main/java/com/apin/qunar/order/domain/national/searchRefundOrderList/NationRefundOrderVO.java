package com.apin.qunar.order.domain.national.searchRefundOrderList;

import lombok.Data;

import java.util.Date;
/**
 * @outhor ligang
 * @create 2018-07-27 17:23
 */
@Data
public class NationRefundOrderVO {

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
     * 起飞机场名称
     */
    private String deptAirportName;

    /**
     * 到达机场名称
     */
    private String arriAirportName;

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
     * 退票原因编号
     */
    private Integer reteunCode;

    /**
     * 是否可退（1-不可退，2-可退）
     */
    private Integer hasDisabled;

    /**
     * 不可退原因
     */
    private String disableReason;

    /**
     * 退票状态
     */
    private Integer returnStatus;

    /**
     * 退票时间
     */
    private String returnTime;

    /**
     * 退票金额
     */
    private Integer returnFee;

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
    /*
    * 退票总费用
    * */
    private Integer returnPrices;

}
