package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.NationalPayFailOrder;
import com.apin.qunar.order.dao.model.NationalPayFailOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NationalPayFailOrderMapper {
    int countByExample(NationalPayFailOrderExample example);

    int deleteByExample(NationalPayFailOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NationalPayFailOrder record);

    int insertSelective(NationalPayFailOrder record);

    List<NationalPayFailOrder> selectByExample(NationalPayFailOrderExample example);

    NationalPayFailOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NationalPayFailOrder record, @Param("example") NationalPayFailOrderExample example);

    int updateByExample(@Param("record") NationalPayFailOrder record, @Param("example") NationalPayFailOrderExample example);

    int updateByPrimaryKeySelective(NationalPayFailOrder record);

    int updateByPrimaryKey(NationalPayFailOrder record);
}