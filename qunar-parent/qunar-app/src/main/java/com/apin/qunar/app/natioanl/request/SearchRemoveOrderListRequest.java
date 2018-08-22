package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * @outhor lujian
 * @create 2018-06-27 16:32
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchRemoveOrderListRequest extends BaseRequest {
    private Integer offset;
    private Integer limit;
    private Integer status = -1;
    @NotEmpty(message = "account不能为空")
    private String account;
}
