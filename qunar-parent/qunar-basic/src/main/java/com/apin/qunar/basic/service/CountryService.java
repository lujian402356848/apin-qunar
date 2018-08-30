package com.apin.qunar.basic.service;


import com.apin.qunar.basic.dao.model.Country;

import java.util.List;

public interface CountryService {
    Country queryLikeByName(String countryName);

    List<String> queryNameByKeyword(String code);
}