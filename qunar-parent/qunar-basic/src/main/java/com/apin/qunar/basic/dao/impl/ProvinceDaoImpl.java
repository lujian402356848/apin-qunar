package com.apin.qunar.basic.dao.impl;


import com.apin.qunar.basic.dao.mapper.ProvinceMapper;
import com.apin.qunar.basic.dao.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProvinceDaoImpl {
    @Autowired
    private ProvinceMapper provinceMapper;

    public List<Province> queryAll() {
        return provinceMapper.selectByExample(null);
    }

}
