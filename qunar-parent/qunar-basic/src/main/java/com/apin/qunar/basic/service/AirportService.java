package com.apin.qunar.basic.service;

import com.apin.qunar.basic.dao.model.Airport;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-25 10:57
 */
public interface AirportService {
    Airport queryByCode(String code);

    List<Airport> queryByKeyword(String code);

    boolean isBaoYouCity(String cityCode);

    boolean isChinaCity(String cityCode);
}
