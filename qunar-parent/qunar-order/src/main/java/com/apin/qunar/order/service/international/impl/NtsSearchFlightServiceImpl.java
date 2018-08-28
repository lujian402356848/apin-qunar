package com.apin.qunar.order.service.international.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.basic.service.AirportService;
import com.apin.qunar.basic.service.impl.AirlineServiceImpl;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.common.redis.NtsFlightRedis;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.searchFlight.NtsSearchFlightParam;
import com.apin.qunar.order.domain.international.searchFlight.NtsSearchFlightResultVO;
import com.apin.qunar.order.domain.international.searchPrice.NtsSearchPriceParam;
import com.apin.qunar.order.domain.international.searchPrice.NtsSearchPriceResultVO;
import com.apin.qunar.order.service.international.NtsSearchFlightService;
import com.apin.qunar.order.service.international.NtsSearchPriceService;
import com.apin.qunar.statistics.service.SearchFlightRecordService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;

/**
 * @author lujian
 * @version 2018-07-23 16:49
 */
@Slf4j
@Service
public class NtsSearchFlightServiceImpl extends NtsApiService<NtsSearchFlightParam, ApiResult<List<NtsSearchFlightResultVO>>> implements NtsSearchFlightService {
    @Resource
    private AirlineServiceImpl airlineService;
    @Resource
    private NtsSearchPriceService ntsSearchPriceService;
    @Resource
    private OrderConfig orderConfig;
    @Autowired
    private SearchFlightRecordService searchFlightRecordService;
    @Autowired
    private AirportService airportService;
    @Resource
    private NtsFlightRedis ntsFlightRedis;

    @Override
    protected String getTag() {
        return "flight.international.supply.sl.flightsearch";
    }


    @Override
    protected TypeReference<ApiResult<List<NtsSearchFlightResultVO>>> getTypeReference() {
        return new TypeReference<ApiResult<List<NtsSearchFlightResultVO>>>() {
        };
    }

    @Override
    public ApiResult<List<NtsSearchFlightResultVO>> searchFlight(final NtsSearchFlightParam ntsSearchFlightParam, final String merchantNo, final String account) {
        searchFlightRecordService.create(account, false, ntsSearchFlightParam.getDepCity(), ntsSearchFlightParam.getArrCity());
        List<NtsSearchFlightResultVO> flightResults = ntsFlightRedis.getFlightInfo(ntsSearchFlightParam);
        if (!CollectionUtils.isEmpty(flightResults)) {
            return new ApiResult<>(0, "", System.currentTimeMillis(), flightResults);
        }
        ApiResult<List<NtsSearchFlightResultVO>> apiResult = execute(ntsSearchFlightParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        if (!apiResult.isSuccess()) {
            log.warn("查询国际航班异常,params:{},原因:{}", JSON.toJSON(ntsSearchFlightParam), apiResult.getMessage());
            return ApiResult.fail(apiResult.getCode(), "航班信息发生变动，请重新搜索");
        }
        if (apiResult.getResult() == null) {
            return ApiResult.fail();
        }
        formatResult(apiResult, ntsSearchFlightParam, merchantNo);
        ntsFlightRedis.setFlightInfo(ntsSearchFlightParam, apiResult.getResult());//将查询结果缓存
        return apiResult;
    }

    private void formatResult(ApiResult<List<NtsSearchFlightResultVO>> apiResult, final NtsSearchFlightParam ntsSearchFlightParam, final String merchantNo) {
        List<NtsSearchFlightResultVO> searchFlightResults = apiResult.getResult();
        if (CollectionUtils.isEmpty(searchFlightResults)) {
            return;
        }
        boolean isBaoYou = isBaoYouTag(ntsSearchFlightParam);
        for (NtsSearchFlightResultVO ntsSearchFlightResult : searchFlightResults) {
            setDeptTime(ntsSearchFlightResult);
            formatDuration(ntsSearchFlightResult);
            formatStayTime(ntsSearchFlightResult);
            if (isBaoYou) {
                setBaoUTag(ntsSearchFlightResult, ntsSearchFlightParam, merchantNo);
            }
        }
        sortByPrice(searchFlightResults);
    }

    private void sortByPrice(List<NtsSearchFlightResultVO> ntsSearchFlightResultVO) {
        ntsSearchFlightResultVO.sort(Comparator.comparing(NtsSearchFlightResultVO::getPrice));
    }

    private boolean isBaoYouTag(final NtsSearchFlightParam ntsSearchFlightParam) {
        boolean isBaoYou = false;
        String deptCity = ntsSearchFlightParam.getDepCity();
        String arrCity = ntsSearchFlightParam.getArrCity();
        boolean deptCityIsChina = airportService.isChinaCity(deptCity);
        boolean arrCityIsChina = airportService.isChinaCity(arrCity);
        //如果出发到达城市都是中国或都不是中国，则不设置包优
        if (deptCityIsChina && arrCityIsChina || !deptCityIsChina && !arrCityIsChina) {
            return isBaoYou;
        }
        //如果出发城市是中国但是达到城市不是包优城市，则不设置包优
        if (deptCityIsChina && !airportService.isBaoYouCity(arrCity)) {
            return isBaoYou;
        }
        //如果到达城市是中国但是出发城市不是包优城市，则不设置包优
        if (arrCityIsChina && !airportService.isBaoYouCity(deptCity)) {
            return isBaoYou;
        }
        //如果不选择返程时间，则不设置包优
        if (StringUtils.isBlank(ntsSearchFlightParam.getRetDate())) {
            return isBaoYou;
        }
        return true;
    }

    private void setBaoUTag(NtsSearchFlightResultVO ntsSearchFlightResult, final NtsSearchFlightParam ntsSearchFlightParam, String merchantNo) {
        NtsSearchFlightResultVO.NtsFlightTrip goFlightTrip = ntsSearchFlightResult.getGoTrip();//去程
        NtsSearchFlightResultVO.NtsFlightTrip backFlightTrip = ntsSearchFlightResult.getBackTrip();//回程
        //没有往返，直接返回
        if (goFlightTrip == null || backFlightTrip == null) {
            return;
        }
        //如果有中转，直接返回
        if (CollectionUtils.isNotEmpty(goFlightTrip.getTransitCities()) || CollectionUtils.isNotEmpty(backFlightTrip.getTransitCities())) {
            return;
        }
        if (CollectionUtils.isEmpty(goFlightTrip.getFlightSegments()) || CollectionUtils.isEmpty(backFlightTrip.getFlightSegments())) {
            return;
        }
        //去程如果存在经停或者是不存在的包U航空公司，则直接返回
        List<NtsSearchFlightResultVO.NtsFlightSegment> goFlightSegments = goFlightTrip.getFlightSegments();
        for (NtsSearchFlightResultVO.NtsFlightSegment flightSegment : goFlightSegments) {
            if (!CollectionUtils.isEmpty(flightSegment.getStop()) || !airlineService.isBaoYouAirline(flightSegment.getCarrierCode())) {
                return;
            }
        }
        //回程如果存在经停或者是不存在的包U航空公司，则直接返回
        List<NtsSearchFlightResultVO.NtsFlightSegment> backFlightSegments = backFlightTrip.getFlightSegments();
        for (NtsSearchFlightResultVO.NtsFlightSegment flightSegment : backFlightSegments) {
            if (!CollectionUtils.isEmpty(flightSegment.getStop()) || !airlineService.isBaoYouAirline(flightSegment.getCarrierCode())) {
                return;
            }
        }
        ntsSearchFlightResult.setPackName("包");
        //ntsSearchFlightResult.setPackName(getBaoUTag(ntsSearchFlightParam, ntsSearchFlightResult.getFlightCode(), merchantNo));
    }

    private String getBaoUTag(final NtsSearchFlightParam flightParam, final String flightCode, final String merchantNo) {
        ApiResult<NtsSearchPriceResultVO> searchPriceResultApi = ntsSearchPriceService.searchPrice(buildNtsSearchPriceParam(flightParam, flightCode), merchantNo);
        if (searchPriceResultApi == null || !searchPriceResultApi.isSuccess()) {
            return "";
        }
        NtsSearchPriceResultVO searchPriceResult = searchPriceResultApi.getResult();
        if (searchPriceResult == null || CollectionUtils.isEmpty(searchPriceResult.getPriceInfo())) {
            return "";
        }
        boolean result = searchPriceResult.getPriceInfo().stream().anyMatch(p -> "爱拼国际包优".equals(p.getPackName()));
        return result ? "包" : "";
    }

    private NtsSearchPriceParam buildNtsSearchPriceParam(final NtsSearchFlightParam flightParam, final String flightCode) {
        NtsSearchPriceParam ntsSearchPriceParam = new NtsSearchPriceParam();
        ntsSearchPriceParam.setDepCity(flightParam.getDepCity());
        ntsSearchPriceParam.setArrCity(flightParam.getArrCity());
        ntsSearchPriceParam.setDepDate(flightParam.getDepDate());
        ntsSearchPriceParam.setRetDate(flightParam.getRetDate());
        ntsSearchPriceParam.setSource(orderConfig.getInternationalSource());
        ntsSearchPriceParam.setFlightCode(flightCode);
        ntsSearchPriceParam.setAdultNum(flightParam.getAdultNum());
        ntsSearchPriceParam.setChildNum(flightParam.getChildNum());
        ntsSearchPriceParam.setCabinLevel(flightParam.getCabinLevel());
        return ntsSearchPriceParam;
    }


    private void formatDuration(NtsSearchFlightResultVO ntsSearchFlightResult) {
        NtsSearchFlightResultVO.NtsFlightTrip backFlightTrip = ntsSearchFlightResult.getBackTrip();
        if (backFlightTrip != null) {
            backFlightTrip.setDuration(formatDate(backFlightTrip.getDuration()));
            setCarrierCodeName(backFlightTrip);
            List<NtsSearchFlightResultVO.NtsFlightSegment> backFlightSegments = backFlightTrip.getFlightSegments();
            if (backFlightSegments != null) {
                for (NtsSearchFlightResultVO.NtsFlightSegment ntsFlightSegment : backFlightSegments) {
                    ntsFlightSegment.setDuration(formatDate(ntsFlightSegment.getDuration()));
                }
            }
        }
        NtsSearchFlightResultVO.NtsFlightTrip goFlightTrip = ntsSearchFlightResult.getGoTrip();
        if (goFlightTrip != null) {
            goFlightTrip.setDuration(formatDate(goFlightTrip.getDuration()));
            setCarrierCodeName(goFlightTrip);
            List<NtsSearchFlightResultVO.NtsFlightSegment> goFlightSegments = goFlightTrip.getFlightSegments();
            if (goFlightSegments != null) {
                for (NtsSearchFlightResultVO.NtsFlightSegment ntsFlightSegment : goFlightSegments) {
                    ntsFlightSegment.setDuration(formatDate(ntsFlightSegment.getDuration()));
                }
            }
        }
    }

    private void formatStayTime(NtsSearchFlightResultVO ntsSearchFlightResult) {
        NtsSearchFlightResultVO.NtsFlightTrip goFlightTrip = ntsSearchFlightResult.getGoTrip();
        if (goFlightTrip != null && CollectionUtils.isNotEmpty(goFlightTrip.getTransitCities())) {
            NtsSearchFlightResultVO.NtsTransitCity ntsTransitCity = goFlightTrip.getTransitCities().get(0);
            if (ntsTransitCity != null) {
                ntsTransitCity.setStayTime(formatDate(ntsTransitCity.getStayTime()));
            }
        }
        NtsSearchFlightResultVO.NtsFlightTrip goBackTrip = ntsSearchFlightResult.getBackTrip();
        if (goBackTrip != null && CollectionUtils.isNotEmpty(goBackTrip.getTransitCities())) {
            NtsSearchFlightResultVO.NtsTransitCity ntsTransitCity = goBackTrip.getTransitCities().get(0);
            if (ntsTransitCity != null) {
                ntsTransitCity.setStayTime(formatDate(ntsTransitCity.getStayTime()));
            }
        }
    }

    private String formatDate(String minuteTime) {
        return (Integer.parseInt(minuteTime) / 60) + "小时" + (Integer.parseInt(minuteTime) % 60) + "分钟";
    }

    private void setDeptTime(NtsSearchFlightResultVO ntsSearchFlightResult) {
        NtsSearchFlightResultVO.NtsFlightTrip ntsFlightTrip = ntsSearchFlightResult.getGoTrip();
        if (ntsFlightTrip != null && CollectionUtils.isNotEmpty(ntsFlightTrip.getFlightSegments())) {
            ntsSearchFlightResult.setDepTime(ntsFlightTrip.getFlightSegments().get(0).getDepTime());
        }
    }

    private void setCarrierCodeName(NtsSearchFlightResultVO.NtsFlightTrip ntsSearchFlightResult) {
        String airLineName = null;
        try {
            List<NtsSearchFlightResultVO.NtsFlightSegment> ntsFlightSegmentList = ntsSearchFlightResult.getFlightSegments();
            for (NtsSearchFlightResultVO.NtsFlightSegment ntsFlightSegment : ntsFlightSegmentList) {
                airLineName = airlineService.getNameByCode(ntsFlightSegment.getCarrierCode());
                ntsFlightSegment.setCarrierCodeName(airLineName);
            }
        } catch (Exception e) {
            log.error("设置航班名称异常,param:{}", ntsSearchFlightResult, e);
        }
    }
}