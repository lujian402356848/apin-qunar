package com.apin.qunar.order.dao.impl;


import com.apin.qunar.order.dao.mapper.InternationalRegularPassengerExtMapper;
import com.apin.qunar.order.dao.mapper.InternationalRegularPassengerMapper;
import com.apin.qunar.order.dao.model.InternationalRegularPassenger;
import com.apin.qunar.order.dao.model.InternationalRegularPassengerExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @outhor ligang
 * @create 2018-08-07 17:02
 */
@Repository
public class InternationalRegularPassengerDaoImpl {
    @Autowired
    private InternationalRegularPassengerMapper regularPassengerMapper;
    @Autowired
    private InternationalRegularPassengerExtMapper regularPassengerExtMapper;

    public boolean insert(InternationalRegularPassenger regularPassenger) {
        return regularPassengerMapper.insert(regularPassenger) > 0;
    }

    public boolean update(InternationalRegularPassenger regularPassenger) {
        return regularPassengerMapper.updateByPrimaryKeySelective(regularPassenger) > 0;
    }

    public boolean deletePassenger(Long id) {
        return regularPassengerMapper.deleteByPrimaryKey(id) > 0;
    }

    public boolean isExistCardNo(String cardNo) {
        return regularPassengerExtMapper.queryCntByCardNo(cardNo) > 0;
    }

    public List<InternationalRegularPassenger> queryPageListBy(String account, String name, Integer offset, Integer limit) {
        InternationalRegularPassengerExample example = new InternationalRegularPassengerExample();
        InternationalRegularPassengerExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(account)) {
            criteria.andOperatorEqualTo(account);
        }
        if (StringUtils.isNotBlank(name)) {
            criteria.andNameEqualTo(name);
        }
        example.setMysqlOffset(offset);
        example.setMysqlLength(limit);
        example.setOrderByClause("insert_time desc");
        return regularPassengerMapper.selectByExample(example);
    }
}
