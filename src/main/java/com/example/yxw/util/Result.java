package com.example.yxw.util;



import javax.servlet.http.HttpServletRequest;

/**
 * @author yangz
 */
public class Result<T> {

    private String msgCode;

    private String msg;

    private T data;

    public Result(String errorCode, T data, HttpServletRequest request) {
        this.msgCode = errorCode;
//        this.msg = BundleUtil.getMessage(request, errorCode);
        this.data = data;
        this.msg = ErrorCodeEnum.getErrorMsg(Integer.parseInt(errorCode));
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
