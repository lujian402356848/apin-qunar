package com.apin.qunar.order.service.international;

import com.apin.qunar.basic.domain.ExecuteResult;
import com.apin.qunar.order.domain.international.regularPassenger.NtsRegularPassengerBO;
import com.apin.qunar.order.domain.international.regularPassenger.NtsRegularPassengerVO;

import java.util.List;

public interface NtsRegularPassengerService {
    List<NtsRegularPassengerVO> queryPageListBy(String account, String name, Integer offset, Integer limit);

    ExecuteResult create(NtsRegularPassengerBO ntsRegularPassengerBO);

    boolean change(NtsRegularPassengerBO ntsRegularPassengerBO);

    boolean remove(Long id);
}
