package com.apin.qunar.order.dao.model;

import java.io.Serializable;
import java.util.Date;

public class InternationalRegularPassenger implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 乘客姓名
     */
    private String name;

    /**
     * 乘客类型（0：成人，1：儿童）
     */
    private Integer ageType;

    /**
     * 证件类型
     */
    private String cardType;

    /**
     * 证件号
     */
    private String cardNo;

    /**
     * 发行国家二字码
     */
    private String cardIssueplace;

    /**
     * 证件有效期
     */
    private String cardExpired;

    /**
     * 乘客国籍
     */
    private String nationality;

    /**
     * 性别(0:男,1:女)
     */
    private Integer gender;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 插入时间
     */
    private Date insertTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 乘客姓名
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 乘客姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return 乘客类型（0：成人，1：儿童）
     */
    public Integer getAgeType() {
        return ageType;
    }

    /**
     * @param ageType 乘客类型（0：成人，1：儿童）
     */
    public void setAgeType(Integer ageType) {
        this.ageType = ageType;
    }

    /**
     * @return 证件类型
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * @param cardType 证件类型
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    /**
     * @return 证件号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * @param cardNo 证件号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * @return 发行国家二字码
     */
    public String getCardIssueplace() {
        return cardIssueplace;
    }

    /**
     * @param cardIssueplace 发行国家二字码
     */
    public void setCardIssueplace(String cardIssueplace) {
        this.cardIssueplace = cardIssueplace == null ? null : cardIssueplace.trim();
    }

    /**
     * @return 证件有效期
     */
    public String getCardExpired() {
        return cardExpired;
    }

    /**
     * @param cardExpired 证件有效期
     */
    public void setCardExpired(String cardExpired) {
        this.cardExpired = cardExpired == null ? null : cardExpired.trim();
    }

    /**
     * @return 乘客国籍
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality 乘客国籍
     */
    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    /**
     * @return 性别(0:男,1:女)
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * @param gender 性别(0:男,1:女)
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * @return 出生日期
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday 出生日期
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * @return 手机号
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * @param mobileNo 手机号
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    /**
     * @return 操作人
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator 操作人
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
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