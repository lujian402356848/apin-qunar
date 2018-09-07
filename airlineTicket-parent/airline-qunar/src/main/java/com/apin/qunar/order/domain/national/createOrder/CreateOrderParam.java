package com.apin.qunar.order.domain.national.createOrder;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by wjjunjjun.wang on 2017/8/2.
 */
public class CreateOrderParam {

    private String productTag;
    private boolean flyFund;
    @JsonProperty("isUseBonus")
    private boolean isUseBonus;
    private int fuelTax;
    private int childFuelTax;
    private int constructionFee;
    private int printPrice;
    private int yPrice;
    private int childPrintPrice;
    private int discount;
    private int policyType;
    private long policyId;
    private String contact;
    private String contactPreNum;
    private String contactMob;
    private String contactEmail;
    private int invoiceType;
    private String receiverTitle;
    private int receiverType;
    private String taxpayerId;
    private String sjr;
    private String sjrPhone;
    private String address;
    private String xcd;
    private String xcdMethod;
    private int xcdPrice;
    private String bxInvoice;
    private int passengerCount;
    private String bookingTag;
    private String qt;
    private String source;
    private String clientSite;
    private FlightInfo flightInfo;
    private List<Passenger> passengers;
    private String ext;

    public String getProductTag() {
        return productTag;
    }

    public void setProductTag(String productTag) {
        this.productTag = productTag;
    }

    public boolean isFlyFund() {
        return flyFund;
    }

    public void setFlyFund(boolean flyFund) {
        this.flyFund = flyFund;
    }

    public boolean isUseBonus() {
        return isUseBonus;
    }

    public void setUseBonus(boolean useBonus) {
        isUseBonus = useBonus;
    }

    public int getFuelTax() {
        return fuelTax;
    }

    public void setFuelTax(int fuelTax) {
        this.fuelTax = fuelTax;
    }

    public int getChildFuelTax() {
        return childFuelTax;
    }

    public void setChildFuelTax(int childFuelTax) {
        this.childFuelTax = childFuelTax;
    }

    public int getConstructionFee() {
        return constructionFee;
    }

    public void setConstructionFee(int constructionFee) {
        this.constructionFee = constructionFee;
    }

    public int getPrintPrice() {
        return printPrice;
    }

    public void setPrintPrice(int printPrice) {
        this.printPrice = printPrice;
    }

    public int getyPrice() {
        return yPrice;
    }

    public void setyPrice(int yPrice) {
        this.yPrice = yPrice;
    }

    public int getChildPrintPrice() {
        return childPrintPrice;
    }

    public void setChildPrintPrice(int childPrintPrice) {
        this.childPrintPrice = childPrintPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getPolicyType() {
        return policyType;
    }

    public void setPolicyType(int policyType) {
        this.policyType = policyType;
    }

    public long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(long policyId) {
        this.policyId = policyId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPreNum() {
        return contactPreNum;
    }

    public void setContactPreNum(String contactPreNum) {
        this.contactPreNum = contactPreNum;
    }

    public String getContactMob() {
        return contactMob;
    }

    public void setContactMob(String contactMob) {
        this.contactMob = contactMob;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(int invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getReceiverTitle() {
        return receiverTitle;
    }

    public void setReceiverTitle(String receiverTitle) {
        this.receiverTitle = receiverTitle;
    }

    public int getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(int receiverType) {
        this.receiverType = receiverType;
    }

    public String getTaxpayerId() {
        return taxpayerId;
    }

    public void setTaxpayerId(String taxpayerId) {
        this.taxpayerId = taxpayerId;
    }

    public String getSjr() {
        return sjr;
    }

    public void setSjr(String sjr) {
        this.sjr = sjr;
    }

    public String getSjrPhone() {
        return sjrPhone;
    }

    public void setSjrPhone(String sjrPhone) {
        this.sjrPhone = sjrPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getXcd() {
        return xcd;
    }

    public void setXcd(String xcd) {
        this.xcd = xcd;
    }

    public String getXcdMethod() {
        return xcdMethod;
    }

    public void setXcdMethod(String xcdMethod) {
        this.xcdMethod = xcdMethod;
    }

    public int getXcdPrice() {
        return xcdPrice;
    }

    public void setXcdPrice(int xcdPrice) {
        this.xcdPrice = xcdPrice;
    }

    public String getBxInvoice() {
        return bxInvoice;
    }

    public void setBxInvoice(String bxInvoice) {
        this.bxInvoice = bxInvoice;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public String getBookingTag() {
        return bookingTag;
    }

    public void setBookingTag(String bookingTag) {
        this.bookingTag = bookingTag;
    }

    public String getQt() {
        return qt;
    }

    public void setQt(String qt) {
        this.qt = qt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getClientSite() {
        return clientSite;
    }

    public void setClientSite(String clientSite) {
        this.clientSite = clientSite;
    }

    public FlightInfo getFlightInfo() {
        return flightInfo;
    }

    public void setFlightInfo(FlightInfo flightInfo) {
        this.flightInfo = flightInfo;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}
