package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-06-27 17:23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchRefundChangeSignRequest extends BaseRequest {
    private String flightNum;
    private String cabin;
    private String dpt;
    private String arr;
    private String dptDate;
    private String dptTime;
    private long policyId;
    private float maxSellPrice;
    private float minSellPrice;
    private float printPrice;
    private String tagName;
    private boolean translate;
    private int sfid;
    private boolean needPercentTgqText;
    private String businessExt;
    private String client;
}
