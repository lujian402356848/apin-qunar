package com.apin.qunar.order.domain.group.searchOrderList;

import lombok.Data;

/**
 * @outhor ligang
 * @create 2018-07-19 19:59
 */
@Data
public class GroupOrderResultVO {
    private String groupNo;
    private String deptCity;
    private String arriCity;
    private String deptDate;
    private Integer peopleCount;
    private Integer groupStatus;
}
