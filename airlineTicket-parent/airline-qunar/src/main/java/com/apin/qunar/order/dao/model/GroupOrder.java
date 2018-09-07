package com.apin.qunar.order.dao.model;

import java.io.Serializable;
import java.util.Date;

public class GroupOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    private Long id;

    /**
     * 拼团单号
     */
    private String groupNo;

    /**
     * 出发城市
     */
    private String deptCity;

    /**
     * 目的城市
     */
    private String arriCity;

    /**
     * 出发时间
     */
    private String deptDate;

    /**
     * 拼团人数
     */
    private Integer peopleCount;

    /**
     * 拼团状态（0：拼团失败，1：拼团成功，2：拼团失败）
     */
    private Integer groupStatus;

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
     * @return 拼团单号
     */
    public String getGroupNo() {
        return groupNo;
    }

    /**
     * @param groupNo 拼团单号
     */
    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo == null ? null : groupNo.trim();
    }

    /**
     * @return 出发城市
     */
    public String getDeptCity() {
        return deptCity;
    }

    /**
     * @param deptCity 出发城市
     */
    public void setDeptCity(String deptCity) {
        this.deptCity = deptCity == null ? null : deptCity.trim();
    }

    /**
     * @return 目的城市
     */
    public String getArriCity() {
        return arriCity;
    }

    /**
     * @param arriCity 目的城市
     */
    public void setArriCity(String arriCity) {
        this.arriCity = arriCity == null ? null : arriCity.trim();
    }

    /**
     * @return 出发时间
     */
    public String getDeptDate() {
        return deptDate;
    }

    /**
     * @param deptDate 出发时间
     */
    public void setDeptDate(String deptDate) {
        this.deptDate = deptDate == null ? null : deptDate.trim();
    }

    /**
     * @return 拼团人数
     */
    public Integer getPeopleCount() {
        return peopleCount;
    }

    /**
     * @param peopleCount 拼团人数
     */
    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    /**
     * @return 拼团状态（0：拼团失败，1：拼团成功，2：拼团失败）
     */
    public Integer getGroupStatus() {
        return groupStatus;
    }

    /**
     * @param groupStatus 拼团状态（0：拼团失败，1：拼团成功，2：拼团失败）
     */
    public void setGroupStatus(Integer groupStatus) {
        this.groupStatus = groupStatus;
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