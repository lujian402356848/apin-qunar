package com.apin.qunar.order.service.international.impl;

import com.apin.qunar.basic.common.constant.SmsConstants;
import com.apin.qunar.basic.common.enums.SmsSendTypeEnum;
import com.apin.qunar.basic.dao.model.Airport;
import com.apin.qunar.basic.service.AirportService;
import com.apin.qunar.basic.service.SmsService;
import com.apin.qunar.common.utils.BeanUtil;
import com.apin.qunar.order.dao.impl.InternationalFlightChangeDaoImpl;
import com.apin.qunar.order.dao.impl.InternationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.InternationalPassengerDaoImpl;
import com.apin.qunar.order.dao.model.InternationalFlightChange;
import com.apin.qunar.order.dao.model.InternationalOrder;
import com.apin.qunar.order.domain.international.flightChange.NtsSearchFlightChangeVO;
import com.apin.qunar.order.service.international.NtsFlightChangeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-26 15:15
 */
@Slf4j
@Service
public class NtsFlightChangeServiceImpl implements NtsFlightChangeService {
    @Autowired
    private InternationalFlightChangeDaoImpl internationalFlightChangeDao;
    @Autowired
    private InternationalOrderDaoImpl internationalOrderDao;
    @Autowired
    private InternationalPassengerDaoImpl internationalPassengerDao;
    @Autowired
    private AirportService airportService;
    @Autowired
    private SmsService smsService;

    @Override
    public List<NtsSearchFlightChangeVO> queryPageList(String merchantNo, Integer offset, Integer limit) {
        List<InternationalFlightChange> flightChanges = internationalFlightChangeDao.queryPageList(merchantNo, offset, limit);
        return buildNtsSearchFlightChangeVOs(flightChanges);
    }

    private List<NtsSearchFlightChangeVO> buildNtsSearchFlightChangeVOs(List<InternationalFlightChange> flightChanges) {
        if (CollectionUtils.isEmpty(flightChanges)) {
            return new ArrayList<>();
        }
        List<NtsSearchFlightChangeVO> flightChangeVOS = new ArrayList<>(flightChanges.size());
        NtsSearchFlightChangeVO flightChangeVO;
        for (InternationalFlightChange flightChange : flightChanges) {
            flightChangeVO = BeanUtil.copyProperties(flightChange, NtsSearchFlightChangeVO.class);
            setAirportName(flightChangeVO);
            flightChangeVO.setChangeStatus(formatStatus(flightChange.getStatus()));
            flightChangeVOS.add(flightChangeVO);
        }
        return flightChangeVOS;
    }

    private String formatStatus(String status) {
        String content = "";
        switch (status) {
            case "0":
                content = "未知";
                break;
            case "1":
                content = "取消";
                break;
            case "2":
                content = "变更";
                break;
            case "3":
                content = "取消，有保护航班";
                break;
            case "4":
                content = "航班号变更";
                break;
            case "5":
                content = "取消后恢复";
                break;
        }
        return content;
    }

    @Override
    public void saveFlightChange(InternationalFlightChange flightChange) {
        if (flightChange == null || StringUtils.isBlank(flightChange.getOrderNo())) {
            return;
        }
        if (StringUtils.isBlank(flightChange.getMerchantNo())) {
            InternationalOrder internationalOrder = internationalOrderDao.queryByOrderNo(flightChange.getOrderNo());
            if (internationalOrder == null) {
                return;
            }
            flightChange.setMerchantNo(internationalOrder.getMerchantNo());
        }
        try {
            boolean result = internationalFlightChangeDao.insert(flightChange);
            if (result) {
                sendSms(flightChange);
            }
        } catch (Exception e) {
            log.error("保存国际航班信息异常,nationalFlightChange:{}", flightChange, e);
        }
    }

    private void setAirportName(NtsSearchFlightChangeVO flightChange) {
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
        InternationalFlightChange flightChange = internationalFlightChangeDao.queryByOrderNo(orderNo);
        flightChange.setHasSendSms(1);
        boolean result = sendSms(flightChange);
        if (result) {
            internationalFlightChangeDao.update(flightChange);
        }
        return result;
    }

    private boolean sendSms(InternationalFlightChange flightChange) {
        boolean result = false;
        InternationalOrder nationalOrder = internationalOrderDao.queryByOrderNo(flightChange.getOrderNo());
        if (nationalOrder == null) {
            return result;
        }
        List<String> mobileNos = internationalPassengerDao.queryMobileNoByOrderNo(flightChange.getOrderNo());
        if (CollectionUtils.isEmpty(mobileNos)) {
            return result;
        }
        String sourceFlight = String.format("%s%s-%s的%s航班", nationalOrder.getGoDeptDate(), nationalOrder.getGoDeptCity(), nationalOrder.getGoArriCity(), nationalOrder.getGoFlightNum());
        String targetFlight = String.format("%s%s-%s的%s航班", flightChange.getDptDate(), nationalOrder.getGoDeptCity(), nationalOrder.getGoArriCity(), flightChange.getFolFlightNo());
        String dptArrTime = String.format("%s-%s", flightChange.getFolDptTime(), flightChange.getFolArrTime());
        String content = String.format(SmsConstants.FLIGHT_CHANGE, sourceFlight, targetFlight, dptArrTime);
        return smsService.sendSms(StringUtils.join(mobileNos, ","), content, SmsSendTypeEnum.FLIGHT_CHANGE);
    }
}
