package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.NationalReturnPassenger;
import com.apin.qunar.order.dao.model.NationalReturnPassengerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NationalReturnPassengerMapper {
    int countByExample(NationalReturnPassengerExample example);

    int deleteByExample(NationalReturnPassengerExample example);

    int deleteByPrimaryKey(String id);

    int insert(NationalReturnPassenger record);

    int insertSelective(NationalReturnPassenger record);

    List<NationalReturnPassenger> selectByExample(NationalReturnPassengerExample example);

    NationalReturnPassenger selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NationalReturnPassenger record, @Param("example") NationalReturnPassengerExample example);

    int updateByExample(@Param("record") NationalReturnPassenger record, @Param("example") NationalReturnPassengerExample example);

    int updateByPrimaryKeySelective(NationalReturnPassenger record);

    int updateByPrimaryKey(NationalReturnPassenger record);
}