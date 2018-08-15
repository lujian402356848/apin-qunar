package com.apin.qunar.basic.dao.model;

import java.io.Serializable;

public class Airport implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 机场编号
     */
    private String airportCode;

    /**
     * 机场名称
     */
    private String airportName;

    /**
     * 机场全拼
     */
    private String completeSpell;

    /**
     * 机场短拼
     */
    private String shortSpell;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 国家编号
     */
    private String countryCode;

    /**
     * 国家名称
     */
    private String countryName;

    /**
     * 查询关键字
     */
    private String searchKeyword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 机场编号
     */
    public String getAirportCode() {
        return airportCode;
    }

    /**
     * @param airportCode 机场编号
     */
    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode == null ? null : airportCode.trim();
    }

    /**
     * @return 机场名称
     */
    public String getAirportName() {
        return airportName;
    }

    /**
     * @param airportName 机场名称
     */
    public void setAirportName(String airportName) {
        this.airportName = airportName == null ? null : airportName.trim();
    }

    /**
     * @return 机场全拼
     */
    public String getCompleteSpell() {
        return completeSpell;
    }

    /**
     * @param completeSpell 机场全拼
     */
    public void setCompleteSpell(String completeSpell) {
        this.completeSpell = completeSpell == null ? null : completeSpell.trim();
    }

    /**
     * @return 机场短拼
     */
    public String getShortSpell() {
        return shortSpell;
    }

    /**
     * @param shortSpell 机场短拼
     */
    public void setShortSpell(String shortSpell) {
        this.shortSpell = shortSpell == null ? null : shortSpell.trim();
    }

    /**
     * @return 城市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName 城市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * @return 国家编号
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode 国家编号
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    /**
     * @return 国家名称
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName 国家名称
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName == null ? null : countryName.trim();
    }

    /**
     * @return 查询关键字
     */
    public String getSearchKeyword() {
        return searchKeyword;
    }

    /**
     * @param searchKeyword 查询关键字
     */
    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword == null ? null : searchKeyword.trim();
    }
}