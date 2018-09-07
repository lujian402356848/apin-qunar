package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.changeSearch.ChangeSearchParam;
import com.apin.qunar.order.domain.national.changeSearch.ChangeSearchResultVO;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-02 11:08
 */
public interface ChangeSearchService {
    ApiResult<List<ChangeSearchResultVO>> changeSearch(final ChangeSearchParam changeSearchParam);
}
