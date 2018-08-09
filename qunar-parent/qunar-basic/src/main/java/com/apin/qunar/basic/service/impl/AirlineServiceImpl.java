package com.apin.qunar.basic.service.impl;

import com.apin.qunar.basic.dao.impl.AirlineDaoImpl;
import com.apin.qunar.basic.dao.model.Airline;
import com.apin.qunar.basic.service.AirlineService;
import com.apin.qunar.common.utils.BeanUtil;
import com.apin.qunar.basic.domain.airline.AirlineVO;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Slf4j
public class AirlineServiceImpl implements AirlineService {

    private Cache<String, Airline> airlineCache = CacheBuilder.newBuilder().maximumSize(2000).build();
    @Autowired
    private AirlineDaoImpl airlineDao;

    @PostConstruct
    public void init() {
        loadAllData();
    }

    private void loadAllData() {
        log.info("开始初始化航空公司信息");
        List<Airline> airlines = airlineDao.queryAll();
        for (Airline airline : airlines) {
            airlineCache.put(airline.getCode(), airline);
        }
        log.info("初始化航空公司信息完毕");
    }

    @Override
    public AirlineVO getByLikeCode(String code) {
        AirlineVO airlineVO = null;
        if (StringUtils.isBlank(code)) {
            return airlineVO;
        }
        try {
            Airline airline = airlineDao.queryByCode(code);
            airlineVO = BeanUtil.copyProperties(airline, AirlineVO.class);
        } catch (Exception e) {
            log.error("查询航空公司信息异常,code:{}", code, e);
        }
        return airlineVO;
    }

    @Override
    public String getNameByCode(String code) {
        Airline airline = airlineCache.getIfPresent(code);
        return airline == null ? "" : airline.getName();
    }
}