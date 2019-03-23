package com.github.sys.exception;


/**
 * Exception code 所有的异常定义在此处
 */
public enum ResponseCode {
    SUCCESS(200, "成功"),
    SERVER_ERROR(500,"server error"),

    ROLE_NOT_FOUND(20404,"role has not found"),
    ;


    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    protected void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    protected void setMsg(String msg) {
        this.msg = msg;
    }
}
