package com.apin.qunar.basic.service;

import com.apin.qunar.basic.dao.model.AirlinePriceRate;

public interface AirlinePriceRateService {
    AirlinePriceRate queryByCode(String code, String position);
}
