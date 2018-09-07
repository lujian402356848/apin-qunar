package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.dao.model.NationalOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NationalOrderMapper {
    int countByExample(NationalOrderExample example);

    int deleteByExample(NationalOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NationalOrder record);

    int insertSelective(NationalOrder record);

    List<NationalOrder> selectByExample(NationalOrderExample example);

    NationalOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NationalOrder record, @Param("example") NationalOrderExample example);

    int updateByExample(@Param("record") NationalOrder record, @Param("example") NationalOrderExample example);

    int updateByPrimaryKeySelective(NationalOrder record);

    int updateByPrimaryKey(NationalOrder record);
}