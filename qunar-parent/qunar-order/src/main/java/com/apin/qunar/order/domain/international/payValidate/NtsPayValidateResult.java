package com.apin.qunar.order.domain.international.payValidate;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-07-09 20:10
 */
@Data
public class NtsPayValidateResult {
    private boolean priceChange;
    private String oldTotalPrice;
    private String currentTotalPrice;
}
