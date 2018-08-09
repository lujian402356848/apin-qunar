package com.apin.qunar.basic.service;

import com.apin.qunar.basic.domain.airport.AirportVO;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-25 10:57
 */
public interface AirportService {
    List<AirportVO> getByCode(String code);
}
