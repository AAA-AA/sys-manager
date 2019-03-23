package com.github.sys.exception;

import lombok.Getter;

/**
 * Created by renhongqiang on 2019-03-21 19:31
 */
@Getter
public class ServiceException extends RuntimeException {

    private String msg;
    private int code;

    public ServiceException(String message, String msg, int code) {
        super(message);
        this.msg = msg;
        this.code = code;
    }

    public ServiceException(String msg, int code, Throwable cause) {
        super(cause);
        this.msg = msg;
        this.code = code;
    }

    public ServiceException(ResponseCode responseCode) {
        super(responseCode.getMsg());
        this.msg = responseCode.getMsg();
        this.code = responseCode.getCode();
    }
}


