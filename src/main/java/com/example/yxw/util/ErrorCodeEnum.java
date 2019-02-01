package com.example.yxw.util;

public enum ErrorCodeEnum {
    SUCCESS(10001,"成功");

    private int code;
    private String msg;
    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg= msg;

    }
    
    public static String getErrorMsg(int code){
        for (ErrorCodeEnum e:ErrorCodeEnum.values()) {
            if(e.getCode()==code){
                return e.getMsg();
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
