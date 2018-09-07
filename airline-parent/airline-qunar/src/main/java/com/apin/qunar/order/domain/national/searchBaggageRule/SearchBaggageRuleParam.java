package com.apin.qunar.order.domain.national.searchBaggageRule;

public class SearchBaggageRuleParam {
    private String airlineCode;
    private String cabin;
    private String depCode;
    private String arrCode;
    private String saleDate;
    private String depDate;

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getArrCode() {
        return arrCode;
    }

    public void setArrCode(String arrCode) {
        this.arrCode = arrCode;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getDepDate() {
        return depDate;
    }

    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }
}
