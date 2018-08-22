package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.basic.common.constant.SmsConstants;
import com.apin.qunar.basic.common.enums.SmsSendTypeEnum;
import com.apin.qunar.basic.dao.model.Airport;
import com.apin.qunar.basic.service.AirportService;
import com.apin.qunar.basic.service.SmsService;
import com.apin.qunar.common.utils.BeanUtil;
import com.apin.qunar.order.dao.impl.NationalFlightChangeDaoImpl;
import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalPassengerDaoImpl;
import com.apin.qunar.order.dao.model.NationalFlightChange;
import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.dao.model.NationalPassenger;
import com.apin.qunar.order.domain.national.flightChange.SearchFlightChangeVO;
import com.apin.qunar.order.service.national.FlightChangeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-26 15:16
 */
@Slf4j
@Service
public class FlightChangeServiceImpl implements FlightChangeService {
    @Autowired
    private NationalFlightChangeDaoImpl nationalFlightChangeDao;
    @Autowired
    private NationalOrderDaoImpl nationalOrderDao;
    @Autowired
    private NationalPassengerDaoImpl nationalPassengerDao;
    @Autowired
    private AirportService airportService;
    @Autowired
    private SmsService smsService;

    public List<SearchFlightChangeVO> queryPageList(String merchantNo, Integer offset, Integer limit) {
        List<NationalFlightChange> flightChanges = nationalFlightChangeDao.queryPageList(merchantNo, offset, limit);
        return buildSearchFlightChangeVOs(flightChanges);
    }

    private List<SearchFlightChangeVO> buildSearchFlightChangeVOs(List<NationalFlightChange> flightChanges) {
        if (CollectionUtils.isEmpty(flightChanges)) {
            return new ArrayList<>();
        }
        List<SearchFlightChangeVO> flightChangeVOS = new ArrayList<>(flightChanges.size());
        SearchFlightChangeVO flightChangeVO;
        for (NationalFlightChange flightChange : flightChanges) {
            flightChangeVO = BeanUtil.copyProperties(flightChange, SearchFlightChangeVO.class);
            setAirportName(flightChangeVO);
            flightChangeVOS.add(flightChangeVO);
        }
        return flightChangeVOS;
    }

    @Override
    public void saveFlightChange(NationalFlightChange flightChange) {
        if (flightChange == null || StringUtils.isBlank(flightChange.getOrderNo())) {
            return;
        }
        if (StringUtils.isBlank(flightChange.getMerchantNo())) {
            NationalOrder nationalOrder = nationalOrderDao.queryByOrderNo(flightChange.getOrderNo());
            if (nationalOrder == null) {
                return;
            }
            flightChange.setMerchantNo(nationalOrder.getMerchantNo());
        }
        try {
            nationalFlightChangeDao.insert(flightChange);
            sendSms(flightChange);
        } catch (Exception e) {
            log.error("保存国内航班信息异常,nationalFlightChange:{}", flightChange, e);
        }
    }

    private void setAirportName(SearchFlightChangeVO flightChange) {
        Airport airport = airportService.queryByCode(flightChange.getDptAirport());
        if (airport != null) {
            flightChange.setDptAirport(airport.getAirportName());
        }
        airport = airportService.queryByCode(flightChange.getArrAirport());
        if (airport != null) {
            flightChange.setArrAirport(airport.getAirportName());
        }
        airport = airportService.queryByCode(flightChange.getFolDptAirport());
        if (airport != null) {
            flightChange.setFolDptAirport(airport.getAirportName());
        }
        airport = airportService.queryByCode(flightChange.getFolArrAirport());
        if (airport != null) {
            flightChange.setFolArrAirport(airport.getAirportName());
        }
    }

    @Override
    public boolean smsNotify(String merchantNo, String orderNo) {
        NationalFlightChange flightChange = nationalFlightChangeDao.queryByOrderNo(orderNo);
        if (flightChange == null) {
            return false;
        }
        flightChange.setHasSendSms(1);
        boolean result = sendSms(flightChange);
        if (result) {
            nationalFlightChangeDao.update(flightChange);
        }
        return result;
    }

    private boolean sendSms(NationalFlightChange flightChange) {
        boolean result = false;
        NationalOrder nationalOrder = nationalOrderDao.queryByOrderNo(flightChange.getOrderNo());
        if (nationalOrder == null) {
            return result;
        }
        List<NationalPassenger> passengers = nationalPassengerDao.queryByOrderNo(flightChange.getOrderNo());
        if (CollectionUtils.isEmpty(passengers)) {
            return result;
        }
        String content = "";
        String sourceFlight = "";
        String targetFlight = "";
        String dptArrTime = "";
        switch (flightChange.getChangeStatus()) {
            case "航班取消":
                for (NationalPassenger passenger : passengers) {
                    content = String.format(SmsConstants.FLIGHT_CANCEL, passenger.getName(), nationalOrder.getDeptDate(), nationalOrder.getDeptTime(), nationalOrder.getDeptCity(), nationalOrder.getArriCity(), nationalOrder.getFlightNum());
                    result = smsService.sendSms(passenger.getMobileNo(), content, SmsSendTypeEnum.FLIGHT_CANCEL);
                }
                break;
            case "航班取消有保护":
                for (NationalPassenger passenger : passengers) {
                    sourceFlight = String.format("您【%s】预定的%s %s从%s到%s的%s航班", passenger.getName(), nationalOrder.getDeptDate(), nationalOrder.getDeptTime(), nationalOrder.getDeptCity(), nationalOrder.getArriCity(), nationalOrder.getFlightNum());
                    targetFlight = String.format("%s %s的%s航班", flightChange.getFolDptDate(), flightChange.getFolDptTime(), flightChange.getFolFlightNo());
                    dptArrTime = String.format("%s %s", flightChange.getFolDptTime(), flightChange.getFolArrTime());
                    content = String.format(SmsConstants.FLIGHT_CANCEL_PROTECT, sourceFlight, targetFlight, dptArrTime);
                    result = smsService.sendSms(passenger.getMobileNo(), content, SmsSendTypeEnum.FLIGHT_CANCEL_PROTECT);
                }
                break;
            case "取消后恢复":
                for (NationalPassenger passenger : passengers) {
                    content = String.format(SmsConstants.FLIGHT_RECOVERY, passenger.getName(), nationalOrder.getDeptDate(), nationalOrder.getDeptTime(), nationalOrder.getDeptCity(), nationalOrder.getArriCity(), nationalOrder.getFlightNum());
                    result = smsService.sendSms(passenger.getMobileNo(), content, SmsSendTypeEnum.FLIGHT_RECOVERY);
                }
                break;
            case "航班变更":
                for (NationalPassenger passenger : passengers) {
                    sourceFlight = String.format("您【%s】预定的%s %s从%s到%s的%s航班", passenger.getName(), nationalOrder.getDeptDate(), nationalOrder.getDeptTime(), nationalOrder.getDeptCity(), nationalOrder.getArriCity(), nationalOrder.getFlightNum());
                    targetFlight = String.format("%s %s的%s航班", flightChange.getFolDptDate(), flightChange.getFolDptTime(), flightChange.getFolFlightNo());
                    dptArrTime = String.format("%s-%s", flightChange.getFolDptTime(), flightChange.getFolArrTime());
                    content = String.format(SmsConstants.FLIGHT_CHANGE, sourceFlight, targetFlight, dptArrTime);
                    result = smsService.sendSms(passenger.getMobileNo(), content, SmsSendTypeEnum.FLIGHT_CHANGE);
                }
                break;
        }
        return result;
    }
}