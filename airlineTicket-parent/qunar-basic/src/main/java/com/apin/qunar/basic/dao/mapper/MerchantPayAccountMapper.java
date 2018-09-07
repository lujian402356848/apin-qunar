package com.apin.qunar.basic.dao.mapper;

import com.apin.qunar.basic.dao.model.MerchantPayAccount;
import com.apin.qunar.basic.dao.model.MerchantPayAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantPayAccountMapper {
    int countByExample(MerchantPayAccountExample example);

    int deleteByExample(MerchantPayAccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MerchantPayAccount record);

    int insertSelective(MerchantPayAccount record);

    List<MerchantPayAccount> selectByExample(MerchantPayAccountExample example);

    MerchantPayAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MerchantPayAccount record, @Param("example") MerchantPayAccountExample example);

    int updateByExample(@Param("record") MerchantPayAccount record, @Param("example") MerchantPayAccountExample example);

    int updateByPrimaryKeySelective(MerchantPayAccount record);

    int updateByPrimaryKey(MerchantPayAccount record);
}