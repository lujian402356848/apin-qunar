package com.apin.qunar.basic.dao.mapper;

import com.apin.qunar.basic.dao.model.Merchant;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    /**
     * 通过用户的邀请码查到下级商户
     *
     * @param contactMobile 用户的手机号.
     * @return 商户
     */
    @Select("SELECT m2.* from merchant m1 LEFT JOIN merchant m2 on m1.invite_code = m2.parent_invite_code where m1.contact_mobile = #{contactMobile}")
    @Results({
            @Result (column = "id", property = "id"),
            @Result(column = "merchant_no", property = "merchantNo"),
            @Result(column = "contact_name", property = "contactName"),
            @Result(column = "contact_mobile", property = "contactMobile"),
            @Result(column = "company_name", property = "companyName"),
            @Result(column = "company_address", property = "companyAddress"),
            @Result(column = "manager_name", property = "managerName")
    })
    List<Merchant> querySubordinateMerchant(@Param("contactMobile")String contactMobile);
}