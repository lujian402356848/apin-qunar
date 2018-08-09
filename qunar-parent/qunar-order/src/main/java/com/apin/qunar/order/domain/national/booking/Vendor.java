package com.apin.qunar.order.domain.national.booking;

import lombok.Data;

import java.util.Map;

/**
 * Created by wjjunjjun.wang on 2017/7/26.
 */
@Data
public class Vendor {
    private String businessExt;
    private int vppr;
    private int barePrice;
    private int price;
    private int basePrice;
    private String domain = "";
    private String policyType = "";
    private String policyId = "";
    private String discount = "";
    private String prtag = "";
    private String bprtag = "";
    private String tag;
    private String cabin = "";
    private String cabinCount = "";
    private int cabinType;
    private String wrapperId = "";
    private String afee = "";
    private String it = "";
    private Integer groupId = Integer.valueOf(-1);
    private Map<String, String> extMap;
    private TgqShowData tgqShowData;
    private String luggage;
    private String pType = "";
    private boolean fuzzy = false;
}
