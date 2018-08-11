package com.apin.qunar.order.service.national.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.common.ids.IDGenerator;
import com.apin.qunar.common.utils.UUIDUtil;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalReturnOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalReturnPassengerDaoImpl;
import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.dao.model.NationalReturnOrder;
import com.apin.qunar.order.dao.model.NationalReturnPassenger;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.refund.RefundParam;
import com.apin.qunar.order.domain.national.refund.RefundRequestBO;
import com.apin.qunar.order.domain.national.refund.RefundResultVO;
import com.apin.qunar.order.domain.national.refundSearch.RefundSearchParam;
import com.apin.qunar.order.domain.national.refundSearch.RefundSearchResultVO;
import com.apin.qunar.order.service.national.RefundSearchService;
import com.apin.qunar.order.service.national.RefundService;
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
 * @create 2018-06-23 22:51
 */
@Service
@Slf4j
public class RefundServiceImpl extends ApiService<RefundParam, ApiResult<List<RefundResultVO>>> implements RefundService {
    @Autowired
    private OrderConfig orderConfig;
    @Autowired
    private NationalOrderDaoImpl natioanlOrderDao;
    @Autowired
    private NationalReturnOrderDaoImpl nationalReturnOrderDao;
    @Autowired
    private DataSourceTransactionManager transactionManager;
    @Autowired
    private NationalReturnPassengerDaoImpl nationalReturnPassengerDao;
    @Autowired
    private RefundSearchService refundSearchService;

    @Override
    protected String getTag() {
        return "flight.national.supply.sl.applyRefund";
    }

    @Override
    protected TypeReference<ApiResult<List<RefundResultVO>>> getTypeReference() {
        return new TypeReference<ApiResult<List<RefundResultVO>>>() {
        };
    }

    @Override
    public ApiResult<List<RefundResultVO>> refund(final RefundRequestBO refundRequestBO) {
        ApiResult<List<RefundSearchResultVO>> refundSearchResult = refundSearchService.refundSearch(buildRefundSearchParam(refundRequestBO), refundRequestBO.getMerchantNo());
        if (refundSearchResult == null) {
            return ApiResult.fail();
        }
        if (!refundSearchResult.isSuccess()) {
            log.warn("国内退票异常,param:{},原因:{}", JSON.toJSON(refundRequestBO), refundSearchResult.getMessage());
            return ApiResult.fail();
        }
        if (CollectionUtils.isEmpty(refundSearchResult.getResult())) {
            return ApiResult.fail();
        }
        RefundParam refundParam = buildRefundParam(refundRequestBO);
        ApiResult<List<RefundResultVO>> refundResult = execute(refundParam);
        if (refundResult == null || !refundResult.isSuccess()) {
            return ApiResult.fail();
        }
        int retundFee = 0;
        List<RefundSearchResultVO.TgqReason> tgqReasons = refundSearchResult.getResult().get(0).getRefundSearchResult().getTgqReasons();
        for (RefundSearchResultVO.TgqReason tgqReason : tgqReasons) {
            if (!refundParam.getRefundCauseId().equals(tgqReason.getCode())) {
                continue;
            }
            if (CollectionUtils.isEmpty(tgqReason.getRefundPassengerPriceInfoList())) {
                break;
            }
            RefundSearchResultVO.RefundPassengerPriceInfo refundPassengerPrice = tgqReason.getRefundPassengerPriceInfoList().get(0);
            int ticketPrice = refundPassengerPrice.getBasePassengerPriceInfo().getTicketPrice();
            int constructionFee = refundPassengerPrice.getBasePassengerPriceInfo().getConstructionFee();
            int fueTax = refundPassengerPrice.getBasePassengerPriceInfo().getFuelTax();
            int refundFee = 0;
            if (refundPassengerPrice.getRefundFeeInfo() != null) {
                refundFee = refundPassengerPrice.getRefundFeeInfo().getRefundFee();
            }
            retundFee = ticketPrice + constructionFee + fueTax - refundFee;//票价+机建价格+燃油价格-当前时间点退票扣费
        }
        saveOrderToDb(refundSearchResult.getResult(), refundParam, refundResult.getResult(), retundFee);
        return refundResult;
    }

    private RefundParam buildRefundParam(final RefundRequestBO refundRequest) {
        RefundParam refundParam = new RefundParam();
        refundParam.setOrderNo(refundRequest.getOrderNo());
        refundParam.setPassengerIds(refundRequest.getPassengerIds());
        refundParam.setRefundCause(refundRequest.getRefundCause());
        refundParam.setRefundCauseId(refundRequest.getRefundCauseId());
        refundParam.setCallbackUrl(orderConfig.getPayRefundCallbackUrl());
        refundParam.setOperator(refundRequest.getAccount());
        return refundParam;
    }

    private RefundSearchParam buildRefundSearchParam(final RefundRequestBO refundRequestBO) {
        RefundSearchParam refundSearchParam = new RefundSearchParam();
        refundSearchParam.setOrderNo(refundRequestBO.getOrderNo());
        return refundSearchParam;
    }

    private void saveOrderToDb(final List<RefundSearchResultVO> RefundSearchResultVOS, final RefundParam refundParam, final List<RefundResultVO> RefundResultVOS, int retundFee) {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_SERIALIZABLE);
        TransactionStatus status = transactionManager.getTransaction(definition);//事务开始
        NationalOrder nationalOrder = natioanlOrderDao.queryByOrderNo(refundParam.getOrderNo());
        NationalReturnOrder nationalReturnOrder = bulidNationalReturnOrder(RefundSearchResultVOS, refundParam, nationalOrder, retundFee);
        List<NationalReturnPassenger> nationalReturnPassengers = buildNationalPassenger(nationalOrder.getMerchantNo(), RefundResultVOS, refundParam);
        try {
            nationalReturnOrderDao.insert(nationalReturnOrder);
            for (NationalReturnPassenger nationalReturnPassenger : nationalReturnPassengers) {
                nationalReturnPassengerDao.insert(nationalReturnPassenger);
            }
            transactionManager.commit(status);//提交事务
        } catch (Exception e) {
            transactionManager.rollback(status);//事务回滚
            log.error("保存国内退票订单到数据库异常", refundParam, RefundResultVOS, e);
        }
    }

    private NationalReturnOrder bulidNationalReturnOrder(List<RefundSearchResultVO> RefundSearchResultVOS, RefundParam refundParam, NationalOrder nationalOrder, int retundFee) {
        String ticketNo = bulidTicketNo(RefundSearchResultVOS, refundParam);
        NationalReturnOrder nationalReturnOrder = new NationalReturnOrder();
        nationalReturnOrder.setId(IDGenerator.getUniqueId());
        nationalReturnOrder.setMerchantNo(nationalOrder.getMerchantNo());
        nationalReturnOrder.setOrderNo(nationalOrder.getOrderNo());
        nationalReturnOrder.setTicketNo(ticketNo);
        nationalReturnOrder.setFlightNum(nationalOrder.getFlightNum());
        nationalReturnOrder.setActFlightNum(nationalOrder.getActFlightNum());
        nationalReturnOrder.setCarrierCode(nationalOrder.getCarrierCode());
        nationalReturnOrder.setCarrierName(nationalOrder.getCarrierName());
        nationalReturnOrder.setDeptCity(nationalOrder.getDeptCity());
        nationalReturnOrder.setArriCity(nationalOrder.getArriCity());
        nationalReturnOrder.setDeptDate(nationalOrder.getDeptDate());
        nationalReturnOrder.setDeptTime(nationalOrder.getDeptTime());
        nationalReturnOrder.setArriTime(nationalOrder.getArriTime());
        nationalReturnOrder.setOperator(refundParam.getOperator());
        nationalReturnOrder.setContactEmail(nationalOrder.getContactEmail());
        nationalReturnOrder.setContactMobile(nationalOrder.getContactMobile());
        nationalReturnOrder.setContactName(nationalOrder.getContactName());
        nationalReturnOrder.setDeptAirportName(nationalOrder.getDeptAirportName());
        nationalReturnOrder.setArriAirportName(nationalOrder.getArriAirportName());
        nationalReturnOrder.setReturnStatus(30);
        nationalReturnOrder.setReturnFee(retundFee);
        nationalReturnOrder.setCarrierName(nationalOrder.getCarrierName());
        return nationalReturnOrder;
    }

    private String bulidTicketNo(List<RefundSearchResultVO> RefundSearchResultVOS, RefundParam refundParam) {
        StringBuilder ticketNoStr = new StringBuilder(100);
        String passengerId = refundParam.getPassengerIds();
        for (RefundSearchResultVO refundSearchResultVO : RefundSearchResultVOS) {
            Long id = refundSearchResultVO.getId();
            if (passengerId.indexOf(id.toString()) != -1) {
                ticketNoStr.append(",");
                ticketNoStr.append(refundSearchResultVO.getName());
                ticketNoStr.append("/");
                ticketNoStr.append(refundSearchResultVO.getTicketNum());
            }
        }
        return ticketNoStr.length() < 1 ? "" : ticketNoStr.substring(1);
    }

    private List<NationalReturnPassenger> buildNationalPassenger(final String merchantNo, final List<RefundResultVO> RefundResultVOS, final RefundParam refundParam) {
        List<NationalReturnPassenger> nationalReturnPassengers = new ArrayList<>();
        String orderNo = refundParam.getOrderNo();
        for (RefundResultVO refundResultVO : RefundResultVOS) {
            NationalReturnPassenger passenger = new NationalReturnPassenger();
            passenger.setId(UUIDUtil.getUUID());
            passenger.setMerchantNo(merchantNo);
            passenger.setOrderNo(refundParam.getOrderNo());
            passenger.setName(refundResultVO.getName());
            passenger.setBirthday(refundResultVO.getBirthday());
            passenger.setGender(refundResultVO.getGender());
            passenger.setCardType(refundResultVO.getCardType());
            passenger.setCardNo(refundResultVO.getCardNum());
            int hasrefund = refundResultVO.getRefundApplyResult().isSuccess() ? 0 : 1;
            passenger.setHasRefund(hasrefund);
            passenger.setRefundReason(refundResultVO.getRefundApplyResult().getReason());
            nationalReturnPassengers.add(passenger);
        }
        return nationalReturnPassengers;
    }
}
