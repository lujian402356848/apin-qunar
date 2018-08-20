package com.apin.qunar.basic.dao.model;

import java.io.Serializable;
import java.util.Date;

public class Area implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    private Long id;

    /**
     * 市级id
     */
    private Long cityId;

    /**
     * 区级名称
     */
    private String name;

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
     * @return 市级id
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * @param cityId 市级id
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * @return 区级名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 区级名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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