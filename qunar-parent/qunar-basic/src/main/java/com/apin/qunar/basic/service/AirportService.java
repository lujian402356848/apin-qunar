package com.apin.qunar.basic.service;

import com.apin.qunar.basic.dao.model.Airport;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-25 10:57
 */
public interface AirportService {
    List<Airport> queryByKeyword(String code);
}
