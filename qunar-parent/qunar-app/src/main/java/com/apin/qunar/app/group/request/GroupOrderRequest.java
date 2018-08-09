package com.apin.qunar.app.group.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

    @Data
    @EqualsAndHashCode(callSuper = true)
    public class GroupOrderRequest extends BaseRequest implements Serializable {
        private static final long serialVersionUID = 1L;

        private String dept_city;
        private String arri_city;
        private String dept_date;
        private Integer people_count;
    }

