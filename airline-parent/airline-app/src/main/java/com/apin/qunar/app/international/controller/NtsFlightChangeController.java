package com.apin.qunar.app.international.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.international.request.NtsFlightChangeCallbackRequest;
import com.apin.qunar.app.international.request.NtsSearchFlightChangeListRequest;
import com.apin.qunar.app.natioanl.request.FlightChangeSmsNotifyRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.common.ids.IDGenerator;
import com.apin.qunar.order.dao.model.InternationalFlightChange;
import com.apin.qunar.order.domain.international.flightChange.NtsFlightChangeCallbackDTO;
import com.apin.qunar.order.domain.international.flightChange.NtsSearchFlightChangeVO;
import com.apin.qunar.order.service.international.NtsFlightChangeService;
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
 * @create 2018-07-27 17:49
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class NtsFlightChangeController extends BaseController {
    @Autowired
    NtsFlightChangeService ntsFlightChangeService;

    @PostMapping(value = "/ntsFlightChange/List")
    public GeneralResultMap flightChangeList(@RequestBody NtsSearchFlightChangeListRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/ntsFlightChange/List接口基础验证不通过，request:{}", JSON.toJSON(request));
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
            List<NtsSearchFlightChangeVO> flightChangeVOS = ntsFlightChangeService.queryPageList(request.getMerchantNo(), request.getOffset(), request.getLimit());
            Integer count = ntsFlightChangeService.queryCount(request.getMerchantNo());
            data.put("count", count);
            data.put("flightChangeList", flightChangeVOS);
            generalResultMap.setResult(SysReturnCode.SUCC, data);
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国际查询航变列表异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    @PostMapping(value = "/ntsFlightChange/smsNotify")
    public GeneralResultMap smsNotify(@RequestBody FlightChangeSmsNotifyRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        try {
            boolean result = ntsFlightChangeService.smsNotify(request.getMerchantNo(), request.getOrderNo());
            if (result) {
                generalResultMap.setResult(SysReturnCode.SUCC);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL);
            }
        } catch (Exception e) {
            log.info("国际查询改签订单异常,request:{}", request, e);
        }
        return generalResultMap;
    }


    @PostMapping(value = "/ntsFlightChange/callback")
    public void callback(@RequestBody NtsFlightChangeCallbackRequest request) {
        log.info("国际航班变更接收消息,request:{}", JSON.toJSON(request));
        if (request == null || !"flight.international.supply.sl.flightChange".equalsIgnoreCase(request.getTag())) {
            return;
        }
        try {
            NtsFlightChangeCallbackDTO callbackDTO = getCallbackData(request.getData());
            if (callbackDTO != null) {
                log.info("国际航班变更接收消息,解析后:{}", JSON.toJSON(callbackDTO));
                InternationalFlightChange flightChange = buildFlightChange(callbackDTO);
                ntsFlightChangeService.saveFlightChange(flightChange);
            }
        } catch (Exception e) {
            log.error("国际航班变更接收消息处理异常,request:{}", request, e);
        }
    }

    private NtsFlightChangeCallbackDTO getCallbackData(String data) {
        NtsFlightChangeCallbackDTO flightChangeCallbackDTO = null;
        final Base64.Decoder decoder = Base64.getDecoder();
        try {
            flightChangeCallbackDTO = JSON.parseObject(new String(decoder.decode(data), "UTF-8"), NtsFlightChangeCallbackDTO.class);
        } catch (Exception e) {
            log.error("国际航班变更消息解码失败,data:{}", data);
        }
        return flightChangeCallbackDTO;
    }

    private InternationalFlightChange buildFlightChange(NtsFlightChangeCallbackDTO callbackDTO) {
        InternationalFlightChange flightChange = new InternationalFlightChange();
        flightChange.setId(IDGenerator.getUniqueId());
        flightChange.setOrderNo(callbackDTO.getOrderNo());
        flightChange.setFlightNo(callbackDTO.getFlightNo());
        flightChange.setDptDate(callbackDTO.getDptDate());
        flightChange.setDptAirport(callbackDTO.getDptAirport());
        flightChange.setArrAirport(callbackDTO.getArrAirport());
        flightChange.setDptTime(callbackDTO.getDptTime());
        flightChange.setArrTime(callbackDTO.getArrTime());
        flightChange.setFolFlightNo(callbackDTO.getFolFlightNo());
        flightChange.setFolDptDate(callbackDTO.getFolDptDate());
        flightChange.setFolArrDate(callbackDTO.getFolArrDate());
        flightChange.setFolDptTime(callbackDTO.getFolDptTime());
        flightChange.setFolArrTime(callbackDTO.getFolArrTime());
        flightChange.setFolDptAirport(callbackDTO.getDptAirport());
        flightChange.setFolArrAirport(callbackDTO.getArrAirport());
        flightChange.setFolFptTower(callbackDTO.getFolFptTower());
        flightChange.setFolArrTower(callbackDTO.getFolArrTower());
        flightChange.setSmsContent(callbackDTO.getSmsContent());
        flightChange.setStatus(callbackDTO.getStatus());
        flightChange.setInitStatus(callbackDTO.getInitStatus());
        flightChange.setEnsure(callbackDTO.getEnsure());
        flightChange.setAirLineTel(callbackDTO.getAirLineTel());
        flightChange.setFcStatus(callbackDTO.getFcStatus());
        flightChange.setHasSendSms(0);
        return flightChange;
    }
}
