package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.AliPay;
import com.apin.qunar.order.dao.model.AliPayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AliPayMapper {
    int countByExample(AliPayExample example);

    int deleteByExample(AliPayExample example);

    int deleteByPrimaryKey(String id);

    int insert(AliPay record);

    int insertSelective(AliPay record);

    List<AliPay> selectByExample(AliPayExample example);

    AliPay selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AliPay record, @Param("example") AliPayExample example);

    int updateByExample(@Param("record") AliPay record, @Param("example") AliPayExample example);

    int updateByPrimaryKeySelective(AliPay record);

    int updateByPrimaryKey(AliPay record);
}