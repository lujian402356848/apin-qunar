package com.apin.qunar.order.service.international;

import com.apin.qunar.order.dao.model.InternationalFlightChange;
import com.apin.qunar.order.domain.international.flightChange.NtsSearchFlightChangeVO;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-26 15:15
 */
public interface NtsFlightChangeService {
    List<NtsSearchFlightChangeVO> queryPageList(String merchantNo, Integer offset, Integer limit);

    Integer queryCount(String merchantNo);

    void saveFlightChange(InternationalFlightChange flightChange);

    boolean smsNotify(String merchantNo, String orderNo);
}
