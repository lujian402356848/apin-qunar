package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.NationalReturnOrder;
import com.apin.qunar.order.dao.model.NationalReturnOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NationalReturnOrderMapper {
    int countByExample(NationalReturnOrderExample example);

    int deleteByExample(NationalReturnOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NationalReturnOrder record);

    int insertSelective(NationalReturnOrder record);

    List<NationalReturnOrder> selectByExample(NationalReturnOrderExample example);

    NationalReturnOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NationalReturnOrder record, @Param("example") NationalReturnOrderExample example);

    int updateByExample(@Param("record") NationalReturnOrder record, @Param("example") NationalReturnOrderExample example);

    int updateByPrimaryKeySelective(NationalReturnOrder record);

    int updateByPrimaryKey(NationalReturnOrder record);
}