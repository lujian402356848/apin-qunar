package com.apin.qunar.basic.service;

import com.apin.qunar.basic.domain.airline.AirlineVO;

public interface AirlineService {
    AirlineVO getByLikeCode(String code);

    String getNameByCode(String code);

    boolean isBaoYouAirline(String code);
}
