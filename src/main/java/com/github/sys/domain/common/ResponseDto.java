package com.github.sys.domain.common;

/**
 * Created by renhongqiang on 2019-03-16 22:29
 */
public class ResponseDto<T> {
    private int code;
    private String msg;
    private T data;

    public ResponseDto(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseDto(T data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }

    public ResponseDto(String msg) {
        this.msg = msg;
    }

    public ResponseDto(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseDto error(int code, String msg) {
        return new ResponseDto(code, msg);
    }

    public static <T>  ResponseDto<T> ok(T data) {
        return new ResponseDto(data);
    }

    public static <T>  ResponseDto<T> ok() {
        return new ResponseDto(null);
    }

    public boolean isSuccess() {
        return this.code == 200;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
