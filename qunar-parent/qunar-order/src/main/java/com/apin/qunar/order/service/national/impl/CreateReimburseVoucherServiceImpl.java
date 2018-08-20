package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.common.ids.IDGenerator;
import com.apin.qunar.order.dao.impl.ReimburseVoucherDaoImpl;
import com.apin.qunar.order.dao.model.NationalReimburseVoucher;
import com.apin.qunar.order.domain.national.createReimburseVoucher.CreateReimburseVoucherBO;
import com.apin.qunar.order.service.national.CreateReimburseVoucherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangliang.wang on 2018/6/8.
 */
@Slf4j
@Service
public class CreateReimburseVoucherServiceImpl implements CreateReimburseVoucherService {

    @Autowired
    private ReimburseVoucherDaoImpl reimburseVoucherDao;

    @Override
    public boolean CreateReimburseVoucher(final CreateReimburseVoucherBO createReimburseVoucherBO) {
        NationalReimburseVoucher nationalReimburseVoucher = buildNationalReimburseVoucher(createReimburseVoucherBO);
        return reimburseVoucherDao.insert(nationalReimburseVoucher);
    }


    private NationalReimburseVoucher buildNationalReimburseVoucher(final CreateReimburseVoucherBO createReimburseVoucherBO) {
        NationalReimburseVoucher nationalReimburseVoucher = new NationalReimburseVoucher();
        nationalReimburseVoucher.setId(IDGenerator.getUniqueId());
        nationalReimburseVoucher.setMerchantNo(createReimburseVoucherBO.getMerchantNo());
        nationalReimburseVoucher.setOrderNo(createReimburseVoucherBO.getOrderNo());
        nationalReimburseVoucher.setDeptCity(createReimburseVoucherBO.getDeptCity());
        nationalReimburseVoucher.setArriCity(createReimburseVoucherBO.getArriCity());
        nationalReimburseVoucher.setFlightNum(createReimburseVoucherBO.getFlightNum());
        nationalReimburseVoucher.setDeptDate(createReimburseVoucherBO.getDeptDate());
        nationalReimburseVoucher.setReimburseType(createReimburseVoucherBO.getReimburseType());//报销单类型
        nationalReimburseVoucher.setDistributionType(createReimburseVoucherBO.getDistributionType());//配送方式,现在默认为快递
        nationalReimburseVoucher.setDistributionAmount(createReimburseVoucherBO.getDistributionAmount());// 配送金额(
        nationalReimburseVoucher.setInvoiceTitleType(createReimburseVoucherBO.getInvoiceTitleType());//发票抬头类型(1:企业,2:个人)
        nationalReimburseVoucher.setInvoiceTitleContent(createReimburseVoucherBO.getInvoiceTitleContent());//发票抬头内容
        nationalReimburseVoucher.setTaxpayerNo(createReimburseVoucherBO.getTaxpayerNo());//纳税人编号
        nationalReimburseVoucher.setReceiverName(createReimburseVoucherBO.getReceiverName());//收件人姓名
        nationalReimburseVoucher.setReceiverMobileNo(createReimburseVoucherBO.getReceiverMobileNo());//收件电话
        nationalReimburseVoucher.setReceiveAddress(createReimburseVoucherBO.getReceiveAddress());//收件地址
        return nationalReimburseVoucher;
    }

}