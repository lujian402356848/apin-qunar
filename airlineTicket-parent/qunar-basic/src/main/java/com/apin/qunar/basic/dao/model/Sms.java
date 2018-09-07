package com.apin.qunar.basic.dao.model;

import java.io.Serializable;
import java.util.Date;

public class Sms implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    private Long id;

    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 短信类型
     */
    private Integer smsType;

    /**
     * 短信内容
     */
    private String sendContent;

    /**
     * 发送时间
     */
    private Date sendTime;

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
     * @return 短信类型
     */
    public Integer getSmsType() {
        return smsType;
    }

    /**
     * @param smsType 短信类型
     */
    public void setSmsType(Integer smsType) {
        this.smsType = smsType;
    }

    /**
     * @return 短信内容
     */
    public String getSendContent() {
        return sendContent;
    }

    /**
     * @param sendContent 短信内容
     */
    public void setSendContent(String sendContent) {
        this.sendContent = sendContent == null ? null : sendContent.trim();
    }

    /**
     * @return 发送时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * @param sendTime 发送时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}