package com.apin.qunar.order.domain.international.payValidate;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-07-17 16:46
 */
@Data
public class NtsPayValidateResultVO {
    private boolean priceChange;
    private String oldTotalPrice;
    private String currentTotalPrice;
}
