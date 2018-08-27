package com.apin.qunar.basic.service;

import com.apin.qunar.basic.common.enums.AuditStatusEnum;
import com.apin.qunar.basic.dao.model.Merchant;
import com.apin.qunar.basic.domain.merchant.MerchantVO;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-23 14:41
 */
public interface MerchantService {

    List<MerchantVO> queryPageListBy(Integer offset, Integer limit);

    Merchant queryByMerchantNo(String merchantNo);

    List<MerchantVO> querySubordinateMerchant(String contactMobile);

    Merchant queryByContactMobile(String contactMobile);

    boolean isExistContactMobile(String contactMobile);

    boolean audit(String contactMobile, String auditUser, AuditStatusEnum auditStatusEnum);

    boolean change(Merchant merchant);

    boolean register(Merchant merchant);

    boolean createVerifyCode(String contactMobile);

    boolean checkVerifyCode(String contactMobile, String verifyCode);
}
