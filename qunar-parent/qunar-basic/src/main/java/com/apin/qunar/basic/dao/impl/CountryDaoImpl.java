package com.apin.qunar.basic.dao.impl;

import com.apin.qunar.basic.dao.mapper.CountryExtMapper;
import com.apin.qunar.basic.dao.mapper.CountryMapper;
import com.apin.qunar.basic.dao.model.Country;
import com.apin.qunar.basic.dao.model.CountryExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDaoImpl {

    @Autowired
    CountryMapper countryMapper;

    @Autowired
    CountryExtMapper countryExtMapper;

    public Country queryLikeByName(String name) {
        return countryExtMapper.queryLikeByName(name);
    }

    public Country queryByName(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        CountryExample example = new CountryExample();
        CountryExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(name);
        List<Country> countries = countryMapper.selectByExample(example);
        return CollectionUtils.isEmpty(countries) ? null : countries.get(0);
    }

    public List<String> queryNameByKeyword(String keyword){
        return countryExtMapper.queryNameByKeyword(keyword);
    }
}