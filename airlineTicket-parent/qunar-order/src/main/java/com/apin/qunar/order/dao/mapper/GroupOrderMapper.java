package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.GroupOrder;
import com.apin.qunar.order.dao.model.GroupOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupOrderMapper {
    int countByExample(GroupOrderExample example);

    int deleteByExample(GroupOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GroupOrder record);

    int insertSelective(GroupOrder record);

    List<GroupOrder> selectByExample(GroupOrderExample example);

    GroupOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GroupOrder record, @Param("example") GroupOrderExample example);

    int updateByExample(@Param("record") GroupOrder record, @Param("example") GroupOrderExample example);

    int updateByPrimaryKeySelective(GroupOrder record);

    int updateByPrimaryKey(GroupOrder record);
}