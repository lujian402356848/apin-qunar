package com.apin.qunar.basic.dao.impl;

import com.apin.qunar.basic.dao.mapper.SmsMapper;
import com.apin.qunar.basic.dao.model.Sms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @outhor lujian
 * @create 2018-07-27 16:57
 */
@Repository
public class SmsDaoImpl {
    @Autowired
    private SmsMapper smsMapper;

    public boolean insert(Sms sms) {
        return smsMapper.insert(sms) > 0;
    }
}