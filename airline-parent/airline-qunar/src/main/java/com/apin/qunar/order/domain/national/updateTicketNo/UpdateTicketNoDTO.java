package com.apin.qunar.order.domain.national.updateTicketNo;

import lombok.Data;

@Data
public class UpdateTicketNoDTO {
    private String oldTicketNo;
    private String newTicketNo;
    private String ttsOrderNo;
    private String updateTime;
}
