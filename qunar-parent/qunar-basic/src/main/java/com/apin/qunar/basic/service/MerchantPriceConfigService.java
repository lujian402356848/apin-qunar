package com.apin.qunar.basic.service;


/**
 * @outhor ligang
 * @create 2018-08-02 14:42
 */
public interface MerchantPriceConfigService {
    double queryPriceRatio(String merchantNo, boolean hasNational);
}
