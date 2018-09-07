package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.InternationalPayFailOrder;
import com.apin.qunar.order.dao.model.InternationalPayFailOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InternationalPayFailOrderMapper {
    int countByExample(InternationalPayFailOrderExample example);

    int deleteByExample(InternationalPayFailOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InternationalPayFailOrder record);

    int insertSelective(InternationalPayFailOrder record);

    List<InternationalPayFailOrder> selectByExample(InternationalPayFailOrderExample example);

    InternationalPayFailOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InternationalPayFailOrder record, @Param("example") InternationalPayFailOrderExample example);

    int updateByExample(@Param("record") InternationalPayFailOrder record, @Param("example") InternationalPayFailOrderExample example);

    int updateByPrimaryKeySelective(InternationalPayFailOrder record);

    int updateByPrimaryKey(InternationalPayFailOrder record);
}