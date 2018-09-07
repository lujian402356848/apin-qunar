package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.InternationalRegularPassenger;
import com.apin.qunar.order.dao.model.InternationalRegularPassengerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InternationalRegularPassengerMapper {
    int countByExample(InternationalRegularPassengerExample example);

    int deleteByExample(InternationalRegularPassengerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InternationalRegularPassenger record);

    int insertSelective(InternationalRegularPassenger record);

    List<InternationalRegularPassenger> selectByExample(InternationalRegularPassengerExample example);

    InternationalRegularPassenger selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InternationalRegularPassenger record, @Param("example") InternationalRegularPassengerExample example);

    int updateByExample(@Param("record") InternationalRegularPassenger record, @Param("example") InternationalRegularPassengerExample example);

    int updateByPrimaryKeySelective(InternationalRegularPassenger record);

    int updateByPrimaryKey(InternationalRegularPassenger record);
}