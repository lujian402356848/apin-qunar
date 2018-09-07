package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.domain.national.updateTicketNo.UpdateTicketNoDTO;
import com.apin.qunar.order.service.national.UpdateTicketNoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UpdateTicketNoServiceImpl implements UpdateTicketNoService {
    @Autowired
    NationalOrderDaoImpl nationalOrderDao;

    @Override
    public void updateOrder(UpdateTicketNoDTO updateTicketNoDTO) {
        if (updateTicketNoDTO == null || StringUtils.isBlank(updateTicketNoDTO.getTtsOrderNo())) {
            return;
        }
        nationalOrderDao.updateTicketNo(updateTicketNoDTO.getTtsOrderNo(), updateTicketNoDTO.getOldTicketNo(), updateTicketNoDTO.getNewTicketNo());
    }
}
