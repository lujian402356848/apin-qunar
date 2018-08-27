package com.apin.qunar.order.service.national;

import com.apin.qunar.order.dao.model.NationalReimburseVoucher;

import java.util.List;

/**
 * @outhor ligang
 * @create 2018-08-20 13:47
 */
public interface SearchReimburseVoucherListService {
    List<NationalReimburseVoucher> queryPageList(String merchantNo, String orderNo, Integer offset, Integer limit);

    Integer queryPage(String merchantNo, String orderNo);
}