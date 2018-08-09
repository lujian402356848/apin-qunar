package com.apin.qunar.basic.service.impl;


import com.alibaba.fastjson.JSON;
import com.apin.qunar.basic.common.config.SmsConfig;
import com.apin.qunar.basic.common.enums.SmsSendTypeEnum;
import com.apin.qunar.basic.dao.impl.SmsDaoImpl;
import com.apin.qunar.basic.dao.model.Sms;
import com.apin.qunar.basic.service.SmsService;
import com.apin.qunar.common.ids.IDGenerator;
import com.apin.qunar.common.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @outhor lujian
 * @create 2018-07-27 16:59
 */
@Slf4j
@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private SmsConfig smsConfig;
    @Autowired
    private SmsDaoImpl smsDao;

    @Override
    public boolean sendSms(String mobileNo, String content, SmsSendTypeEnum smsSendTypeEnum) {
        boolean result = false;
        if (StringUtils.isBlank(mobileNo)) {
            log.error("手机号不能为空");
            return result;
        }
        if (StringUtils.isBlank(content)) {
            log.error("短信内容不能为空");
            return result;
        }
        Sms sms = buildSms(mobileNo, content, smsSendTypeEnum);
        try {
            smsDao.insert(sms);
            result = send(sms);
        } catch (Exception e) {
            log.error("发送短信异常,sms:{}", JSON.toJSON(sms), e);
        }
        return result;
    }

    private Sms buildSms(String mobileNo, String content, SmsSendTypeEnum smsSendTypeEnum) {
        Sms sms = new Sms();
        sms.setId(IDGenerator.getUniqueId());
        sms.setMobileNo(mobileNo);
        sms.setSendContent(content);
        sms.setSmsType(smsSendTypeEnum.getCode());
        sms.setSendTime(new Date());
        return sms;
    }

    private boolean send(Sms sms) {
        boolean result = false;
        if (smsConfig.getEnable() == 0) {
            return result;
        }
        StringBuilder send = new StringBuilder(200);
        final String codingType = "UTF-8";
        try {
            send.append("action=send");
            send.append("&userid=").append(smsConfig.getUserId());
            send.append("&account=").append(URLEncoder.encode(smsConfig.getAccount(), codingType));
            send.append("&password=").append(URLEncoder.encode(smsConfig.getPassword(), codingType));
            send.append("&mobile=").append(sms.getMobileNo());
            send.append("&content=").append(URLEncoder.encode(sms.getSendContent(), codingType));
            String xmlResult = HttpClientUtil.doGet(smsConfig.getUrl() + "?" + send.toString());
            result = readXml(xmlResult);
        } catch (Exception e) {
            log.error("短信发送失败", e);
        }
        return result;
    }

    private boolean readXml(String xml) {
        if (StringUtils.isBlank(xml)) {
            return false;
        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Element rootElement = null;
        NodeList message = null;
        String str = null;
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            StringReader sr = new StringReader(xml);
            InputSource is = new InputSource(sr);
            Document doc = builder.parse(is);
            rootElement = doc.getDocumentElement();
            message = rootElement.getElementsByTagName("returnstatus");
            str = message.item(0).getNodeValue();
        } catch (Exception e) {
            log.error("解析短信返回的xml异常,xml:{}", xml, e);
        }
        return true;
    }
}
