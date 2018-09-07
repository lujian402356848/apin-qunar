package com.apin.qunar.order.domain.common.searchSign;

import lombok.Data;

/**
 * Created by wangliang.wang on 2017/7/26.
 */
@Data
public class SearchSignResult {
    private String bankCode;
    private String finishSignTime;
    private String retHtml;
    private String signStatus;
    private String signedAccount;
}
