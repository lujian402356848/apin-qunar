package com.apin.qunar.order.service.national.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.order.dao.impl.NationalChangeOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalChangePassengerDaoImpl;
import com.apin.qunar.order.dao.model.NationalChangeOrder;
import com.apin.qunar.order.dao.model.NationalChangePassenger;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.searchOrderDetail.SearchOrderDetailParam;
import com.apin.qunar.order.domain.national.searchOrderDetail.SearchOrderDetailResultVO;
import com.apin.qunar.order.service.national.SearchChangeOrderDetailService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SearchChangeOrderDetailServiceImpl extends ApiService<SearchOrderDetailParam, ApiResult<SearchOrderDetailResultVO>> implements SearchChangeOrderDetailService {
    @Autowired
    private NationalChangeOrderDaoImpl nationalChangeOrderDao;
    @Autowired
    private NationalChangePassengerDaoImpl nationalChangePassengerDao;

    @Override
    protected String getTag() {
        return "flight.national.tts.order.info.detail.get";
    }

    @Override
    protected TypeReference<ApiResult<SearchOrderDetailResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<SearchOrderDetailResultVO>>() {
        };
    }

    @Override
    public ApiResult<SearchOrderDetailResultVO> searchOrderDetail(final SearchOrderDetailParam searchOrderDetailParam) {
        ApiResult<SearchOrderDetailResultVO> apiResult = execute(searchOrderDetailParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        if (!apiResult.isSuccess()) {
            log.warn("查询国内改签订单明细异常,param:{},原因:{}", JSON.toJSON(searchOrderDetailParam), apiResult.getMessage());
            return ApiResult.fail(apiResult.getCode(), apiResult.getMessage());
        }
        setSearchOrderDetailResult(searchOrderDetailParam.getOrderNo(), apiResult.getResult());
        apiResult.setResult(buildTgqMsg(apiResult.getResult()));
        return apiResult;
    }

    private void setSearchOrderDetailResult(String orderNo, SearchOrderDetailResultVO searchOrderDetailResult) {
        if (searchOrderDetailResult == null || CollectionUtils.isEmpty(searchOrderDetailResult.getFlightInfo())) {
            return;
        }
        NationalChangeOrder nationalChangeOrder = nationalChangeOrderDao.queryByOrderNo(orderNo);
        if (nationalChangeOrder != null) {
            SearchOrderDetailResultVO.OrderDetail orderDetail = searchOrderDetailResult.getDetail();
            if (orderDetail != null) {
                orderDetail.setOrderId(nationalChangeOrder.getId());
            }
            List<SearchOrderDetailResultVO.FlightInfo> flightInfos = searchOrderDetailResult.getFlightInfo();
            if (CollectionUtils.isEmpty(flightInfos)) {
                return;
            }
            SearchOrderDetailResultVO.FlightInfo flightInfo = flightInfos.get(0);
            flightInfo.setActFlightNum(nationalChangeOrder.getActFlightNum());
            flightInfo.setFlightTime(nationalChangeOrder.getFlightTime());
            flightInfo.setCarrierCode(nationalChangeOrder.getCarrierCode());
            flightInfo.setCarrierName(nationalChangeOrder.getCarrierName());
            flightInfo.setDptAirportName(nationalChangeOrder.getDeptAirportName());
            flightInfo.setArrAirportName(nationalChangeOrder.getArriAirportName());
            flightInfo.setDptTerminal(nationalChangeOrder.getDeptTerminal());
            flightInfo.setArrTerminal(nationalChangeOrder.getArriTerminal());
            flightInfo.setDeptDate(nationalChangeOrder.getDeptDate());
            flightInfo.setDeptTime(nationalChangeOrder.getDeptTime());
            flightInfo.setArrTime(nationalChangeOrder.getArriTime());
            flightInfo.setChangeFee(nationalChangeOrder.getChangeFee());
            if (searchOrderDetailResult.getContacterInfo() != null) {
                searchOrderDetailResult.getContacterInfo().setMobile(nationalChangeOrder.getContactMobile());
            }
        }
        List<NationalChangePassenger> nationalChangePassengers = nationalChangePassengerDao.queryByOrderNo(orderNo);
        List<SearchOrderDetailResultVO.Passenger> passengers = searchOrderDetailResult.getPassengers();
        for (SearchOrderDetailResultVO.Passenger passenger : passengers) {
            List<NationalChangePassenger> searchPassengers = nationalChangePassengers.stream().filter(p -> p.getName().equals(passenger.getName())).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(searchPassengers)) {
                passenger.setBirthday(searchPassengers.get(0).getBirthday());
                passenger.setGender(searchPassengers.get(0).getGender());
                passenger.setMobileNo(searchPassengers.get(0).getMobileNo());
                passenger.setCardNum(searchPassengers.get(0).getCardNo());
                passenger.setCardType(searchPassengers.get(0).getCardType());
            }
        }
    }

    private SearchOrderDetailResultVO buildTgqMsg(SearchOrderDetailResultVO searchOrderDetailResultVO) {
        if (StringUtils.isNotBlank(searchOrderDetailResultVO.getOther().getTgqMsg())) {
            searchOrderDetailResultVO.getOther().setTgqMsg(searchOrderDetailResultVO.getOther().getTgqMsg().replaceAll("<br />", " "));
        }
        return searchOrderDetailResultVO;
    }

}
