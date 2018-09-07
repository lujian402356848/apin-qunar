package com.apin.qunar.order.domain.national.ReimburseVoucher;


import lombok.Data;

/**
 * @outhor ligang
 * @create 2018-08-04 15:33
 */
@Data
public class ReimburseVoucherBO {

    private String merchantNo;

    /**
     * 报销单类型(1:行程单差额发票)
     */
    private Integer reimburseType;

    /**
     * 配送方式(1:快递)
     */
    private Integer distributionType;

    /**
     * 配送金额(元为单位)
     */
    private Integer distributionAmount;

    /**
     * 发票抬头类型(1:企业,2:个人)
     */
    private Integer invoiceTitleType;

    /**
     * 发票抬头内容
     */
    private String invoiceTitleContent;

    /**
     * 纳税人编号
     */
    private String taxpayerNo;

    /**
     * 收件人姓名
     */
    private String receiverName;

    /**
     * 收件人手机号
     */
    private String receiverMobileNo;

    /**
     * 收件人地址
     */
    private String receiveAddress;
}
