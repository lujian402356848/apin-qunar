package com.apin.qunar.order.service.group.impl;

import com.apin.qunar.common.ids.IDGenerator;
import com.apin.qunar.order.dao.impl.GroupOrderDaoImpl;
import com.apin.qunar.order.dao.model.GroupOrder;
import com.apin.qunar.order.domain.group.searchOrderList.GroupOrderParam;
import com.apin.qunar.order.domain.group.searchOrderList.GroupOrderResultVO;
import com.apin.qunar.order.service.group.GroupOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * @outhor ligang
 * @create 2018-07-19 21:58
 */
@Slf4j
@Service
public class GroupOrderServiceImpl implements GroupOrderService {
    @Autowired
    private DataSourceTransactionManager transactionManager;
    @Autowired
    private GroupOrderDaoImpl groupOrderDao;

    @Override
    public List<GroupOrderResultVO> queryList(GroupOrderParam groupOrderParam) {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_SERIALIZABLE);
        TransactionStatus status = transactionManager.getTransaction(definition);//事务开始
        GroupOrder groupOrder = buildGroupOrder(groupOrderParam);
        try {
            groupOrderDao.insert(groupOrder);
            transactionManager.commit(status);//提交事务
        } catch (Exception e) {
            transactionManager.rollback(status);//事务回滚
            log.error("保存拼团订单到数据库异常,ntsCreateOrderResult:{},ntsCreateOrderParam:{}", groupOrderParam, e);
        }
        return new ArrayList<>();
    }

    public GroupOrder buildGroupOrder(GroupOrderParam groupOrderParam) {
        GroupOrder groupOrder = new GroupOrder();
        groupOrder.setId(IDGenerator.getUniqueId());
        groupOrder.setArriCity(groupOrderParam.getArriCity());
        groupOrder.setDeptCity(groupOrderParam.getDeptCity());
        groupOrder.setDeptDate(groupOrderParam.getDeptDate());
        Integer count = groupOrderParam.getPeopleCount();
        int peopleCount = (int) (1 + Math.random() * (4 - 1 + 1)) + count;
        if (peopleCount < 9) {
            groupOrder.setGroupStatus(0);
        } else {
            groupOrder.setGroupStatus(1);
        }
        groupOrder.setPeopleCount(peopleCount);
        return groupOrder;
    }

    ;

}
