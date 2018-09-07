package com.apin.qunar.basic.dao.impl;

import com.apin.qunar.basic.dao.mapper.AirlineExtMapper;
import com.apin.qunar.basic.dao.mapper.AirlineMapper;
import com.apin.qunar.basic.dao.model.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirlineDaoImpl {

    @Autowired
    AirlineMapper airlineMapper;
    @Autowired
    AirlineExtMapper airlineExtMapper;

    public Airline queryByCode(String code) {
        return airlineExtMapper.queryByCode(code);
    }

    public List<Airline> queryAll() {
        return airlineMapper.selectByExample(null);
    }
}
