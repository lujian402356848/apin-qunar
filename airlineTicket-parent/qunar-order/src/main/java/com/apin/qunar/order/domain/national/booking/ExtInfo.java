package com.apin.qunar.order.domain.national.booking;

import java.io.Serializable;

/**
 * Created by stanley on 15-12-1 At 11:45
 */
public class ExtInfo implements Serializable {
    private static final long serialVersionUID = -4008494228987009678L;
    private String from = "";
    private String to = "";
    private String tag = "";
    private String startTime = "";
    private String deptTime = "";
    private String ticketPirce = "";
    private String bookingTime = "";
    private String carrier = "";
    private String flightNum = "";
    private String cabin = "";
    private String flightType = "";
    private String price = "";
    private String basePrice = "";
    private String barePrice = "";
    private String qt = "";
    private String policyId = "";
    private String policyType = "";
    private String clientId = "";
    private String wrapperId = "";

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDeptTime() {
        return deptTime;
    }

    public void setDeptTime(String deptTime) {
        this.deptTime = deptTime;
    }

    public String getTicketPirce() {
        return ticketPirce;
    }

    public void setTicketPirce(String ticketPirce) {
        this.ticketPirce = ticketPirce;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public String getBarePrice() {
        return barePrice;
    }

    public void setBarePrice(String barePrice) {
        this.barePrice = barePrice;
    }

    public String getQt() {
        return qt;
    }

    public void setQt(String qt) {
        this.qt = qt;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getWrapperId() {
        return wrapperId;
    }

    public void setWrapperId(String wrapperId) {
        this.wrapperId = wrapperId;
    }

    @Override
    public String toString() {
        return "ExtInfo{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", tag='" + tag + '\'' +
                ", startTime='" + startTime + '\'' +
                ", deptTime='" + deptTime + '\'' +
                ", ticketPirce='" + ticketPirce + '\'' +
                ", bookingTime='" + bookingTime + '\'' +
                ", carrier='" + carrier + '\'' +
                ", flightNum='" + flightNum + '\'' +
                ", cabin='" + cabin + '\'' +
                ", flightType='" + flightType + '\'' +
                ", price='" + price + '\'' +
                ", basePrice='" + basePrice + '\'' +
                ", barePrice='" + barePrice + '\'' +
                ", qt='" + qt + '\'' +
                ", policyId='" + policyId + '\'' +
                ", policyType='" + policyType + '\'' +
                ", clientId='" + clientId + '\'' +
                ", wrapperId='" + wrapperId + '\'' +
                '}';
    }
}
