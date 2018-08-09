package com.apin.qunar.basic.dao.model;

import java.io.Serializable;
import java.util.Date;

public class AirlinePriceRate implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    private Long id;

    /**
     * 航司二字码
     */
    private String code;

    /**
     * 航司中文名称
     */
    private String name;

    /**
     * 仓位
     */
    private String position;

    /**
     * 折扣
     */
    private Integer priceRate;

    /**
     * 插入时间
     */
    private Date insertTime;

    /**
     * 修改时间
     */
    private Date updateTime;

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
     * @return 航司二字码
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code 航司二字码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return 航司中文名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 航司中文名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return 仓位
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position 仓位
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * @return 折扣
     */
    public Integer getPriceRate() {
        return priceRate;
    }

    /**
     * @param priceRate 折扣
     */
    public void setPriceRate(Integer priceRate) {
        this.priceRate = priceRate;
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

    /**
     * @return 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}