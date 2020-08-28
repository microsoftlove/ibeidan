package com.ibeidan.web.dutychain4;

import java.io.Serializable;

/**
 * @author lee
 * DATE 2020/8/11 12:52
 */
public class Result implements Serializable {
    private static final long serialVersionUID = 4315652289788788586L;

    private Integer code;
    private boolean flag;
    private String  msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
