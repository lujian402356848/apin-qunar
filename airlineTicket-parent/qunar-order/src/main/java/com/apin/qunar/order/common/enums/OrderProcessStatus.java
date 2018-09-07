package com.apin.qunar.order.common.enums;

public enum OrderProcessStatus {
    WAIT_PROCESS(0, "待处理"),
    PROCESSING(1, "处理中"),
    PROCESS_FINISH(1, "处理完成");

    private int status;
    private String desc;

    OrderProcessStatus(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
