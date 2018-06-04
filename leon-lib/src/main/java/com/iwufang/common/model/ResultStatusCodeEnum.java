package com.iwufang.common.model;

/**
 * 枚举 状态
 * @package: com.iwufang.common.model
 * @author: leon<swchenminglei@163.com>
 * @date: 2017/11/1 16:18
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
public enum ResultStatusCodeEnum {
    OK(0, "OK"),
    SYSTEM_ERR(10001, "System error"),
    MESSAGE_SEND_ERR(10002,"messge send failed");

    private int errcode;
    private String errmsg;

    ResultStatusCodeEnum(int errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
