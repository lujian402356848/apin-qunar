package com.apin.qunar.app.basic.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-07-23 15:18
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchMerchantListRequest extends BaseRequest {
    private Integer offset;
    private Integer limit;
}