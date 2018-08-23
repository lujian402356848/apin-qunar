package com.apin.qunar.basic.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantExtMapper {

    /**
     * 通过用户的商户号从数据库中找到对应的秘钥
     *
     * @param merchantNo 用户的商户号.
     * @return 秘钥
     */
    @Select(" SELECT secret_key FROM  `merchant`WHERE  merchant_no = #{merchantNo}")
    String queryUserSecretKey(@Param("merchantNo") String merchantNo);
}