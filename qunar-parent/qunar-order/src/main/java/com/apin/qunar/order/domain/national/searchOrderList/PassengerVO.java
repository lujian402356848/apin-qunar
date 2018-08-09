package com.apin.qunar.order.domain.national.searchOrderList;

import lombok.Data;

import java.io.Serializable;

/**
 * @outhor lujian
 * @create 2018-07-02 17:37
 */
@Data
public class PassengerVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orderNo;
    private String name;
}
