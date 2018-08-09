package com.apin.qunar.basic.dao.impl;

import com.apin.qunar.basic.dao.mapper.AirlinePriceRateMapper;
import com.apin.qunar.basic.dao.model.AirlinePriceRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirlinePriceRateDaoImpl {
    @Autowired
    private AirlinePriceRateMapper airlinePriceRateMapper;

    public List<AirlinePriceRate> queryAll() {
        return airlinePriceRateMapper.selectByExample(null);
    }
}
