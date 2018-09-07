package com.apin.qunar.basic.dao.mapper;

import com.apin.qunar.basic.dao.model.MerchantPriceConfig;
import com.apin.qunar.basic.dao.model.MerchantPriceConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantPriceConfigMapper {
    int countByExample(MerchantPriceConfigExample example);

    int deleteByExample(MerchantPriceConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MerchantPriceConfig record);

    int insertSelective(MerchantPriceConfig record);

    List<MerchantPriceConfig> selectByExample(MerchantPriceConfigExample example);

    MerchantPriceConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MerchantPriceConfig record, @Param("example") MerchantPriceConfigExample example);

    int updateByExample(@Param("record") MerchantPriceConfig record, @Param("example") MerchantPriceConfigExample example);

    int updateByPrimaryKeySelective(MerchantPriceConfig record);

    int updateByPrimaryKey(MerchantPriceConfig record);
}