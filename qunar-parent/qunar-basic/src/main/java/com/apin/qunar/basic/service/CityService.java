package com.apin.qunar.basic.service;

import com.apin.qunar.basic.domain.area.AreaVO;
import com.apin.qunar.basic.domain.city.CityVO;
import com.apin.qunar.basic.domain.provinces.ProvincesVO;

import java.util.List;

public interface CityService {
    List<ProvincesVO> queryProvince();

    List<CityVO> queryByProvinceId(Long provinceId);

    List<AreaVO> queryByCityId(Long cityId);
}
