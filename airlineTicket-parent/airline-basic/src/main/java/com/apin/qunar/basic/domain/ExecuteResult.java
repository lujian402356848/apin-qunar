package com.apin.qunar.basic.domain;

import lombok.Data;

@Data
public class ExecuteResult {
    private boolean isSuccess = false;
    private String desc = "";

    public ExecuteResult() {
    }

    public ExecuteResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public ExecuteResult(boolean isSuccess, String desc) {
        this.isSuccess = isSuccess;
        this.desc = desc;
    }
}
