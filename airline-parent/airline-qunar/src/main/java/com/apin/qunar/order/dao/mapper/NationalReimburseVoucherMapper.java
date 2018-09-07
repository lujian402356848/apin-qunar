package com.apin.qunar.order.dao.mapper;

import com.apin.qunar.order.dao.model.NationalReimburseVoucher;
import com.apin.qunar.order.dao.model.NationalReimburseVoucherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NationalReimburseVoucherMapper {
    int countByExample(NationalReimburseVoucherExample example);

    int deleteByExample(NationalReimburseVoucherExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NationalReimburseVoucher record);

    int insertSelective(NationalReimburseVoucher record);

    List<NationalReimburseVoucher> selectByExample(NationalReimburseVoucherExample example);

    NationalReimburseVoucher selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NationalReimburseVoucher record, @Param("example") NationalReimburseVoucherExample example);

    int updateByExample(@Param("record") NationalReimburseVoucher record, @Param("example") NationalReimburseVoucherExample example);

    int updateByPrimaryKeySelective(NationalReimburseVoucher record);

    int updateByPrimaryKey(NationalReimburseVoucher record);
}