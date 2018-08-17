package com.apin.qunar.statistics.domain;

import lombok.Data;

@Data
public class SearchFlightRecordDTO {
    private String merchantNo;
    private String account;
    private String city;
    private int searchCnt;
}
