package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.domain.national.ticketNoUpdate.TicketNoUpdateDTO;
import com.apin.qunar.order.service.national.TicketNoUpdateService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class TicketNoUpdateServiceImpl implements TicketNoUpdateService {
    @Autowired
    NationalOrderDaoImpl nationalOrderDao;

    @Override
    public void updateOrder(TicketNoUpdateDTO ticketNoUpdateDTO) {
        if(ticketNoUpdateDTO == null || StringUtils.isBlank(ticketNoUpdateDTO.getTtsOrderNo())) {
            return;
        }
        nationalOrderDao.updateTicketNo(ticketNoUpdateDTO.getTtsOrderNo(),ticketNoUpdateDTO.getOldTicketNo(),ticketNoUpdateDTO.getNewTicketNo());
    }
}
