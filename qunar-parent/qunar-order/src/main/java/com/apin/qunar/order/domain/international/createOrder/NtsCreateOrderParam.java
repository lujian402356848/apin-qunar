package com.apin.qunar.order.domain.international.createOrder;

import lombok.Data;

import java.util.List;

/**
 * Created by wangliang.wang on 2017/10/31.
 */
@Data
public class NtsCreateOrderParam {
    private String source;
    private String bookingTagKey;
    private List<Passenger> passengerList;
    private Contact contact;
    private Xcd xcd;
}
