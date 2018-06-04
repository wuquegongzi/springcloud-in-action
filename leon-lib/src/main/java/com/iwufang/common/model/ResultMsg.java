package com.iwufang.common.model;

/**
 * 返回信息
 * @package: com.iwufang.common.model
 * @author: Leon<swchenminglei@163.com>
 * @date: 2017/11/1 16:18
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
public class ResultMsg {

    private int errcode;
    private String errmsg;
    private Object p2pdata;

    public ResultMsg(int errcode, String errmsg, Object p2pdata) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.p2pdata = p2pdata;
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

    public Object getP2pdata() {
        return p2pdata;
    }

    public void setP2pdata(Object p2pdata) {
        this.p2pdata = p2pdata;
    }
}
