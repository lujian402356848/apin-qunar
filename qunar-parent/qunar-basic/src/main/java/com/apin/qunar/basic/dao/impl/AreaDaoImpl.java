package com.apin.qunar.basic.dao.impl;


import com.apin.qunar.basic.dao.mapper.AreaMapper;
import com.apin.qunar.basic.dao.model.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AreaDaoImpl {
    @Autowired
    private AreaMapper areaMapper;

    public List<Area> queryAll() {
        return areaMapper.selectByExample(null);
    }

}
