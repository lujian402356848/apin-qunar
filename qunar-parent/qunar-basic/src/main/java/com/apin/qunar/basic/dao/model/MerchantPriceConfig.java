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
     * 国内加价比例
     */
    private Double nationalPriceRatio;

    /**
     * 国际加价比例
     */
    private Double internationalPriceRatio;

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
     * @return 国内加价比例
     */
    public Double getNationalPriceRatio() {
        return nationalPriceRatio;
    }

    /**
     * @param nationalPriceRatio 国内加价比例
     */
    public void setNationalPriceRatio(Double nationalPriceRatio) {
        this.nationalPriceRatio = nationalPriceRatio;
    }

    /**
     * @return 国际加价比例
     */
    public Double getInternationalPriceRatio() {
        return internationalPriceRatio;
    }

    /**
     * @param internationalPriceRatio 国际加价比例
     */
    public void setInternationalPriceRatio(Double internationalPriceRatio) {
        this.internationalPriceRatio = internationalPriceRatio;
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