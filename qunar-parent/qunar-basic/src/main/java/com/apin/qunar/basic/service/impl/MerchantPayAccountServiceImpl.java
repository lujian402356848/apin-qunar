package com.apin.qunar.basic.service.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.basic.dao.impl.MerchantPayAccountDaoImpl;
import com.apin.qunar.basic.dao.model.MerchantPayAccount;
import com.apin.qunar.basic.service.MerchantPayAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-25 18:56
 */
@Slf4j
@Service
public class MerchantPayAccountServiceImpl implements MerchantPayAccountService {

    @Autowired
    private MerchantPayAccountDaoImpl merchantPayAccountDao;

    @Override
    public List<MerchantPayAccount> queryByMerchantNo(String merchantNo) {
        return merchantPayAccountDao.queryByMerchantNo(merchantNo);
    }

    @Override
    public String getSignContainLike(String merchantNO, String signAccount) {
        return "";
    }


    @Override
    public boolean register(MerchantPayAccount merchantPayAccount) {
        boolean result = false;
        try {
            result = merchantPayAccountDao.insert(merchantPayAccount);
        } catch (Exception e) {
            log.error("注册商户信息异常,merchant:{}", JSON.toJSON(merchantPayAccount), e);
        }
        return result;
    }

    @Override
    public boolean setPayPassword(String merchantNo, String account, String password) {
        boolean result = false;
        MerchantPayAccount merchantPayAccount = merchantPayAccountDao.queryByMerchantNoAndAccount(merchantNo, account);
        if (merchantPayAccount == null) {
            return result;
        }
        if (merchantPayAccount.getAuthPassword().equalsIgnoreCase(password)) {
            log.warn("更新后的密码和更新前的密码相同");
            return result;
        }
        merchantPayAccount.setAuthPassword(password);
        try {
            result = merchantPayAccountDao.update(merchantPayAccount);
        } catch (Exception e) {
            log.error("更新账户密码失败:merchantNo:{},account:{}", merchantNo, account, e);
        }
        return result;
    }

    @Override
    public boolean removePayAccount(String merchantNo, String payAccount) {
        return merchantPayAccountDao.deleteBy(merchantNo, payAccount);
    }
}
