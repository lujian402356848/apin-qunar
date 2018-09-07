package com.apin.qunar.basic.dao.model;

import java.io.Serializable;
import java.util.Date;

public class AirportSearch implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    private Long id;

    /**
     * 机场编号
     */
    private String airportCode;

    /**
     * 查询关键字
     */
    private String searchKeyword;

    /**
     * 插入时间
     */
    private Date insertTime;

    /**
     * @return 唯一标识
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id 唯一标识
     */
    public void setId(Long id) {
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

    /**
     * @return 插入时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime 插入时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
}