package com.apin.qunar.basic.dao.model;

import java.io.Serializable;
import java.util.Date;

public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    private Long id;

    /**
     * 省级id
     */
    private Long provinceId;

    /**
     * 市级名称
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
     * @return 省级id
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * @param provinceId 省级id
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * @return 市级名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 市级名称
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