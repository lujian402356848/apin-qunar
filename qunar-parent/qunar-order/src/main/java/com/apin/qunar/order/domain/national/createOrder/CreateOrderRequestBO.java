package com.apin.qunar.order.domain.national.createOrder;

import com.apin.qunar.order.common.enums.AgeTypeEnum;
import com.apin.qunar.order.common.enums.CardTypeEnum;
import lombok.Data;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-27 0:06
 */
@Data
public class CreateOrderRequestBO {
    private String merchantNo;//业务属性
    private String orderRelationNo;//业务属性
    private String account;//业务属性
    private String vendorStr;//价格查询接口返回的内容，直接带过来
    private String carrier;//航司
    private String flightNum;//航班号
    private String from;//起飞机场三字码
    private String to;//到达机场三字码;
    private String startTime;//起飞日期yyyyMMdd
    private String dptTime;//起飞时间
    private String contact;//联系人姓名
    private String contactPreNum = "86";//国家区位码,默认86为中国区位码
    private String contactMob;//联系人电话
    private String contactEmail = "";//联系人邮箱
    private List<Passenger> passengers;//乘客信息
    private String needInvoice = "";//是否需要发票,1:需要,空:不需要
    private int invoiceType = 1;//1:旅行产品发票,2:行程单和差额发票
    private String receiverTitle;//发票抬头
    private int receiverType;//抬头类型,1:单位，2：个人, 3：企业，4：政府机关单位
    private String taxpayerId;//纳税人识别号,当receiverType传入值为1,3时,此字段为必填
    private String sjr;//收件人姓名
    private String sjrPhone;//收件人电话
    private String address;//收件人地址
    private boolean needXcd = false;//是否需要行程单
    /**
     * 乘客信息
     */
    @Data
    public static class Passenger {
        private String name;//乘客名称
        private int ageType = AgeTypeEnum.ADULT.code;//0:成人,1:儿童
        private String cardType = CardTypeEnum.IDENTIFICATION_CARD.code;//NI:身份证,PP:护照,ID:其他
        private String cardNo;//证件号码
        private int sex = 1;//1:男,0:女
        private String birthday;//出生年月(yyyy-MM-dd)
        private String mobileNo;//联系电话
    }
}
