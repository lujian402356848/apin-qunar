package com.apin.qunar.basic.service.impl;

import com.apin.qunar.basic.dao.impl.AirportDaoImpl;
import com.apin.qunar.basic.dao.model.Airport;
import com.apin.qunar.basic.service.AirportService;
import com.apin.qunar.common.utils.BeanUtil;
import com.apin.qunar.basic.domain.airport.AirportVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-25 10:58
 */
@Slf4j
@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportDaoImpl airportDao;

    @Override
    public List<AirportVO> getByCode(String code) {
        List<AirportVO> airportVOs = new ArrayList<>();
        if (StringUtils.isBlank(code)) {
            return airportVOs;
        }
        try {
            List<Airport> airports = airportDao.queryByName(code);
            for (Airport airport : airports) {
                airportVOs.add(BeanUtil.copyProperties(airport, AirportVO.class));
            }
        } catch (Exception e) {
            log.error("查询机场信息异常,name:{}", code, e);
        }
        return airportVOs;
    }
}
