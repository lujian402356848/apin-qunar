package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author fy
 * @version 2018-08-06 16:49
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchFlightRequest extends BaseRequest {
    /**
     * 起飞机场三字码.
     */
    @NotEmpty(message = "dpt不能为空")
    private String dpt;

    /**
     * 到达机场三字码
     */
    @NotEmpty(message = "arr不能为空")
    private String arr;

    /**
     * 起飞日期.
     */
    @NotEmpty(message = "date不能为空")
    private String date;

    /**
     * 报价类型。报价类型默认为youxuan
     */
    @NotEmpty(message = "exTrack不能为空")
    private String exTrack;

}


