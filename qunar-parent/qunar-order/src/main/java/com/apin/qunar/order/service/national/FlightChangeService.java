package com.apin.qunar.order.service.national;

import com.apin.qunar.order.dao.model.NationalFlightChange;
import com.apin.qunar.order.domain.national.flightChange.SearchFlightChangeVO;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-26 15:16
 */
public interface FlightChangeService {
    List<SearchFlightChangeVO> queryPageList(String merchantNo, Integer offset, Integer limit);

    void saveFlightChange(NationalFlightChange flightChange);

    boolean smsNotify(String merchantNo, String orderNo);
}