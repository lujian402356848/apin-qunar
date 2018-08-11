package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.basic.common.constant.SmsConstants;
import com.apin.qunar.basic.common.enums.SmsSendTypeEnum;
import com.apin.qunar.basic.service.SmsService;
import com.apin.qunar.common.utils.BeanUtil;
import com.apin.qunar.order.dao.impl.NationalFlightChangeDaoImpl;
import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalPassengerDaoImpl;
import com.apin.qunar.order.dao.model.NationalFlightChange;
import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.domain.national.flightChange.SearchFlightChangeVO;
import com.apin.qunar.order.service.national.FlightChangeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private SmsService smsService;

    public List<SearchFlightChangeVO> queryPageList(String merchantNo, Integer offset, Integer limit) {
        List<NationalFlightChange> flightChanges = nationalFlightChangeDao.queryPageList(merchantNo, offset, limit);
        return BeanUtil.copyProperties(flightChanges, SearchFlightChangeVO.class);
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
        List<String> mobileNos = nationalPassengerDao.queryMobileNoByOrderNo(flightChange.getOrderNo());
        if (CollectionUtils.isEmpty(mobileNos)) {
            return result;
        }
        String content = "";
        switch (flightChange.getChangeStatus()) {
            case "航班取消":
            case "航班取消保护":
                content = String.format(SmsConstants.FLIGHT_CANCEL, nationalOrder.getDeptDate(), nationalOrder.getDeptTime(), nationalOrder.getDeptCity(), nationalOrder.getArriCity(), nationalOrder.getFlightNum());
                result = smsService.sendSms(StringUtils.join(mobileNos, ","), content, SmsSendTypeEnum.FLIGHT_CANCEL);
                break;
            case "航班变更":
                String sourceFlight = String.format("%s%s-%s的%s航班", nationalOrder.getDeptDate(), nationalOrder.getDeptCity(), nationalOrder.getArriCity(), nationalOrder.getFlightNum());
                String targetFlight = String.format("%s%s-%s的%s航班", flightChange.getFolDptDate(), flightChange.getFolFlightNo(), flightChange.getFolDptDate(), flightChange.getFolArrAirport(), flightChange.getFolFlightNo());
                String dptArrTime = String.format("%s-%s", flightChange.getFolDptTime(), flightChange.getFolArrTime());
                content = String.format(SmsConstants.FLIGHT_CHANGE, sourceFlight, targetFlight, dptArrTime);
                result = smsService.sendSms(StringUtils.join(mobileNos, ","), content, SmsSendTypeEnum.FLIGHT_CHANGE);
                break;
        }
        return result;
    }
}