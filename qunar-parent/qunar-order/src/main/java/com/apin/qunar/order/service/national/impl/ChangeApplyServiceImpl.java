package com.apin.qunar.order.service.national.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.common.ids.IDGenerator;
import com.apin.qunar.order.common.enums.OrderStatusEnum;
import com.apin.qunar.order.dao.impl.NationalChangeOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalChangePassengerDaoImpl;
import com.apin.qunar.order.dao.impl.NationalPassengerDaoImpl;
import com.apin.qunar.order.dao.model.NationalChangeOrder;
import com.apin.qunar.order.dao.model.NationalChangePassenger;
import com.apin.qunar.order.dao.model.NationalPassenger;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.changeApply.ChangeApplyParam;
import com.apin.qunar.order.domain.national.changeApply.ChangeApplyResultVO;
import com.apin.qunar.order.domain.national.searchOrderDetail.SearchOrderDetailParam;
import com.apin.qunar.order.domain.national.searchOrderDetail.SearchOrderDetailResultVO;
import com.apin.qunar.order.service.national.ChangeApplyService;
import com.apin.qunar.order.service.national.SearchOrderDetailService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
    SearchOrderDetailService searchOrderDetailService;
    @Autowired
    NationalChangeOrderDaoImpl nationalChangeOrderDao;
    @Autowired
    NationalChangePassengerDaoImpl nationalChangePassengerDao;
    @Autowired
    private DataSourceTransactionManager transactionManager;
    @Autowired
    private NationalPassengerDaoImpl nationalPassengerDao;

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
    public ApiResult<List<ChangeApplyResultVO>> changeApply(final ChangeApplyParam changeApplyParam, final String account, final String merchantNo) {
        ApiResult<List<ChangeApplyResultVO>> apiResult = execute(changeApplyParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        if (!apiResult.isSuccess()) {
            log.warn("国内订单改签申请失败,params:{},原因:{}", JSON.toJSON(changeApplyParam), apiResult.getMessage());
            return ApiResult.fail(apiResult.getCode(), apiResult.getMessage());
        }
        if (apiResult.isSuccess()) {
            List<ChangeApplyResultVO> changeApplyResultVO = apiResult.getResult();
            if (CollectionUtils.isNotEmpty(changeApplyResultVO)) {
                savaToDb(apiResult.getResult(), changeApplyParam, account, merchantNo);
                ChangeApplyResultVO nationalPassenger = changeApplyResultVO.get(0);
                boolean hasSuccess = nationalPassenger.getChangeApplyResult().isSuccess();
                if (hasSuccess) {
                    return apiResult;
                } else {
                    return ApiResult.fail(apiResult.getCode(), "改签申请失败");
                }
            }
        }
        return apiResult;
    }

    private void savaToDb(List<ChangeApplyResultVO> changeApplyResultVOS, ChangeApplyParam changeApplyParam, String account, String merchantNo) {
        if (CollectionUtils.isNotEmpty(changeApplyResultVOS)) {
            ChangeApplyResultVO changeApplyResultVO = changeApplyResultVOS.get(0);
            ChangeApplyResultVO.ChangeApplyResult changeApplyResult = changeApplyResultVO.getChangeApplyResult();
            if (changeApplyResult != null) {
                String orderNo = changeApplyResult.getOrderNo();
                ApiResult<SearchOrderDetailResultVO> apiResult = searchOrderDetailService.searchOrderDetail(buildSearchOrderDetailParam(orderNo));
                DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
                definition.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_SERIALIZABLE);
                TransactionStatus status = transactionManager.getTransaction(definition);//事务开始
                List<NationalChangePassenger> nationalChangePessengers = bulidNationalChangePessenger(changeApplyResultVOS, orderNo, merchantNo);
                NationalChangeOrder nationalChangeOrder = bulidNationalChangeOrder(apiResult.getResult(), changeApplyResultVOS, changeApplyParam, account, orderNo, merchantNo);
                try {
                    nationalChangeOrderDao.insert(nationalChangeOrder);
                    for (NationalChangePassenger nationalChangePessenger : nationalChangePessengers) {
                        nationalChangePassengerDao.insert(nationalChangePessenger);
                    }
                    transactionManager.commit(status);//提交事务
                } catch (Exception e) {
                    transactionManager.rollback(status);//事务回滚
                    log.error("保存国内改签订单到数据库异常,changeApplyResultVO:{},changeApplyParam:{}", changeApplyResultVO, changeApplyParam, e);
                }
            }
        }

    }

    private List<NationalChangePassenger> bulidNationalChangePessenger(List<ChangeApplyResultVO> changeApplyResultVOS, String orderNo, String merchantNo) {
        List<NationalChangePassenger> nationalChangePessengers = new ArrayList();
        for (ChangeApplyResultVO changeApplyResultVO : changeApplyResultVOS) {
            NationalChangePassenger nationalChangePassenger = new NationalChangePassenger();
            nationalChangePassenger.setId(Long.toString(changeApplyResultVO.getId()));
            nationalChangePassenger.setName(changeApplyResultVO.getName());
            nationalChangePassenger.setCardNo(changeApplyResultVO.getCardNum());
            nationalChangePassenger.setCardType(changeApplyResultVO.getCardType());
            nationalChangePassenger.setGender(changeApplyResultVO.getGender());
            nationalChangePassenger.setBirthday(changeApplyResultVO.getBirthday());
            nationalChangePassenger.setMobileNo(bulidMobileNo(orderNo, changeApplyResultVO.getName()));
            nationalChangePassenger.setOrderNo(orderNo);
            nationalChangePassenger.setMerchantNo(merchantNo);
            nationalChangePessengers.add(nationalChangePassenger);
        }
        return nationalChangePessengers;
    }

    private NationalChangeOrder bulidNationalChangeOrder(SearchOrderDetailResultVO searchOrderDetailResultVO, List<ChangeApplyResultVO> changeApplyResultVOS, ChangeApplyParam changeApplyParam, String account, String orderNo, String merchantNo) {
        NationalChangeOrder nationalChangeOrder = new NationalChangeOrder();
        nationalChangeOrder.setId(IDGenerator.getUniqueId());
        nationalChangeOrder.setMerchantNo(merchantNo);
        nationalChangeOrder.setOrderNo(orderNo);
        SearchOrderDetailResultVO.OrderDetail orderDetail = searchOrderDetailResultVO.getDetail();
        if (CollectionUtils.isNotEmpty(searchOrderDetailResultVO.getFlightInfo())) {
            SearchOrderDetailResultVO.FlightInfo flightInfo = searchOrderDetailResultVO.getFlightInfo().get(0);
            nationalChangeOrder.setFlightNum(flightInfo.getFlightNum());
            nationalChangeOrder.setFlightTime(flightInfo.getFlightTime());
            nationalChangeOrder.setCarrierCode(flightInfo.getCarrierCode());
            nationalChangeOrder.setCarrierName(flightInfo.getCarrierName());
            nationalChangeOrder.setDeptCity(flightInfo.getDptCity());
            nationalChangeOrder.setArriCity(flightInfo.getArrCity());
            nationalChangeOrder.setDeptAirportCode(flightInfo.getDptAirportCode());
            nationalChangeOrder.setArriAirportCode(flightInfo.getArrAirportCode());
            nationalChangeOrder.setDeptAirportName(flightInfo.getDptAirportName());
            nationalChangeOrder.setArriAirportName(flightInfo.getArrAirportName());
            nationalChangeOrder.setDeptTerminal(flightInfo.getDptTerminal());
            nationalChangeOrder.setArriTerminal(flightInfo.getArrTerminal());
            nationalChangeOrder.setDeptDate(flightInfo.getDeptDate());
            nationalChangeOrder.setDeptTime(flightInfo.getDeptTime());
            nationalChangeOrder.setArriTime(flightInfo.getArrTime());
        }
        nationalChangeOrder.setTicketNo(getTicketNo(searchOrderDetailResultVO.getPassengers()));

        if (CollectionUtils.isNotEmpty(changeApplyResultVOS)) {
            ChangeApplyResultVO.ChangeApplyResult changeApplyResult = changeApplyResultVOS.get(0).getChangeApplyResult();
            if (changeApplyResult != null) {
                nationalChangeOrder.setChangeId(changeApplyResult.getGqId());
            }
        }
        nationalChangeOrder.setChangeFee(Integer.parseInt(changeApplyParam.getGqFee()));
        nationalChangeOrder.setChangeStatus(OrderStatusEnum.valueOfEnum(orderDetail.getStatus()).code);
        SearchOrderDetailResultVO.ContacterInfo contacterInfo = searchOrderDetailResultVO.getContacterInfo();
        nationalChangeOrder.setContactName(contacterInfo.getName());
        nationalChangeOrder.setContactMobile(contacterInfo.getMobile());
        nationalChangeOrder.setOperator(account);
        return nationalChangeOrder;
    }

    private SearchOrderDetailParam buildSearchOrderDetailParam(final String orderNo) {
        SearchOrderDetailParam searchOrderDetailParam = new SearchOrderDetailParam();
        searchOrderDetailParam.setOrderNo(orderNo);
        return searchOrderDetailParam;
    }

    private String getTicketNo(List<SearchOrderDetailResultVO.Passenger> passengers) {
        StringBuilder ticketNoStr = new StringBuilder(100);
        for (SearchOrderDetailResultVO.Passenger passenger : passengers) {
            if (StringUtils.isBlank(passenger.getTicketNo())) {
                continue;
            }
            ticketNoStr.append(",");
            ticketNoStr.append(passenger.getName());
            ticketNoStr.append("/");
            ticketNoStr.append(passenger.getTicketNo());
        }
        return ticketNoStr.length() < 1 ? "" : ticketNoStr.substring(1);
    }

    private String bulidMobileNo(String orderNo, String name) {
        NationalPassenger passenger = nationalPassengerDao.queryBy(orderNo, name);
        if (passenger != null) {
            return passenger.getMobileNo();
        }
        return "";
    }
}
