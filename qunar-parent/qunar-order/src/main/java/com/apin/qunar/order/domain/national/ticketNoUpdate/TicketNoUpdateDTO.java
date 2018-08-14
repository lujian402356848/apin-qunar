package com.apin.qunar.order.domain.national.ticketNoUpdate;

import lombok.Data;

@Data
public class TicketNoUpdateDTO {
    private String oldTicketNo;
    private String newTicketNo;
    private String ttsOrderNo;
    private String updateTime;
}
