package com.apin.qunar.basic.service.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.basic.common.constant.SmsConstants;
import com.apin.qunar.basic.common.enums.AccountTypeEnum;
import com.apin.qunar.basic.common.enums.AuditStatusEnum;
import com.apin.qunar.basic.common.enums.SmsSendTypeEnum;
import com.apin.qunar.basic.dao.impl.MerchantDaoImpl;
import com.apin.qunar.basic.dao.impl.UserDaoImpl;
import com.apin.qunar.basic.dao.model.Merchant;
import com.apin.qunar.basic.dao.model.User;
import com.apin.qunar.basic.domain.merchant.MerchantVO;
import com.apin.qunar.basic.service.MerchantService;
import com.apin.qunar.basic.service.SmsService;
import com.apin.qunar.basic.service.UserService;
import com.apin.qunar.common.ids.IDGenerator;
import com.apin.qunar.common.utils.BeanUtil;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @outhor lujian
 * @create 2018-07-23 14:41
 */
@Slf4j
@Service
public class MerchantServiceImpl implements MerchantService {
    private Cache<String, Merchant> merchantCache = CacheBuilder.newBuilder().maximumSize(1000).build();
    private Cache<String, String> verifyCodeCache = CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(1,TimeUnit.MINUTES).build();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    private Date maxAuditTime = null;
    @Autowired
    private MerchantDaoImpl merchantDao;
    @Autowired
    private UserDaoImpl userDao;
    @Autowired
    private SmsService smsService;
    @Autowired
    private DataSourceTransactionManager transactionManager;
    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        loadAllData();
    }

    private void loadAllData() {
        log.info("开始初始化商户信息");
        List<Merchant> merchants = merchantDao.queryBy(AuditStatusEnum.Pass.getCode(), null);
        if (CollectionUtils.isEmpty(merchants)) {
            return;
        }
        for (Merchant merchant : merchants) {
            merchantCache.put(merchant.getMerchantNo(), merchant);
        }
        setMaxAuditTime(merchants);
        log.info("初始化商户信息完毕");
    }

    @Scheduled(initialDelay = 60 * 1000, fixedDelay = 60 * 1000)
    private void syncData() {
        List<Merchant> merchants = merchantDao.queryBy(AuditStatusEnum.Pass.getCode(), maxAuditTime);
        for (Merchant merchant : merchants) {
            merchantCache.put(merchant.getMerchantNo(), merchant);
            log.info("同步商户信息:{}", JSON.toJSON(merchant));
        }
        setMaxAuditTime(merchants);
    }

    private void setMaxAuditTime(List<Merchant> merchants) {
        if (CollectionUtils.isEmpty(merchants)) {
            return;
        }
        maxAuditTime = merchants.stream().filter(p -> p.getAuditTime() != null).max(Comparator.comparing(Merchant::getAuditTime)).get().getAuditTime();
        log.info("当前商户最大审核时间:{}", maxAuditTime);
    }

    @Override
    public List<MerchantVO> queryPageListBy(Integer offset, Integer limit) {
        List<Merchant> merchants = merchantDao.queryPageListBy(offset, limit);
        return BeanUtil.copyProperties(merchants, MerchantVO.class);
    }

    @Override
    public Merchant queryByMerchantNo(String merchantNo) {
        return merchantCache.getIfPresent(merchantNo);
    }

    @Override
    public Merchant queryByContactMobile(String contactMobile) {
        return merchantCache.getIfPresent(contactMobile);
    }

    @Override
    public boolean isExistContactMobile(String contactMobile) {
        return merchantDao.isExistContactMobile(contactMobile);
    }

    @Override
    public boolean audit(String contactMobile, String auditUser, AuditStatusEnum auditStatusEnum) {
        boolean result = false;
        if (StringUtils.isBlank(contactMobile) || StringUtils.isBlank(auditUser)) {
            return result;
        }
        Merchant merchant = merchantDao.queryByContactMobile(contactMobile);
        if (merchant == null) {
            return result;
        }
        merchant.setAuditUser(auditUser);
        merchant.setAuditStatus(auditStatusEnum.getCode());
        merchant.setAuditTime(new Date());
        try {
            result = merchantDao.update(merchant);
            if (result) {
                if (auditStatusEnum == AuditStatusEnum.Pass) {
                    userService.changePassword(merchant.getContactMobile(), "111");//初始用户密码111
                    sendSms(merchant, SmsSendTypeEnum.MERCHANT_AUDIT_PASS);
                } else {
                    sendSms(merchant, SmsSendTypeEnum.MERCHANT_AUDIT_NO_PASS);
                }
            }
        } catch (Exception e) {
            log.error("审核商户信息异常,merchantNo:{}", contactMobile, e);
        }
        return result;
    }

    @Override
    public boolean change(Merchant merchant) {
        boolean result = false;
        if (merchant == null) {
            return result;
        }
        Merchant oldMerchant = merchantDao.queryByMerchantNo(merchant.getMerchantNo());
        if (oldMerchant == null) {
            return result;
        }
        oldMerchant.setContactName(merchant.getContactName());
        oldMerchant.setContactMobile(merchant.getContactMobile());
        oldMerchant.setCompanyName(merchant.getCompanyName());
        oldMerchant.setCompanyAddress(merchant.getCompanyAddress());
        try {
            result = merchantDao.update(oldMerchant);
        } catch (Exception e) {
            log.error("更新商户信息异常,merchant:{}", JSON.toJSON(oldMerchant), e);
        }
        return result;
    }

    @Override
    public boolean register(Merchant merchant) {
        boolean result = false;
        if (merchant == null) {
            return result;
        }
        merchant.setMerchantNo(buildMerchantNo());
        merchant.setSecretKey(buildSecretKey());
        User user = buildUser(merchant);
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_SERIALIZABLE);
        TransactionStatus status = transactionManager.getTransaction(definition);//事务开始
        try {
            merchantDao.insert(merchant);
            userDao.insert(user);
            transactionManager.commit(status);//提交事务
            result = true;
            sendSms(merchant, SmsSendTypeEnum.MERCHANT_REGISTER);//发送注册短信
        } catch (Exception e) {
            transactionManager.rollback(status);//事务回滚
            log.error("注册商户信息异常,merchant:{}", JSON.toJSON(merchant), e);
        }
        return result;
    }

    @Override
    public boolean createVerifyCode(String contactMobile) {
        boolean result = false;
        try{
            Merchant merchant = new Merchant();
            merchant.setContactMobile(contactMobile);
            sendSms(merchant,SmsSendTypeEnum.MERCHANT_VERIFY_CODE);
            result = true;
        }catch (Exception e){
            log.error("短信验证码信息异常,merchantNo:{}",contactMobile,e);
        }
        return result;
    }

    @Override
    public boolean checkVerifyCode(String contactMobile, String verifyCode) {
        if (StringUtils.isBlank(contactMobile) || StringUtils.isBlank(verifyCode)) {
            return false;
        }
        return verifyCode.equals(verifyCodeCache.getIfPresent(contactMobile));
    }

    private String getVerifyCode(Merchant merchant) {
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);//生成短信验证码
        verifyCodeCache.put(merchant.getContactMobile(), verifyCode);
        return verifyCode;
    }

    private void sendSms(Merchant merchant, SmsSendTypeEnum smsSendTypeEnum) {
        switch (smsSendTypeEnum) {
            case MERCHANT_VERIFY_CODE:
                String verifyCode = getVerifyCode(merchant);
                String verifyCodeContent = String.format(SmsConstants.MERCHANT_VERIFY_CODE, verifyCode);
                smsService.sendSms(merchant.getContactMobile(), verifyCodeContent, SmsSendTypeEnum.MERCHANT_VERIFY_CODE);
                break;
            case MERCHANT_REGISTER:
                String registerContent = String.format(SmsConstants.MERCHANT_REGISTER, merchant.getContactName());
                smsService.sendSms(merchant.getContactMobile(), registerContent, SmsSendTypeEnum.MERCHANT_REGISTER);
                break;
            case MERCHANT_AUDIT_PASS:
                smsService.sendSms(merchant.getContactMobile(), SmsConstants.MERCHANT_AUDIT_PASS, SmsSendTypeEnum.MERCHANT_AUDIT_PASS);
                break;
            case MERCHANT_AUDIT_NO_PASS:
                smsService.sendSms(merchant.getContactMobile(), SmsConstants.MERCHANT_AUDIT_NO_PASS, SmsSendTypeEnum.MERCHANT_AUDIT_NO_PASS);
                break;
        }
    }

    private User buildUser(Merchant merchant) {
        User user = new User();
        user.setId(IDGenerator.getUniqueId());
        user.setAccount(merchant.getContactMobile());
        user.setPassword(buildPassword());
        user.setRealName(merchant.getContactName());
        user.setDepartment("商户");
        user.setAccountType(AccountTypeEnum.MERCHANT.getCode());
        user.setHasAdmin(0);
        user.setHasEnable(1);
        return user;
    }

    private String buildPassword() {
        final int keyLength = 16;
        final String sourceData = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < keyLength; i++) {
            int number = random.nextInt(sourceData.length());
            sb.append(sourceData.charAt(number));
        }
        return sb.toString();
    }

    private String buildMerchantNo() {
        String currDate = sdf.format(new Date());
        int random6Char = new Random().nextInt(899999) + 100000;
        return String.format("%s%s", currDate, random6Char);
    }

    /**
     * 生成32位随机秘钥字符串
     *
     * @return
     */
    private String buildSecretKey() {
        final int keyLength = 32;
        final String sourceData = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < keyLength; i++) {
            int number = random.nextInt(sourceData.length());
            sb.append(sourceData.charAt(number));
        }
        return sb.toString();
    }
}
