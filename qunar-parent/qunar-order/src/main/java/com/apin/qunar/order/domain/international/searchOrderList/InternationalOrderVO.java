package com.apin.qunar.order.domain.international.searchOrderList;

import lombok.Data;

import java.util.Date;

/**
 * @outhor lujian
 * @create 2018-07-09 12:26
 */
@Data
public class InternationalOrderVO {
    /**
     * 订单id
     */
    private Long id;

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
    private String goFlightNum;

    /**
     * 主飞航班
     */
    private String goActFlightNum;

    /**
     * 飞行时间
     */
    private String goFlightTime;

    /**
     * 航空公司编号
     */
    private String goCarrierCode;

    /**
     * 航空公司名称
     */
    private String goCarrierName;

    /**
     * 经停次数
     */
    private Integer goStopCnt;

    /**
     * 仓位
     */
    private String goCabin;

    /**
     * 出发城市
     */
    private String goDeptCity;

    /**
     * 到达城市
     */
    private String goArriCity;

    /**
     * 起飞机场编号
     */
    private String goDeptAirportCode;

    /**
     * 到达机场编号
     */
    private String goArriAirportCode;

    /**
     * 起飞机场名称
     */
    private String goDeptAirportName;

    /**
     * 到达机场名称
     */
    private String goArriAirportName;

    /**
     * 起飞机场航站楼
     */
    private String goDeptTerminal;

    /**
     * 到达机场航站楼
     */
    private String goArriTerminal;

    /**
     * 出发日期
     */
    private String goDeptDate;

    /**
     * 出发时间
     */
    private String goDeptTime;

    /**
     * 到达时间
     */
    private String goArriTime;

    /**
     * 票号
     */
    private String backTicketNo;

    /**
     * 航班号
     */
    private String backFlightNum;

    /**
     * 主飞航班
     */
    private String backActFlightNum;

    /**
     * 飞行时间
     */
    private String backFlightTime;

    /**
     * 航空公司编号
     */
    private String backCarrierCode;

    /**
     * 航空公司名称
     */
    private String backCarrierName;

    /**
     * 经停次数
     */
    private Integer backStopCnt;

    /**
     * 仓位
     */
    private String backCabin;

    /**
     * 出发城市
     */
    private String backDeptCity;

    /**
     * 到达城市
     */
    private String backArriCity;

    /**
     * 起飞机场编号
     */
    private String backDeptAirportCode;

    /**
     * 到达机场编号
     */
    private String backArriAirportCode;

    /**
     * 起飞机场名称
     */
    private String backDeptAirportName;

    /**
     * 到达机场名称
     */
    private String backArriAirportName;

    /**
     * 起飞机场航站楼
     */
    private String backDeptTerminal;

    /**
     * 到达机场航站楼
     */
    private String backArriTerminal;

    /**
     * 出发日期
     */
    private String backDeptDate;

    /**
     * 出发时间
     */
    private String backDeptTime;

    /**
     * 到达时间
     */
    private String backArriTime;

    /**
     * 退票费用
     */
    private Integer returnFee;

    /**
     * 退票费用说明
     */
    private String returnText;

    /**
     * 改签费用
     */
    private Integer changeFee;

    /**
     * 改签费用说明
     */
    private String changeText;

    /**
     * 支付流水号
     */
    private String payId;

    /**
     * 支付金额
     */
    private Integer payAmount;

    /**
     * 支付状态(0:等待支付,1:支付成功等待出票)
     */
    private Integer payStatus;

    /**
     * 支付时间
     */
    private String payTime;

    /**
     * 支付返回的消息
     */
    private String payErrorMsg;

    /**
     * 支付时限
     */
    private String payDeadline;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 国家区位码
     */
    private String contactNum;

    /**
     * 联系人手机号
     */
    private String contactMobile;

    /**
     * 联系人邮件
     */
    private String contactEmail;

    /**
     * 插入时间
     */
    private Date insertTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 乘客信息
     */
    private String passengers;
}
