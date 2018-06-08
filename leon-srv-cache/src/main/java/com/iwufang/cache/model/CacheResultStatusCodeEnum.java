package com.iwufang.cache.model;

/**
 * @package: com.iwufang.cache.model
 * @author: 陈明磊<swchenminglei@163.com>
 * @date: 2017/12/5 15:01
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
public enum CacheResultStatusCodeEnum {
    SET_REDIS_FAIL(20001, "存入redis失败");

    private int errcode;
    private String errmsg;

    private CacheResultStatusCodeEnum(int errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public int getErrcode() {
        return this.errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

}
