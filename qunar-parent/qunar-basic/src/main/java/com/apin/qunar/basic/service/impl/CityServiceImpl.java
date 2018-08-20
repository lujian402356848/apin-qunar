package com.apin.qunar.basic.service.impl;

import com.apin.qunar.basic.dao.impl.AreaDaoImpl;
import com.apin.qunar.basic.dao.impl.CityDaoImpl;
import com.apin.qunar.basic.dao.impl.ProvinceDaoImpl;
import com.apin.qunar.basic.dao.model.Area;
import com.apin.qunar.basic.dao.model.City;
import com.apin.qunar.basic.dao.model.Province;
import com.apin.qunar.basic.domain.area.AreaVO;
import com.apin.qunar.basic.domain.city.CityVO;
import com.apin.qunar.basic.domain.provinces.ProvincesVO;
import com.apin.qunar.basic.service.CityService;
import com.apin.qunar.common.utils.BeanUtil;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CityServiceImpl implements CityService {
    private List<ProvincesVO> provincesVOS = new ArrayList<>();
    private Cache<Long, List<CityVO>> provinceCache = CacheBuilder.newBuilder().maximumSize(5000).build();
    private Cache<Long, List<AreaVO>> cityCache = CacheBuilder.newBuilder().maximumSize(5000).build();
    @Autowired
    private ProvinceDaoImpl provinceDao;
    @Autowired
    private CityDaoImpl cityDao;
    @Autowired
    private AreaDaoImpl areaDao;

    @PostConstruct
    public void init() {
        loadAllData();
    }

    private void loadAllData() {
        log.info("开始初始化城市信息");
        List<Province> provinces = provinceDao.queryAll();
        for (Province province : provinces) {
            ProvincesVO provincesVO =new ProvincesVO();
            provincesVO.setId(province.getId()+"");
            provincesVO.setName(province.getName());
            provincesVOS.add(provincesVO);
        }
        List<City> citys = cityDao.queryAll();
        List<Area> areas = areaDao.queryAll();
        for (Province province : provinces) {
            List<City> currCities = citys.stream().filter(p -> p.getProvinceId().equals(province.getId())).collect(Collectors.toList());
            List<CityVO> cityVOs =new ArrayList<>();
            for (City city :currCities){
                CityVO cityVO =new CityVO();
                cityVO.setId(city.getId()+"");
                cityVO.setName(city.getName());
                cityVOs.add(cityVO);
            }
            if (CollectionUtils.isNotEmpty(cityVOs)) {
                provinceCache.put(province.getId(), cityVOs);
            }
        }
        for (City city : citys) {
            List<Area> currAreas = areas.stream().filter(p -> p.getCityId().equals(city.getId())).collect(Collectors.toList());
            List<AreaVO> areaVOS = BeanUtil.copyProperties(currAreas, AreaVO.class);
            if (CollectionUtils.isNotEmpty(areaVOS)) {
                cityCache.put(city.getId(), areaVOS);
            }
        }
        log.info("初始化城市信息完毕");
    }

    @Override
    public List<ProvincesVO> queryProvince() {
        return provincesVOS;
    }

    @Override
    public List<CityVO> queryByProvinceId(Long provinceId) {
        return provinceCache.getIfPresent(provinceId);

    }

    @Override
    public List<AreaVO> queryByCityId(Long cityId) {
        return cityCache.getIfPresent(cityId);
    }
}
