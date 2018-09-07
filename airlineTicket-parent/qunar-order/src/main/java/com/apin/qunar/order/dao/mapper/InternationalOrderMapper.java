package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.InternationalOrder;
import com.apin.qunar.order.dao.model.InternationalOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InternationalOrderMapper {
    int countByExample(InternationalOrderExample example);

    int deleteByExample(InternationalOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InternationalOrder record);

    int insertSelective(InternationalOrder record);

    List<InternationalOrder> selectByExample(InternationalOrderExample example);

    InternationalOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InternationalOrder record, @Param("example") InternationalOrderExample example);

    int updateByExample(@Param("record") InternationalOrder record, @Param("example") InternationalOrderExample example);

    int updateByPrimaryKeySelective(InternationalOrder record);

    int updateByPrimaryKey(InternationalOrder record);
}