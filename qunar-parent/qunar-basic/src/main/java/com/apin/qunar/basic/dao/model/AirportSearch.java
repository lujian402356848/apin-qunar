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
     * 机场id
     */
    private Integer airportId;

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
     * @return 机场id
     */
    public Integer getAirportId() {
        return airportId;
    }

    /**
     * @param airportId 机场id
     */
    public void setAirportId(Integer airportId) {
        this.airportId = airportId;
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