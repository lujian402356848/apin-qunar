package com.apin.qunar.app.basic.request;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-07-23 15:04
 */
@Data
public class CreateMerchantRequest{
    private String contactName;
    private String contactMobile;
    private String companyName;
    private String companyAddress;
    private String managerName;
}
