package com.apin.qunar.order.dao.impl;


import com.apin.qunar.order.dao.mapper.GroupOrderMapper;
import com.apin.qunar.order.dao.model.GroupOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @outhor ligang
 * @create 2018-07-19 22:09
 */
@Repository
public class GroupOrderDaoImpl {
    @Autowired
    GroupOrderMapper groupOrderMapper;
    public boolean insert(GroupOrder groupOrder) {
        return groupOrderMapper.insert(groupOrder) > 0;
    }

}
