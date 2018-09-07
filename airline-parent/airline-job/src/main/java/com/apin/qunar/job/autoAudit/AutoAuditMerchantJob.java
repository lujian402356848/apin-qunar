package com.apin.qunar.job.autoAudit;

import com.apin.qunar.basic.common.enums.AuditStatusEnum;
import com.apin.qunar.basic.dao.impl.MerchantDaoImpl;
import com.apin.qunar.basic.dao.model.Merchant;
import com.apin.qunar.basic.service.MerchantService;
import com.apin.qunar.common.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class AutoAuditMerchantJob {
    @Autowired
    private MerchantDaoImpl merchantDao;
    @Autowired
    private MerchantService merchantService;

    /**
     * 商户统计job启动
     */
    @Scheduled(cron = "0/20 * * * * ?")
    private void start() {
        log.error("商户自动审核job开始执行,时间:" + DateUtil.getCurrDate());
        try {
            audit();
        } catch (Exception e) {
            log.error("商户自动审核job执行失败", e);
        }
    }

    private void audit() {
        List<Merchant> merchants = merchantDao.queryBy(AuditStatusEnum.AWAITAUDIT.getCode(), null);
        if (CollectionUtils.isEmpty(merchants)) {
            return;
        }
        for (Merchant merchant : merchants) {
            merchantService.audit(merchant.getContactMobile(), "system", AuditStatusEnum.Pass);
            log.info("商户【{}】自动审核通过,BD:【{}】", merchant.getCompanyName(), merchant.getManagerName());
        }
    }
}