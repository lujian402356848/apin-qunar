package com.apin.qunar.order.domain.national.pay;

/**
 * @outhor lujian
 * @create 2018-06-25 7:20
 */
public class PayParam {
    /**
     * 代理商域名
     */
    private String clientSite;

    /**
     * 机票订单id
     */
    private String orderId;

    /**
     * 支付方式
     */
    private String pmCode;

    /**
     * 银行编号
     */
    private String bankCode;

    /**
     * 付款商户Id
     */
    private String paymentMerchantCode;

    /**
     * 货币代码
     */
    private String curId;

    /**
     * 后台通知URL
     */
    private String bgRetUrl;

    public String getClientSite() {
        return clientSite;
    }

    public void setClientSite(String clientSite) {
        this.clientSite = clientSite;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getPaymentMerchantCode() {
        return paymentMerchantCode;
    }

    public void setPaymentMerchantCode(String paymentMerchantCode) {
        this.paymentMerchantCode = paymentMerchantCode;
    }

    public String getCurId() {
        return curId;
    }

    public void setCurId(String curId) {
        this.curId = curId;
    }

    public String getBgRetUrl() {
        return bgRetUrl;
    }

    public void setBgRetUrl(String bgRetUrl) {
        this.bgRetUrl = bgRetUrl;
    }
}
