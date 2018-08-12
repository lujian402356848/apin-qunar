package com.apin.qunar.order.service.international.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.basic.service.MerchantPriceConfigService;
import com.apin.qunar.basic.service.impl.AirlineServiceImpl;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.searchFlight.NtsSearchFlightParam;
import com.apin.qunar.order.domain.international.searchFlight.NtsSearchFlightResultVO;
import com.apin.qunar.order.service.international.NtsSearchFlightService;
import com.apin.qunar.statistics.service.SearchFlightRecordService;
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
    private MerchantPriceConfigService merchantPriceConfigService;
    @Resource
    private SearchFlightRecordService searchFlightRecordService;

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
//        searchFlightRecordService.create(merchantNo, false, ntsSearchFlightParam.getDepCity(), ntsSearchFlightParam.getArrCity());
        ApiResult<List<NtsSearchFlightResultVO>> apiResult = execute(ntsSearchFlightParam);
        if (apiResult == null || CollectionUtils.isEmpty(apiResult.getResult())) {
            return ApiResult.fail();
        }
        if (!apiResult.isSuccess()) {
            log.warn("查询国际航班异常,params:{},原因:{}", JSON.toJSON(ntsSearchFlightParam), apiResult.getMessage());
            return ApiResult.fail(apiResult.getCode(), "航班信息发生变动，请重新搜索");
        }
        List<NtsSearchFlightResultVO> searchFlightResults = apiResult.getResult();
        for (NtsSearchFlightResultVO ntsSearchFlightResult : searchFlightResults) {
            setDeptTime(ntsSearchFlightResult);
            formatDuration(ntsSearchFlightResult);
            formatStayTime(ntsSearchFlightResult);
        }
        sortByDepTime(searchFlightResults, ntsSearchFlightParam.getSortIdentification());
//        setPrice(searchFlightResults, merchantNo);//国际查询航班 加价
        return apiResult;
    }

    private void setPrice(List<NtsSearchFlightResultVO> searchFlightResults, String merchantNo) {
        double ratio = merchantPriceConfigService.queryPriceRatio(merchantNo, false);
        for (NtsSearchFlightResultVO ntsSearchFlightResultVO : searchFlightResults) {
            int priceAfter = (int) (ntsSearchFlightResultVO.getPrice() * ratio);
            ntsSearchFlightResultVO.setPrice(priceAfter);
        }
    }

    private void sortByDepTime(List<NtsSearchFlightResultVO> ntsSearchFlightResultVO, Integer sortIdentigfication) {
        Collections.sort(ntsSearchFlightResultVO, new Comparator<NtsSearchFlightResultVO>() {
            @Override
            public int compare(NtsSearchFlightResultVO ntsSearchFlightOne, NtsSearchFlightResultVO ntsSearchFlightTwo) {
                if (sortIdentigfication == 0) {
                    // 降序
                    return ntsSearchFlightTwo.getDepTime().compareTo(ntsSearchFlightOne.getDepTime());
                } else {
                    // 升序
                    return ntsSearchFlightOne.getDepTime().compareTo(ntsSearchFlightTwo.getDepTime());
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