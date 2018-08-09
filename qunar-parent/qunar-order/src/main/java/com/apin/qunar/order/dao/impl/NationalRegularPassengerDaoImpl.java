package com.apin.qunar.order.dao.impl;


import com.apin.qunar.order.dao.mapper.NationalRegularPassengerExtMapper;
import com.apin.qunar.order.dao.mapper.NationalRegularPassengerMapper;
import com.apin.qunar.order.dao.model.NationalRegularPassenger;
import com.apin.qunar.order.dao.model.NationalRegularPassengerExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @outhor ligang
 * @create 2018-08-07 17:02
 */
@Repository
public class NationalRegularPassengerDaoImpl {
    @Autowired
    private NationalRegularPassengerMapper regularPassengerMapper;
    @Autowired
    private NationalRegularPassengerExtMapper regularPassengerExtMapper;

    public boolean isExistCardNo(String cardNo) {
        return regularPassengerExtMapper.queryCntByCardNo(cardNo) > 0;
    }

    public boolean insert(NationalRegularPassenger regularPassenger) {
        return regularPassengerMapper.insert(regularPassenger) > 0;
    }


    public boolean update(NationalRegularPassenger regularPassenger) {
        return regularPassengerMapper.updateByPrimaryKeySelective(regularPassenger) > 0;
    }

    public boolean deletePassenger(Long id) {
        return regularPassengerMapper.deleteByPrimaryKey(id) > 0;
    }

    public List<NationalRegularPassenger> queryPageListBy(String account, String name, Integer offset, Integer limit) {
        NationalRegularPassengerExample example = new NationalRegularPassengerExample();
        NationalRegularPassengerExample.Criteria criteria = example.createCriteria();
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
