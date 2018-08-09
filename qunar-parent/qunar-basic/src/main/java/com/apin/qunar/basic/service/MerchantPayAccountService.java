package com.apin.qunar.basic.service;

import com.apin.qunar.basic.dao.model.MerchantPayAccount;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-25 18:55
 */
public interface MerchantPayAccountService {
    List<MerchantPayAccount> queryByMerchantNo(String merchantNo);

    String getSignContainLike(String merchantNO, String signAccount);

    boolean register(MerchantPayAccount merchantPayAccount);

    boolean setPayPassword(String merchantNo, String account, String password);

    boolean removePayAccount(String merchantNo, String payAccount);
}
