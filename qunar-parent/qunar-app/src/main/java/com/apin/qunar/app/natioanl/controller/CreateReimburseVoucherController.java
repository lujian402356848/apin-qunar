package com.apin.qunar.app.natioanl.controller;


import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.CreateReimburseVoucherRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.common.enums.DistributionTypeEnum;
import com.apin.qunar.order.domain.national.createReimburseVoucher.CreateReimburseVoucherBO;
import com.apin.qunar.order.service.national.CreateReimburseVoucherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @outhor ligang
 * @create 2018-08-20 16:24
 * 创建订单
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class CreateReimburseVoucherController extends BaseController {

    @Autowired
    private CreateReimburseVoucherService createReimburseVoucherService;

    @PostMapping(value = "/reimburseVoucher/create")
    public GeneralResultMap createReimburseVoucher(@RequestBody @Valid CreateReimburseVoucherRequest request, BindingResult bindingResult) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/reimburseVoucher/create接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        boolean result = createReimburseVoucherService.CreateReimburseVoucher(buildNationalReimburseVoucher(request));
        if (result) {
            generalResultMap.setResult(SysReturnCode.SUCC);
        } else {
            generalResultMap.setResult(SysReturnCode.FAIL);
        }
        return generalResultMap;
    }


    private CreateReimburseVoucherBO buildNationalReimburseVoucher(final CreateReimburseVoucherRequest request) {
        CreateReimburseVoucherBO createReimburseVoucherBO = new CreateReimburseVoucherBO();
        createReimburseVoucherBO.setMerchantNo(request.getMerchantNo());
        createReimburseVoucherBO.setOrderNo(request.getOrderNo());
        createReimburseVoucherBO.setDeptCity(request.getDeptCity());
        createReimburseVoucherBO.setArriCity(request.getArriCity());
        createReimburseVoucherBO.setFlightNum(request.getFlightNum());
        createReimburseVoucherBO.setDeptDate(request.getDeptDate());
        createReimburseVoucherBO.setReimburseType(request.getReimburseType());//报销单类型
        createReimburseVoucherBO.setDistributionType(DistributionTypeEnum.EXPRESS.code);//配送方式,现在默认为快递
        createReimburseVoucherBO.setDistributionAmount(0);// 配送金额,现在免费
        createReimburseVoucherBO.setInvoiceTitleType(request.getInvoiceTitleType());//发票抬头类型
        createReimburseVoucherBO.setInvoiceTitleContent(request.getInvoiceTitleContent());//发票抬头内容
        createReimburseVoucherBO.setTaxpayerNo(request.getTaxpayerNo());//纳税人编号
        createReimburseVoucherBO.setReceiverName(request.getReceiverName());//收件人姓名
        createReimburseVoucherBO.setReceiverMobileNo(request.getReceiverMobileNo());//收件电话
        createReimburseVoucherBO.setReceiveAddress(request.getReceiveAddress());//收件地址
        return createReimburseVoucherBO;
    }

}
