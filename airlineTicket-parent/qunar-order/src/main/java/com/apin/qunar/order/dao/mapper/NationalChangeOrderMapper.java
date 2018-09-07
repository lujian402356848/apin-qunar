package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.NationalChangeOrder;
import com.apin.qunar.order.dao.model.NationalChangeOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NationalChangeOrderMapper {
    int countByExample(NationalChangeOrderExample example);

    int deleteByExample(NationalChangeOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NationalChangeOrder record);

    int insertSelective(NationalChangeOrder record);

    List<NationalChangeOrder> selectByExample(NationalChangeOrderExample example);

    NationalChangeOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NationalChangeOrder record, @Param("example") NationalChangeOrderExample example);

    int updateByExample(@Param("record") NationalChangeOrder record, @Param("example") NationalChangeOrderExample example);

    int updateByPrimaryKeySelective(NationalChangeOrder record);

    int updateByPrimaryKey(NationalChangeOrder record);
}