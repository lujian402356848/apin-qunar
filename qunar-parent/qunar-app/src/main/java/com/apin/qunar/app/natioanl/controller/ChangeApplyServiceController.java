package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.change.ChangeApplyRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.changeApply.ChangeApplyBO;
import com.apin.qunar.order.domain.national.changeApply.ChangeApplyResultVO;
import com.apin.qunar.order.service.national.ChangeApplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-02 16:58
 * 改签
 */
@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class ChangeApplyServiceController extends BaseController {
    @Autowired
    private ChangeApplyService changeService;

    @PostMapping(value = "/order/changeApply")
    public GeneralResultMap changeApply(@RequestBody@Valid ChangeApplyRequest request, BindingResult bindingResult) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/order/changeApply接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ApiResult<List<ChangeApplyResultVO>> apiResult = changeService.changeApply(buildChangeApplyBO(request), request.getAccount(), request.getMerchantNo());
            if (apiResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC, apiResult.getResult());
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL, "改签申请失败，请重新申请或咨询客服");
            }
        } catch (Exception e) {
            log.info("国内改签申请异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private ChangeApplyBO buildChangeApplyBO(final ChangeApplyRequest changeApplyRequest) {
        ChangeApplyBO changeApplyBO = new ChangeApplyBO();
        changeApplyBO.setActFlightNo(changeApplyRequest.getActFlightNo());
        changeApplyBO.setOrderNo(changeApplyRequest.getOrderNo());
        changeApplyBO.setChangeCauseId(changeApplyRequest.getChangeCauseId());
        changeApplyBO.setPassengerIds(changeApplyRequest.getPassengerIds());
        changeApplyBO.setApplyRemarks(changeApplyRequest.getApplyRemarks());
        changeApplyBO.setUniqKey(changeApplyRequest.getUniqKey());
        changeApplyBO.setGqFee(changeApplyRequest.getGqFee());
        changeApplyBO.setUpgradeFee(changeApplyRequest.getUpgradeFee());
        changeApplyBO.setFlightNo(changeApplyRequest.getFlightNo());
        changeApplyBO.setCabinCode(changeApplyRequest.getCabinCode());
        changeApplyBO.setChangeDate(changeApplyRequest.getChangeDate());
        changeApplyBO.setStartTime(changeApplyRequest.getStartTime());
        changeApplyBO.setEndTime(changeApplyRequest.getEndTime());
        changeApplyBO.setAccount(changeApplyRequest.getAccount());
        changeApplyBO.setDptAirportCode(changeApplyRequest.getDptAirportCode());
        changeApplyBO.setArrAirportCode(changeApplyRequest.getArrAirportCode());
        changeApplyBO.setDptTerminal(changeApplyRequest.getDptTerminal());
        changeApplyBO.setArrTerminal(changeApplyRequest.getArrTerminal());
        changeApplyBO.setFlight(changeApplyRequest.getFlight());
        changeApplyBO.setFlightNo(changeApplyRequest.getFlightNo());
        changeApplyBO.setFlightType(changeApplyRequest.getFlightType());
        changeApplyBO.setStartPlace(changeApplyRequest.getStartPlace());
        changeApplyBO.setEndPlace(changeApplyRequest.getEndPlace());
        changeApplyBO.setCabin(changeApplyRequest.getCabin());
        changeApplyBO.setCabinCode(changeApplyRequest.getCabinCode());
        changeApplyBO.setCarrier(changeApplyRequest.getCarrier());
        changeApplyBO.setAllFee(changeApplyRequest.getAllFee());
        changeApplyBO.setCabinStatus(changeApplyRequest.getCabinStatus());
        changeApplyBO.setActFlightNo(changeApplyRequest.getActFlightNo());
        changeApplyBO.setShare(changeApplyRequest.getShare());
        return changeApplyBO;
    }
}
