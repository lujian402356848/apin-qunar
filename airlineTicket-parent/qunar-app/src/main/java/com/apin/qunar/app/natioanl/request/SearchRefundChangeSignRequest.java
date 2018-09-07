package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @outhor lujian
 * @create 2018-06-27 17:23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchRefundChangeSignRequest extends BaseRequest {
    @NotEmpty(message = "flightNum不能为空")
    private String flightNum;
    @NotEmpty(message = "cabin不能为空")
    private String cabin;
    @NotEmpty(message = "dpt不能为空")
    private String dpt;
    @NotEmpty(message = "arr不能为空")
    private String arr;
    @NotEmpty(message = "dptDate不能为空")
    private String dptDate;
    @NotEmpty(message = "dptTime不能为空")
    private String dptTime;
    @NotNull(message = "policyId不能为空")
    private long policyId;
    @NotNull(message = "maxSellPrice不能为空")
    private float maxSellPrice;
    @NotNull(message = "minSellPrice不能为空")
    private float minSellPrice;
    @NotNull(message = "printPrice不能为空")
    private float printPrice;
    @NotEmpty(message = "tagName不能为空")
    private String tagName;
    private boolean translate;
    @NotNull(message = "sfid不能为空")
    private int sfid;
    private boolean needPercentTgqText;
    @NotEmpty(message = "businessExt不能为空")
    private String businessExt;
    @NotEmpty(message = "client不能为空")
    private String client;
}
