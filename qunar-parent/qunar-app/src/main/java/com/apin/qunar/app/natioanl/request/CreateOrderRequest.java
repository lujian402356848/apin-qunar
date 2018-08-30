package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import com.apin.qunar.order.common.enums.AgeTypeEnum;
import com.apin.qunar.order.common.enums.CardTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-22 20:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CreateOrderRequest extends BaseRequest {
    @NotEmpty(message = "vendorStr不能为空")
    private String vendorStr;//价格查询接口返回的内容，直接带过来
    @NotEmpty(message = "carrier不能为空")
    private String carrier;//航司
    @NotEmpty(message = "flightNum不能为空")
    private String flightNum;//航班号
    @NotEmpty(message = "from不能为空")
    private String from;//起飞机场三字码
    @NotEmpty(message = "to不能为空")
    private String to;//到达机场三字码;
    private String searchFrom;//搜索起飞机场三字码
    private String searchTo;//搜索到达机场三字码
    @NotEmpty(message = "startTime不能为空")
    private String startTime;//起飞日期yyyyMMdd
    @NotEmpty(message = "dptTime不能为空")
    private String dptTime;//起飞时间
    @NotEmpty(message = "contact不能为空")
    private String contact;//联系人姓名
    private String contactPreNum = "86";//国家区位码,默认86为中国区位码
    @NotEmpty(message = "contactMob不能为空")
    private String contactMob;//联系人电话
    private String contactEmail = "";//联系人邮箱
    @Size(min = 1, message = "flightNum不能为空")
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
    private String account;
    private String orderRelationNo;

    /**
     * 乘客信息
     */
    @Data
    public static class Passenger {
        @NotEmpty(message = "name不能为空")
        private String name;//乘客名称
        @NotEmpty(message = "ageType不能为空")
        private int ageType = AgeTypeEnum.ADULT.code;//0:成人,1:儿童
        @NotEmpty(message = "cardType不能为空")
        private String cardType = CardTypeEnum.IDENTIFICATION_CARD.code;//NI:身份证,PP:护照,ID:其他
        @NotEmpty(message = "cardNo不能为空")
        private String cardNo;//证件号码
        @NotEmpty(message = "sex不能为空")
        private int sex = 1;//1:男,0:女
        @NotEmpty(message = "birthday不能为空")
        private String birthday;//出生年月(yyyy-MM-dd)
        private String mobileNo;//联系电话
    }
}