package com.apin.qunar.basic.dao.model;

import java.io.Serializable;
import java.util.Date;

public class MerchantPriceConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    private Long id;

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 国内加价价格
     */
    private Integer nationalAddPrice;

    /**
     * 国际加价价格
     */
    private Integer internationalAddPrice;

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
     * @return 商户号
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * @param merchantNo 商户号
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * @return 国内加价价格
     */
    public Integer getNationalAddPrice() {
        return nationalAddPrice;
    }

    /**
     * @param nationalAddPrice 国内加价价格
     */
    public void setNationalAddPrice(Integer nationalAddPrice) {
        this.nationalAddPrice = nationalAddPrice;
    }

    /**
     * @return 国际加价价格
     */
    public Integer getInternationalAddPrice() {
        return internationalAddPrice;
    }

    /**
     * @param internationalAddPrice 国际加价价格
     */
    public void setInternationalAddPrice(Integer internationalAddPrice) {
        this.internationalAddPrice = internationalAddPrice;
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