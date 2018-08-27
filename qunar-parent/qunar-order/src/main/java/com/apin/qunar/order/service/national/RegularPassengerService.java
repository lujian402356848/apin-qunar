package com.apin.qunar.order.service.national;

import com.apin.qunar.basic.domain.ExecuteResult;
import com.apin.qunar.order.domain.national.regularPassenger.RegularPassengerBO;
import com.apin.qunar.order.domain.national.regularPassenger.RegularPassengerVO;

import java.util.List;

public interface RegularPassengerService {

    List<RegularPassengerVO> queryPageListBy(String account, String name, Integer offset, Integer limit);

    ExecuteResult create(RegularPassengerBO regularPassengerBO);

    boolean change(RegularPassengerBO regularPassengerBO);

    boolean delete(Long id);

    Integer queryCount(String account, String name);
}
