package com.apin.qunar.order.domain.national.searchFlight;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-25 7:04
 */
public class SearchFlightParam {
    private String dpt;
    private String arr;
    private String date;
    private String ex_track;
    /**
     * 二次过滤的时间段.
     */
    private List<List<String>> takeoffTime;

    /**
     * 起飞机场
     */
    private String takeoffAirport;

    /**
     * 航空公司.
     */
    private String airlineCompany;

    /**
     * 航位.
     */
    private String flightPosition;

    public String getTakeoffAirport() {
        return takeoffAirport;
    }

    public void setTakeoffAirport(String takeoffAirport) {
        this.takeoffAirport = takeoffAirport;
    }

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public String getFlightPosition() {
        return flightPosition;
    }

    public void setFlightPosition(String flightPosition) {
        this.flightPosition = flightPosition;
    }

    public List<List<String>> getTakeoffTime() {
        return takeoffTime;
    }

    public void setTakeoffTime(List<List<String>> takeoffTime) {
        this.takeoffTime = takeoffTime;
    }

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    public String getArr() {
        return arr;
    }

    public void setArr(String arr) {
        this.arr = arr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEx_track() {
        return ex_track;
    }

    public void setEx_track(String ex_track) {
        this.ex_track = ex_track;
    }
}
