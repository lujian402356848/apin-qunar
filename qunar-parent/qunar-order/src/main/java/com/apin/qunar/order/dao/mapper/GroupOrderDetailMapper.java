package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.GroupOrderDetail;
import com.apin.qunar.order.dao.model.GroupOrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupOrderDetailMapper {
    int countByExample(GroupOrderDetailExample example);

    int deleteByExample(GroupOrderDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GroupOrderDetail record);

    int insertSelective(GroupOrderDetail record);

    List<GroupOrderDetail> selectByExample(GroupOrderDetailExample example);

    GroupOrderDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GroupOrderDetail record, @Param("example") GroupOrderDetailExample example);

    int updateByExample(@Param("record") GroupOrderDetail record, @Param("example") GroupOrderDetailExample example);

    int updateByPrimaryKeySelective(GroupOrderDetail record);

    int updateByPrimaryKey(GroupOrderDetail record);
}