package com.apin.qunar.order.service.common;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.common.searchSign.SearchSignParam;
import com.apin.qunar.order.domain.common.searchSign.SearchSignResultVO;

/**
 * @outhor lujian
 * @create 2018-07-02 11:09
 */
public interface SearchSignService {
    ApiResult<SearchSignResultVO> searchSign(SearchSignParam searchSignParam);
}
