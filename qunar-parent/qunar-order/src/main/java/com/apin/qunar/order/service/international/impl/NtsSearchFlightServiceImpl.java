package com.apin.qunar.order.service.international.impl;

import com.alibaba.fastjson.JSON;
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
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
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
    private NtsFlightRedis ntsFlightRedis;
    @Resource
    private NtsSearchPriceService ntsSearchPriceService;
    @Resource
    private OrderConfig orderConfig;

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
    public ApiResult<List<NtsSearchFlightResultVO>> searchFlight(final NtsSearchFlightParam ntsSearchFlightParam, final String merchantNo) {
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
        for (NtsSearchFlightResultVO ntsSearchFlightResult : searchFlightResults) {
            setDeptTime(ntsSearchFlightResult);
            formatDuration(ntsSearchFlightResult);
            formatStayTime(ntsSearchFlightResult);
//            setBaoUTag(ntsSearchFlightResult, ntsSearchFlightParam, merchantNo);
        }
        sortByDepTime(searchFlightResults, ntsSearchFlightParam.getSortIdentification());
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
        boolean isExist = goFlightTrip.getFlightSegments().stream().anyMatch(p -> CollectionUtils.isNotEmpty(p.getStop()));
        if (isExist) {//去程如果存在经停，则直接返回
            return;
        }
        isExist = backFlightTrip.getFlightSegments().stream().anyMatch(p -> CollectionUtils.isNotEmpty(p.getStop()));
        if (isExist) {//回程如果存在经停，则直接返回
            return;
        }
        ntsSearchFlightResult.setPackName(getBaoUTag(ntsSearchFlightParam, ntsSearchFlightResult.getFlightCode(), merchantNo));
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
        return result ? "爱拼国际包优" : "";
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


    private void sortByDepTime(List<NtsSearchFlightResultVO> ntsSearchFlightResultVO, Integer sortIdentigfication) {
        Collections.sort(ntsSearchFlightResultVO, new Comparator<NtsSearchFlightResultVO>() {
            @Override
            public int compare(NtsSearchFlightResultVO ntsSearchFlightOne, NtsSearchFlightResultVO ntsSearchFlightTwo) {
                if (sortIdentigfication == 0) {
                    return ntsSearchFlightTwo.getDepTime().compareTo(ntsSearchFlightOne.getDepTime());// 降序
                } else {
                    return ntsSearchFlightOne.getDepTime().compareTo(ntsSearchFlightTwo.getDepTime());// 升序
                }
            }
        });
    }

    private void formatDuration(NtsSearchFlightResultVO ntsSearchFlightResult) {
        NtsSearchFlightResultVO.NtsFlightTrip backFlightTrip = ntsSearchFlightResult.getBackTrip();
        if (backFlightTrip != null) {
            backFlightTrip.setDuration(formatDate(backFlightTrip.getDuration()));
            setCarrierCodeName(backFlightTrip);
        }
        NtsSearchFlightResultVO.NtsFlightTrip goFlightTrip = ntsSearchFlightResult.getGoTrip();
        if (goFlightTrip != null) {
            goFlightTrip.setDuration(formatDate(goFlightTrip.getDuration()));
            setCarrierCodeName(goFlightTrip);
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