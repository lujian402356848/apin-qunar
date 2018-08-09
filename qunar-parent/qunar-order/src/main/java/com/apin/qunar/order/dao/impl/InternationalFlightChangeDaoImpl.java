package com.apin.qunar.order.dao.impl;

import com.apin.qunar.order.dao.mapper.InternationalFlightChangeMapper;
import com.apin.qunar.order.dao.model.InternationalFlightChange;
import com.apin.qunar.order.dao.model.InternationalFlightChangeExample;
import com.apin.qunar.order.dao.model.NationalFlightChange;
import com.apin.qunar.order.dao.model.NationalFlightChangeExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-26 22:20
 */
@Repository
public class InternationalFlightChangeDaoImpl {
    @Autowired
    private InternationalFlightChangeMapper internationalFlightChangeMapper;

    public List<InternationalFlightChange> queryPageList(String merchantNo, Integer offset, Integer limit) {
        InternationalFlightChangeExample example = new InternationalFlightChangeExample();
        InternationalFlightChangeExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        example.setMysqlOffset(offset);
        example.setMysqlLength(limit);
        example.setOrderByClause("insert_time desc");
        return internationalFlightChangeMapper.selectByExample(example);
    }

    public InternationalFlightChange queryByOrderNo(String orderNo) {
        InternationalFlightChangeExample example = new InternationalFlightChangeExample();
        InternationalFlightChangeExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andMerchantNoEqualTo(orderNo);
        }
        List<InternationalFlightChange> flightChanges = internationalFlightChangeMapper.selectByExample(example);
        return CollectionUtils.isEmpty(flightChanges) ? null : flightChanges.get(0);
    }

    public Boolean update(InternationalFlightChange flightChange) {
        return internationalFlightChangeMapper.updateByPrimaryKeySelective(flightChange) > 0;
    }

    public boolean insert(InternationalFlightChange flightChange) {
        return internationalFlightChangeMapper.insert(flightChange) > 0;
    }
}
