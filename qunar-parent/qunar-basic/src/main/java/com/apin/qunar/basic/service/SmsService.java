package com.apin.qunar.basic.service;

import com.apin.qunar.basic.common.enums.SmsSendTypeEnum;

/**
 * @outhor lujian
 * @create 2018-07-27 16:58
 */
public interface SmsService {
    boolean sendSms(String mobileNo, String content, SmsSendTypeEnum smsSendTypeEnum);
}