package com.apin.qunar.basic.dao.impl;

import com.apin.qunar.basic.dao.mapper.AirportExtMapper;
import com.apin.qunar.basic.dao.mapper.AirportMapper;
import com.apin.qunar.basic.dao.model.Airport;
import com.apin.qunar.basic.dao.model.AirportExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-25 11:24
 */
@Repository
public class AirportDaoImpl {
    @Autowired
    private AirportMapper airportMapper;
    @Autowired
    private AirportExtMapper airportExtMapper;

    public List<Airport> queryByName(String name) {
        return airportExtMapper.queryByName(name);
    }

    public List<Airport> queryAll() {
        return airportMapper.selectByExample(null);
    }

    public List<Airport> queryBy(Date insertTime) {
        AirportExample example = new AirportExample();
        AirportExample.Criteria criteria = example.createCriteria();
        if (insertTime != null) {
            criteria.andInsertTimeGreaterThan(insertTime);
        }
        return airportMapper.selectByExample(example);
    }
}
