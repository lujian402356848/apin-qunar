package com.apin.qunar.basic.dao.model;

import java.io.Serializable;

public class Country implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 国家二字码
     */
    private String code;

    /**
     * 国家名称
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 国家二字码
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code 国家二字码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return 国家名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 国家名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}