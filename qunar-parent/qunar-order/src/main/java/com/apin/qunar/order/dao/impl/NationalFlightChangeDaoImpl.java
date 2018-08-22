package com.apin.qunar.order.dao.impl;

import com.apin.qunar.order.dao.mapper.NationalFlightChangeMapper;
import com.apin.qunar.order.dao.model.NationalFlightChange;
import com.apin.qunar.order.dao.model.NationalFlightChangeExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-26 22:19
 */
@Repository
public class NationalFlightChangeDaoImpl {
    @Autowired
    private NationalFlightChangeMapper nationalFlightChangeMapper;

    public List<NationalFlightChange> queryPageList(String merchantNo, Integer offset, Integer limit) {
        NationalFlightChangeExample example = new NationalFlightChangeExample();
        NationalFlightChangeExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        example.setMysqlOffset(offset);
        example.setMysqlLength(limit);
        example.setOrderByClause("insert_time desc");
        return nationalFlightChangeMapper.selectByExample(example);
    }

    public NationalFlightChange queryByOrderNo(String orderNo) {
        NationalFlightChangeExample example = new NationalFlightChangeExample();
        NationalFlightChangeExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        List<NationalFlightChange> flightChanges = nationalFlightChangeMapper.selectByExample(example);
        return CollectionUtils.isEmpty(flightChanges) ? null : flightChanges.get(0);
    }

    public Boolean update(NationalFlightChange nationalFlightChange) {
        return nationalFlightChangeMapper.updateByPrimaryKeySelective(nationalFlightChange) > 0;
    }

    public boolean insert(NationalFlightChange nationalFlightChange) {
        return nationalFlightChangeMapper.insert(nationalFlightChange) > 0;
    }
}
