package com.apin.qunar.basic.dao.model;

import java.io.Serializable;

public class Airline implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 航空公司编号
     */
    private String code;

    /**
     * 航空公司名称
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 航空公司编号
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code 航空公司编号
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return 航空公司名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 航空公司名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}