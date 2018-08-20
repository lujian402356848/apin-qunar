package com.apin.qunar.order.dao.impl;

import com.apin.qunar.order.dao.mapper.NationalReimburseVoucherMapper;
import com.apin.qunar.order.dao.model.NationalReimburseVoucher;
import com.apin.qunar.order.dao.model.NationalReimburseVoucherExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @outhor ligang
 * @create 2018-08-16 21:47
 */
@Repository
public class ReimburseVoucherDaoImpl {
    @Autowired
    private NationalReimburseVoucherMapper nationalReimburseVoucherMapper;

    public boolean insert(NationalReimburseVoucher nationalReimburseVoucher) {
        return nationalReimburseVoucherMapper.insert(nationalReimburseVoucher) > 0;
    }


    public List<NationalReimburseVoucher> queryPageList(String merchantNo, String orderNo, Integer offset, Integer limit) {
        NationalReimburseVoucherExample example = new NationalReimburseVoucherExample();
        NationalReimburseVoucherExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        example.setMysqlOffset(offset);
        example.setMysqlLength(limit);
        return nationalReimburseVoucherMapper.selectByExample(example);
    }
}