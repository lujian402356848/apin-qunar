package com.apin.qunar.basic.service;


import com.apin.qunar.basic.dao.model.Country;

public interface CountryService {
    Country queryByName(String countryName);

    Country queryLikeByName(String countryName);
}