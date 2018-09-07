package com.apin.qunar.order.domain.international.pay;

import lombok.Data;

import java.util.List;

/**
 * Created by wangliang.wang on 2017/10/26.
 */
@Data
public class NtsPayResult {
    private String payAmount;
    private List<String> payIds;
}
