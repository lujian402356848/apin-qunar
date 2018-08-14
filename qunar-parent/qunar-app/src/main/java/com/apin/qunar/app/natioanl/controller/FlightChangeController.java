package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.FlightChangeCallbackRequest;
import com.apin.qunar.app.natioanl.request.FlightChangeSmsNotifyRequest;
import com.apin.qunar.app.natioanl.request.SearchFlightChangeListRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.common.ids.IDGenerator;
import com.apin.qunar.order.dao.model.NationalFlightChange;
import com.apin.qunar.order.domain.national.flightChange.FlightChangeCallbackDTO;
import com.apin.qunar.order.domain.national.flightChange.SearchFlightChangeVO;
import com.apin.qunar.order.domain.national.ticketNoUpdate.TicketNoUpdateDTO;
import com.apin.qunar.order.service.national.FlightChangeService;
import com.apin.qunar.order.service.national.TicketNoUpdateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @outhor lujian
 * @create 2018-07-27 17:11
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class FlightChangeController extends BaseController {
    @Autowired
    FlightChangeService flightChangeService;
    @Autowired
    TicketNoUpdateService ticketNoUpdateService;

    @PostMapping(value = "/flightChange/list")
    public GeneralResultMap flightChangeList(@RequestBody SearchFlightChangeListRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/flightChange/list接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        Map<String, Object> data = new HashMap<>();
        if (request.getOffset() == null || request.getOffset() <= 0) {
            request.setOffset(0);
        }
        if (request.getLimit() == null || request.getLimit() <= 0) {
            request.setLimit(20);
        }
        try {
            List<SearchFlightChangeVO> flightChangeVOS = flightChangeService.queryPageList(request.getMerchantNo(), request.getOffset(), request.getLimit());
            data.put("flightChangeList", flightChangeVOS);
            generalResultMap.setResult(SysReturnCode.SUCC, data);
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国内查询航变列表异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    @PostMapping(value = "/flightChange/smsNotify")
    public GeneralResultMap smsNotify(@RequestBody FlightChangeSmsNotifyRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        try {
            boolean result = flightChangeService.smsNotify(request.getMerchantNo(), request.getOrderNo());
            if (result) {
                generalResultMap.setResult(SysReturnCode.SUCC);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL);
            }
        } catch (Exception e) {
            log.info("国内查询改签订单异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    @PostMapping(value = "/flightChange/callback")
    public void callback(@RequestBody FlightChangeCallbackRequest request) {
        log.info("国内航班变更及二次修改票号接收消息,request:{}", JSON.toJSON(request));
        try {
            switch (request.getTag())
            {
                case "flight.national.supply.sl.flightChange":
                    FlightChangeCallbackDTO callbackDTO = getFlightChangeCallbackData(request.getData());
                    if (callbackDTO != null) {
                        log.info("国内航班变更接收消息,解析后:{}", JSON.toJSON(callbackDTO));
                        NationalFlightChange flightChange = buildNationalFlightChange(callbackDTO);
                        flightChangeService.saveFlightChange(flightChange);
                    }
                    break;
                case "flight.national.supply.sl.ticketNoUpdate":
                    TicketNoUpdateDTO ticketNoUpdateDTO = getTicketNoUpdateCallbackData(request.getData());
                    if(ticketNoUpdateDTO != null){
                        log.info("二次修改票号接收消息,解析后:{}",JSON.toJSON(ticketNoUpdateDTO));
                        ticketNoUpdateService.updateOrder(ticketNoUpdateDTO);
                    }
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            log.error("国内航班变更及二次修改票号接收消息异常,request:{}", request, e);
        }
    }

    private FlightChangeCallbackDTO getFlightChangeCallbackData(String data) {
        FlightChangeCallbackDTO flightChangeCallbackDTO = null;
        final Base64.Decoder decoder = Base64.getDecoder();
        try {
            flightChangeCallbackDTO = JSON.parseObject(new String(decoder.decode(data), "UTF-8"), FlightChangeCallbackDTO.class);
        } catch (Exception e) {
            log.error("国内航班变更消息解码失败,data:{}", data);
        }
        return flightChangeCallbackDTO;
    }

    private TicketNoUpdateDTO getTicketNoUpdateCallbackData(String data) {
        TicketNoUpdateDTO ticketNoUpdateDTO = null;
        final Base64.Decoder decoder = Base64.getDecoder();
        try {
            ticketNoUpdateDTO = JSON.parseObject(new String(decoder.decode(data), "UTF-8"), TicketNoUpdateDTO.class);
        } catch (Exception e) {
            log.error("二次修改票号消息解码失败,data:{}", data);
        }
        return ticketNoUpdateDTO;
    }

    private NationalFlightChange buildNationalFlightChange(FlightChangeCallbackDTO callbackDTO) {
        NationalFlightChange flightChange = new NationalFlightChange();
        flightChange.setId(IDGenerator.getUniqueId());
        flightChange.setOrderNo(callbackDTO.getOrderNo());
        flightChange.setFlightNo(callbackDTO.getFlightNo());
        flightChange.setDptDate(callbackDTO.getDptDate());
        flightChange.setDptTime(callbackDTO.getArrTime());
        flightChange.setArrTime(callbackDTO.getArrTime());
        flightChange.setDptAirport(callbackDTO.getDptAirPort());
        flightChange.setArrAirport(callbackDTO.getArrAirPort());
        flightChange.setFolFlightNo(callbackDTO.getFolFlightNo());
        flightChange.setFolDptDate(callbackDTO.getFolDptDate());
        flightChange.setFolDptTime(callbackDTO.getFolDptTime());
        flightChange.setFolArrTime(callbackDTO.getFolArrTime());
        flightChange.setFolDptAirport(callbackDTO.getFolDptAirPort());
        flightChange.setFolArrAirport(callbackDTO.getFolArrAirPort());
        flightChange.setChangeStatus(callbackDTO.getChangeStatus());
        flightChange.setHasSendSms(0);
        return flightChange;
    }
}
