package com.apin.qunar.basic.dao.impl;

import com.apin.qunar.basic.dao.mapper.AirportSearchExtMapper;
import com.apin.qunar.basic.dao.mapper.AirportSearchMapper;
import com.apin.qunar.basic.dao.model.AirportSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirportSearchDaoImpl {
    @Autowired
    private AirportSearchMapper airportSearchMapper;
    @Autowired
    private AirportSearchExtMapper airportSearchExtMapper;

    public List<String> queryAirportCodeByKeyword(String keyword) {
        return airportSearchExtMapper.queryAirportCodeByKeyword(keyword);
    }

    public boolean insert(AirportSearch airportSearch) {
        return airportSearchMapper.insert(airportSearch) > 0;
    }
}
