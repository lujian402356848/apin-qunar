package com.apin.qunar.order.domain.national.createOrder;

/**
 * Created by wjjunjjun.wang on 2017/8/1.
 */
public class FlightInfo {

    private String flightNum;
    private int flightType;
    private int stopInfo;
    private String deptAirportCode;
    private String arriAirportCode;
    private String deptCity;
    private String arriCity;
    private String deptDate;
    private String deptTime;
    private String arriTime;
    private String cabin;
    private String childCabin;

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public int getFlightType() {
        return flightType;
    }

    public void setFlightType(int flightType) {
        this.flightType = flightType;
    }

    public int getStopInfo() {
        return stopInfo;
    }

    public void setStopInfo(int stopInfo) {
        this.stopInfo = stopInfo;
    }

    public String getDeptAirportCode() {
        return deptAirportCode;
    }

    public void setDeptAirportCode(String deptAirportCode) {
        this.deptAirportCode = deptAirportCode;
    }

    public String getArriAirportCode() {
        return arriAirportCode;
    }

    public void setArriAirportCode(String arriAirportCode) {
        this.arriAirportCode = arriAirportCode;
    }

    public String getDeptCity() {
        return deptCity;
    }

    public void setDeptCity(String deptCity) {
        this.deptCity = deptCity;
    }

    public String getArriCity() {
        return arriCity;
    }

    public void setArriCity(String arriCity) {
        this.arriCity = arriCity;
    }

    public String getDeptDate() {
        return deptDate;
    }

    public void setDeptDate(String deptDate) {
        this.deptDate = deptDate;
    }

    public String getDeptTime() {
        return deptTime;
    }

    public void setDeptTime(String deptTime) {
        this.deptTime = deptTime;
    }

    public String getArriTime() {
        return arriTime;
    }

    public void setArriTime(String arriTime) {
        this.arriTime = arriTime;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getChildCabin() {
        return childCabin;
    }

    public void setChildCabin(String childCabin) {
        this.childCabin = childCabin;
    }
}
