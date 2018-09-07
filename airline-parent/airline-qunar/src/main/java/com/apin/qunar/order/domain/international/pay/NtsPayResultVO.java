package com.apin.qunar.order.domain.international.pay;

import lombok.Data;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-17 16:45
 */
@Data
public class NtsPayResultVO {
    private String payAmount;
    private List<String> payIds;
}
