package com.apin.qunar.basic.dao.impl;


import com.apin.qunar.basic.dao.mapper.CityMapper;
import com.apin.qunar.basic.dao.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityDaoImpl {
    @Autowired
    private CityMapper cityMapper;

    public List<City> queryAll() {
        return cityMapper.selectByExample(null);
    }

}
