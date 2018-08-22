package com.apin.qunar.order.service.national.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.order.dao.impl.NationalChangeOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalChangePassengerDaoImpl;
import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.dao.model.NationalChangeOrder;
import com.apin.qunar.order.dao.model.NationalChangePassenger;
import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.searchChangeOrderDetail.SearchChangeOrderDetailResultVO;
import com.apin.qunar.order.domain.national.searchOrderDetail.SearchOrderDetailParam;
import com.apin.qunar.order.service.national.SearchChangeOrderDetailService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SearchChangeOrderDetailServiceImpl extends ApiService<SearchOrderDetailParam, ApiResult<SearchChangeOrderDetailResultVO>> implements SearchChangeOrderDetailService {
    @Autowired
    private NationalChangeOrderDaoImpl nationalChangeOrderDao;
    @Autowired
    private NationalChangePassengerDaoImpl nationalChangePassengerDao;
    @Autowired
    private NationalOrderDaoImpl nationalOrderDao;

    @Override
    protected String getTag() {
        return "flight.national.tts.order.info.detail.get";
    }

    @Override
    protected TypeReference<ApiResult<SearchChangeOrderDetailResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<SearchChangeOrderDetailResultVO>>() {
        };
    }

    @Override
    public ApiResult<SearchChangeOrderDetailResultVO> searchOrderDetail(final SearchOrderDetailParam searchOrderDetailParam) {
        ApiResult<SearchChangeOrderDetailResultVO> apiResult = execute(searchOrderDetailParam);
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

    private void setSearchOrderDetailResult(String orderNo, SearchChangeOrderDetailResultVO searchOrderDetailResult) {
        if (searchOrderDetailResult == null || CollectionUtils.isEmpty(searchOrderDetailResult.getFlightInfo())) {
            return;
        }
        NationalChangeOrder nationalChangeOrder = nationalChangeOrderDao.queryByOrderNo(orderNo);
        String parentOrderNo = nationalChangeOrder.getParentOrderNo();
        NationalOrder nationalOrder = nationalOrderDao.queryByOrderNo(parentOrderNo);
        if (nationalChangeOrder != null) {
            SearchChangeOrderDetailResultVO.OrderDetail orderDetail = searchOrderDetailResult.getDetail();
            if (orderDetail != null) {
                orderDetail.setOrderId(nationalChangeOrder.getId());
            }
            List<SearchChangeOrderDetailResultVO.FlightInfo> flightInfos = searchOrderDetailResult.getFlightInfo();
            if (CollectionUtils.isEmpty(flightInfos)) {
                return;
            }
            SearchChangeOrderDetailResultVO.FlightInfo flightInfo = flightInfos.get(0);
            flightInfo.setActFlightNum(nationalChangeOrder.getActFlightNum());
            flightInfo.setFlightTime(nationalChangeOrder.getFlightTime());
            flightInfo.setCarrierCode(nationalChangeOrder.getCarrierCode());
            flightInfo.setCarrierName(nationalChangeOrder.getCarrierName());
            flightInfo.setHasStop(nationalOrder.getStopCnt() > 0);
            flightInfo.setDptAirportName(nationalChangeOrder.getDeptAirportName());
            flightInfo.setArrAirportName(nationalChangeOrder.getArriAirportName());
            flightInfo.setDptTerminal(nationalChangeOrder.getDeptTerminal());
            flightInfo.setArrTerminal(nationalChangeOrder.getArriTerminal());
            flightInfo.setDeptDate(nationalChangeOrder.getDeptDate());
            flightInfo.setDeptTime(nationalChangeOrder.getDeptTime());
            flightInfo.setArrTime(nationalChangeOrder.getArriTime());
            flightInfo.setReturnFee(nationalOrder.getReturnFee() == null ? 0 : nationalOrder.getReturnFee());
            flightInfo.setReturnText(nationalOrder.getReturnText());
            flightInfo.setChangeFee(nationalOrder.getChangeFee() == null ? 0 : nationalOrder.getChangeFee());
            flightInfo.setChangeText(nationalOrder.getChangeText());
            flightInfo.setChangeFee(nationalChangeOrder.getChangeFee());
            flightInfo.setTag(nationalOrder.getTag());
            if (searchOrderDetailResult.getContacterInfo() != null) {
                searchOrderDetailResult.getContacterInfo().setMobile(nationalChangeOrder.getContactMobile());
            }
        }

        String ticketNos = nationalOrder.getTicketNo();
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isNotBlank(ticketNos)) {
            map = StringToMap(ticketNos);
        }

        String[] ticket = ticketNos.split(",");
        List<NationalChangePassenger> nationalChangePassengers = nationalChangePassengerDao.queryByOrderNo(orderNo);
        List<SearchChangeOrderDetailResultVO.Passenger> passengers = searchOrderDetailResult.getPassengers();
        for (SearchChangeOrderDetailResultVO.Passenger passenger : passengers) {
            List<NationalChangePassenger> searchPassengers = nationalChangePassengers.stream().filter(p -> p.getName().equals(passenger.getName())).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(searchPassengers)) {
                passenger.setBirthday(searchPassengers.get(0).getBirthday());
                passenger.setGender(searchPassengers.get(0).getGender());
                passenger.setMobileNo(searchPassengers.get(0).getMobileNo());
                passenger.setCardNum(searchPassengers.get(0).getCardNo());
                passenger.setCardType(searchPassengers.get(0).getCardType());
                String originalTicketNo = map.get(passenger.getName());
                passenger.setOriginalTicketNo(originalTicketNo);
            }
        }
    }

    private SearchChangeOrderDetailResultVO buildTgqMsg(SearchChangeOrderDetailResultVO searchOrderDetailResultVO) {
        if (StringUtils.isNotBlank(searchOrderDetailResultVO.getOther().getTgqMsg())) {
            searchOrderDetailResultVO.getOther().setTgqMsg(searchOrderDetailResultVO.getOther().getTgqMsg().replaceAll("<br />", " "));
        }
        return searchOrderDetailResultVO;
    }


    public static Map<String, String> StringToMap(String ticketNo) {
        Map<String, String> map = new HashMap<String, String>();
        String[] originalTicketNos = ticketNo.split(","); // 转换为数组
        for (String originalTicketNo : originalTicketNos) {
            String[] keyText = originalTicketNo.split("/"); // 转换key与value的数组
            if (keyText.length < 1) {
                continue;
            }
            String key = keyText[0]; // key
            String value = keyText[1]; // value
            map.put(key, value);
        }
        return map;
    }
}
