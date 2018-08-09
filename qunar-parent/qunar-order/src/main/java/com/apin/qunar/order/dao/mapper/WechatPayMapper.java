package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.WechatPay;
import com.apin.qunar.order.dao.model.WechatPayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WechatPayMapper {
    int countByExample(WechatPayExample example);

    int deleteByExample(WechatPayExample example);

    int deleteByPrimaryKey(String id);

    int insert(WechatPay record);

    int insertSelective(WechatPay record);

    List<WechatPay> selectByExample(WechatPayExample example);

    WechatPay selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WechatPay record, @Param("example") WechatPayExample example);

    int updateByExample(@Param("record") WechatPay record, @Param("example") WechatPayExample example);

    int updateByPrimaryKeySelective(WechatPay record);

    int updateByPrimaryKey(WechatPay record);
}