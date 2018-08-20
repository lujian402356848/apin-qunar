package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;

@Data
public class CreateReimburseVoucherRequest extends BaseRequest {

    private String orderNo;//订单号
    private String deptCity;//出发城市
    private String arriCity;//到达城市
    private String flightNum;//航班号
    private String deptDate;//出发日期
    private int reimburseType;//报销单类型(1:行程单差额发票)
    private int distributionType;//配送方式(1:快递)
    private int distributionAmount;//配送金额(元为单位)
    private int invoiceTitleType;//发票抬头类型(1:企业,2:个人)
    private String invoiceTitleContent;//发票抬头内容
    private String taxpayerNo;//纳税人编号
    private String receiverName;//收件人姓名
    private String receiverMobileNo;//收件人手机号
    private String receiveAddress;//收件人地址
}
