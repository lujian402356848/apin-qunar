package com.apin.qunar.app.account.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.account.domain.withdrawRecord.WithdrawRecordVO;
import com.apin.qunar.account.service.withdrawRecord.WithdrawRecordService;
import com.apin.qunar.app.account.request.WithdrawRecordRequest;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.common.enums.SysReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @outhor wubo
 * @create 2018-09-05 20:58
 * 提现
 */
@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class WithdrawRecordController {
    @Autowired
    private WithdrawRecordService withdrawRecordService;

    @PostMapping("/withdrawRecord/list")
    public GeneralResultMap searchWithdrawRecordList(@RequestBody WithdrawRecordRequest request) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        if (!generalResultMap.isSuccess()) {
            log.warn("/withdrawRecord/list接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        Map<String, Object> data = new HashMap<>();
        if (request.getOffset() == null || request.getOffset() <= 0) {
            request.setOffset(0);
        }
        if (request.getLimit() == null || request.getLimit() <= 0) {
            request.setLimit(20);
        }
        try {
            List<WithdrawRecordVO> withdrawRecordList = withdrawRecordService.queryWithdrawRecordListBy(request.getMerchantNo(), request.getAccount(), request.getOffset(), request.getLimit());
            data.put("list", withdrawRecordList);
            generalResultMap.setData(data);
            generalResultMap.setResult(SysReturnCode.SUCC);
        } catch (Exception e) {
            log.error("查询账户充值记录异常,request{}", request, e);
        }
        return generalResultMap;
    }
}
