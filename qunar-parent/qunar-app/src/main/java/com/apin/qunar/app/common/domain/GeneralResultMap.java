package com.apin.qunar.app.common.domain;

import com.apin.qunar.common.enums.SysReturnCode;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @outhor lujian
 * @create 2018-06-23 11:47
 */
public class GeneralResultMap extends HashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = 3536613179626466634L;

    private final String MESSSAGE = "message";
    private final String CODE = "code";
    private final String DATA = "data";
    private boolean isSuccess = true;

    public GeneralResultMap() {
        super.put(MESSSAGE, "OK");
        super.put(CODE, 0);
        super.put(DATA, new HashMap<String, Object>());
    }

    public void setResult(SysReturnCode sysMsg) {
        setResult(sysMsg, null);
    }

    public void setResult(SysReturnCode sysMsg, String desc) {
        setResult(sysMsg, desc, null);
    }

    public void setResult(SysReturnCode sysMsg, Object data) {
        setResult(sysMsg, null, data);
    }

    public void setResult(SysReturnCode sysMsg, String desc, Object data) {
        if (sysMsg != null) {
            if (StringUtils.isNotEmpty(desc)) {
                setMessage(desc);
            } else {
                setMessage(sysMsg.getMsg4Cn());
            }
            setCode(sysMsg.getCode());
        }

        if (data != null) {
            setData(data);
        } else {
            if (!super.containsKey(DATA)) {
                setData(new HashMap<String, Object>());
            }
        }
    }

    public void setResult(Integer code) {
        setResult(code, null, null);
    }

    public void setResult(Integer code, String message) {
        setResult(code, message, null);
    }

    public void setResult(Integer code, String message, Object data) {
        setCode(code);
        setMessage(message == null ? "" : message);
        setData(data == null ? new HashMap<String, Object>() : data);
    }

    public String getMessage() {
        return String.valueOf(super.get(MESSSAGE));
    }

    public void setMessage(String value) {
        super.put(MESSSAGE, value);
    }

    public String getCODE() {
        return CODE;
    }

    public void setCode(Integer code) {
        super.put(CODE, code);
    }

    public void setData(Object data) {
        super.put(DATA, data);
    }

    public Object getData() {
        return super.get(DATA);
    }

    public boolean isSuccess() {
        return "0".equals(super.get(CODE).toString());
    }
}