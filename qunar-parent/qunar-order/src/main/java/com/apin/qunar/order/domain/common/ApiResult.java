package com.apin.qunar.order.domain.common;

public class ApiResult<T> {
    private static final int SUCCESS_CODE = 0;

    /**
     * 返回码
     */
    private int code = -1;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 时间戳
     */
    private long createTime;

    /**
     * 应用返回
     */
    private T result;

    public ApiResult() {
    }

    public ApiResult(int code, String message, long createTime, T result) {
        this.code = code;
        this.message = message;
        this.createTime = createTime;
        this.result = result;
    }

    public ApiResult(ApiResult apiResult, T result) {
        this.code = apiResult.getCode();
        this.message = apiResult.getMessage();
        this.createTime = apiResult.getCreateTime();
        this.result = result;
    }

    public static <T> ApiResult<T> fail() {
        ApiResult<T> openApiResult = new ApiResult<>();
        openApiResult.setCode(-1);
        openApiResult.setMessage("DEFAULT_FAIL");
        openApiResult.setResult(null);
        return openApiResult;
    }

    public static <T> ApiResult<T> fail(int code, String msg) {
        ApiResult<T> openApiResult = new ApiResult<>();
        openApiResult.setCode(code);
        openApiResult.setMessage(msg);
        openApiResult.setResult(null);
        return openApiResult;
    }

    public boolean isSuccess() {
        return code == SUCCESS_CODE;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
