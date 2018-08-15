package com.apin.qunar.order.service.national.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.common.ids.IDGenerator;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.dao.impl.NationalChangeOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalChangePassengerDaoImpl;
import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalPassengerDaoImpl;
import com.apin.qunar.order.dao.model.NationalChangeOrder;
import com.apin.qunar.order.dao.model.NationalChangePassenger;
import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.dao.model.NationalPassenger;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.changeApply.ChangeApplyBO;
import com.apin.qunar.order.domain.national.changeApply.ChangeApplyParam;
import com.apin.qunar.order.domain.national.changeApply.ChangeApplyResultVO;
import com.apin.qunar.order.service.national.ChangeApplyService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-02 16:55
 */
@Slf4j
@Service
public class ChangeApplyServiceImpl extends ApiService<ChangeApplyParam, ApiResult<List<ChangeApplyResultVO>>> implements ChangeApplyService {
    @Autowired
    private NationalChangeOrderDaoImpl nationalChangeOrderDao;
    @Autowired
    private NationalChangePassengerDaoImpl nationalChangePassengerDao;
    @Autowired
    private DataSourceTransactionManager transactionManager;
    @Autowired
    private NationalPassengerDaoImpl nationalPassengerDao;
    @Autowired
    private NationalOrderDaoImpl nationalOrderDao;
    @Autowired
    private OrderConfig orderConfig;

    @Override
    protected String getTag() {
        return "flight.national.supply.sl.applyChange";
    }

    @Override
    protected TypeReference<ApiResult<List<ChangeApplyResultVO>>> getTypeReference() {
        return new TypeReference<ApiResult<List<ChangeApplyResultVO>>>() {
        };
    }

    @Override
    public ApiResult<List<ChangeApplyResultVO>> changeApply(final ChangeApplyBO changeApplyBO, final String account, final String merchantNo) {
        ApiResult<List<ChangeApplyResultVO>> apiResult = execute(buildChangeParam(changeApplyBO));
        if (apiResult == null) {
            return ApiResult.fail();
        }
        if (!apiResult.isSuccess()) {
            log.warn("国内订单改签申请失败,params:{},原因:{}", JSON.toJSON(changeApplyBO), apiResult.getMessage());
            return ApiResult.fail();
        }
        if (apiResult.isSuccess()) {
            List<ChangeApplyResultVO> changeApplyResultVO = apiResult.getResult();
            if (CollectionUtils.isNotEmpty(changeApplyResultVO)) {
                ChangeApplyResultVO nationalPassenger = changeApplyResultVO.get(0);
                boolean hasSuccess = nationalPassenger.getChangeApplyResult().isSuccess();
                if (hasSuccess) {
                    savaToDb(apiResult.getResult(), changeApplyBO, account, merchantNo);
                    return apiResult;
                } else {
                    return ApiResult.fail();
                }
            }
        }
        return apiResult;
    }

    private void savaToDb(List<ChangeApplyResultVO> changeApplyResultVOS, ChangeApplyBO changeApplyBO, String account, String merchantNo) {
        if (CollectionUtils.isNotEmpty(changeApplyResultVOS)) {
            String orderNo = changeApplyBO.getOrderNo();
            DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
            definition.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_SERIALIZABLE);
            TransactionStatus status = transactionManager.getTransaction(definition);//事务开始
            List<NationalChangePassenger> nationalChangePessengers = bulidNationalChangePessenger(changeApplyResultVOS, orderNo, merchantNo);
            NationalChangeOrder nationalChangeOrder = bulidNationalChangeOrder(changeApplyResultVOS, changeApplyBO, account, merchantNo);
            try {
                nationalChangeOrderDao.insert(nationalChangeOrder);
                for (NationalChangePassenger nationalChangePessenger : nationalChangePessengers) {
                    nationalChangePassengerDao.insert(nationalChangePessenger);
                }
                transactionManager.commit(status);//提交事务
            } catch (Exception e) {
                transactionManager.rollback(status);//事务回滚
                log.error("保存国内改签订单到数据库异常,changeApplyResultVO:{},changeApplyParam:{}", changeApplyResultVOS, changeApplyBO, e);
            }
        }

    }

    private List<NationalChangePassenger> bulidNationalChangePessenger(List<ChangeApplyResultVO> changeApplyResultVOS, String orderNo, String merchantNo) {
        List<NationalChangePassenger> nationalChangePessengers = new ArrayList();
        for (ChangeApplyResultVO changeApplyResultVO : changeApplyResultVOS) {
            NationalPassenger passenger = nationalPassengerDao.queryBy(orderNo, changeApplyResultVO.getName());
            NationalChangePassenger nationalChangePassenger = new NationalChangePassenger();
            nationalChangePassenger.setId(Long.toString(changeApplyResultVO.getId()));
            nationalChangePassenger.setName(changeApplyResultVO.getName());
            nationalChangePassenger.setCardType(changeApplyResultVO.getCardType());
            nationalChangePassenger.setGender(changeApplyResultVO.getGender());
            nationalChangePassenger.setBirthday(changeApplyResultVO.getBirthday());
            nationalChangePassenger.setOrderNo(changeApplyResultVO.getChangeApplyResult().getOrderNo());
            nationalChangePassenger.setMerchantNo(merchantNo);
            if (passenger != null) {
                nationalChangePassenger.setCardNo(passenger.getCardNo());
                nationalChangePassenger.setMobileNo(passenger.getMobileNo());
            }
            nationalChangePessengers.add(nationalChangePassenger);
        }
        return nationalChangePessengers;
    }

    private NationalChangeOrder bulidNationalChangeOrder(List<ChangeApplyResultVO> changeApplyResultVOS, ChangeApplyBO changeApplyBO, String account, String merchantNo) {
        NationalOrder nationalOrder = nationalOrderDao.queryByOrderNo(changeApplyBO.getOrderNo());
        if (nationalOrder == null) {
            return null;
        }
        NationalChangeOrder nationalChangeOrder = new NationalChangeOrder();
        nationalChangeOrder.setParentOrderNo(changeApplyBO.getOrderNo());
        nationalChangeOrder.setFlightNum(changeApplyBO.getFlightNo());
        nationalChangeOrder.setCarrierCode(changeApplyBO.getCarrier());
        nationalChangeOrder.setCarrierName(changeApplyBO.getFlight());
        nationalChangeOrder.setDeptCity(nationalOrder.getDeptCity());
        nationalChangeOrder.setArriCity(nationalOrder.getArriCity());
        nationalChangeOrder.setDeptAirportCode(changeApplyBO.getDptAirportCode());
        nationalChangeOrder.setArriAirportCode(changeApplyBO.getArrAirportCode());
        nationalChangeOrder.setDeptAirportName(changeApplyBO.getStartPlace());
        nationalChangeOrder.setArriAirportName(changeApplyBO.getEndPlace());
        nationalChangeOrder.setDeptTerminal(changeApplyBO.getDptTerminal());
        nationalChangeOrder.setArriTerminal(changeApplyBO.getArrTerminal());
        nationalChangeOrder.setDeptDate(changeApplyBO.getChangeDate());
        nationalChangeOrder.setDeptTime(changeApplyBO.getStartTime());
        nationalChangeOrder.setArriTime(changeApplyBO.getEndTime());
        nationalChangeOrder.setActFlightNum(changeApplyBO.getActFlightNo());
        nationalChangeOrder.setChangeFee(Integer.parseInt(changeApplyBO.getAllFee()));
        nationalChangeOrder.setId(IDGenerator.getUniqueId());
        nationalChangeOrder.setMerchantNo(merchantNo);
        if (CollectionUtils.isNotEmpty(changeApplyResultVOS)) {
            ChangeApplyResultVO.ChangeApplyResult changeApplyResult = changeApplyResultVOS.get(0).getChangeApplyResult();
            if (changeApplyResult != null) {
                nationalChangeOrder.setChangeId(changeApplyResult.getGqId());
                nationalChangeOrder.setOrderNo(changeApplyResult.getOrderNo());
            }
        }
        nationalChangeOrder.setChangeFee(Integer.parseInt(changeApplyBO.getGqFee()));
        nationalChangeOrder.setChangeStatus(40);
        nationalChangeOrder.setContactName(nationalOrder.getContactName());
        nationalChangeOrder.setContactMobile(nationalOrder.getContactMobile());
        nationalChangeOrder.setOperator(account);
        return nationalChangeOrder;
    }

    private ChangeApplyParam buildChangeParam(final ChangeApplyBO changeApplyBO) {
        ChangeApplyParam changeApplyParam = new ChangeApplyParam();
        changeApplyParam.setOrderNo(changeApplyBO.getOrderNo());
        changeApplyParam.setChangeCauseId(changeApplyBO.getChangeCauseId());
        changeApplyParam.setPassengerIds(changeApplyBO.getPassengerIds());
        changeApplyParam.setApplyRemarks(changeApplyBO.getApplyRemarks());
        changeApplyParam.setUniqKey(changeApplyBO.getUniqKey());
        changeApplyParam.setGqFee(changeApplyBO.getGqFee());
        changeApplyParam.setUpgradeFee(changeApplyBO.getUpgradeFee());
        changeApplyParam.setFlightNo(changeApplyBO.getFlightNo());
        changeApplyParam.setCabinCode(changeApplyBO.getCabinCode());
        changeApplyParam.setStartDate(changeApplyBO.getChangeDate());
        changeApplyParam.setStartTime(changeApplyBO.getStartTime());
        changeApplyParam.setEndTime(changeApplyBO.getEndTime());
        changeApplyParam.setCallbackUrl(orderConfig.getPayCallbackUrl());
        return changeApplyParam;
    }
}
