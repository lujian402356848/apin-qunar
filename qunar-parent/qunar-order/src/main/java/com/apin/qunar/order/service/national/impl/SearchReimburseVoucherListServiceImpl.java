package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.order.dao.impl.ReimburseVoucherDaoImpl;
import com.apin.qunar.order.dao.model.NationalReimburseVoucher;
import com.apin.qunar.order.service.national.SearchReimburseVoucherListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-20 18:59
 */
@Service
public class SearchReimburseVoucherListServiceImpl implements SearchReimburseVoucherListService {
    @Autowired
    private ReimburseVoucherDaoImpl reimburseVoucherDao;

    @Override
    public List<NationalReimburseVoucher> queryPageList(final String merchantNo, final String orderNo, final Integer offset, final Integer limit) {
        List<NationalReimburseVoucher> nationalReimburseVouchers = reimburseVoucherDao.queryPageList(merchantNo, orderNo, offset, limit);
        return nationalReimburseVouchers;
    }

    @Override
    public Integer queryPage(final String merchantNo, final String orderNo) {
        return reimburseVoucherDao.queryPage(merchantNo, orderNo);
    }
}