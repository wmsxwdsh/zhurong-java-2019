package com.zhurong.utils.response;

/**
 * 通用Response
 * 2018/11/6
 */
public class CommonR<T> {
    private String code;
    private String msg;
    private T data;

    public static CommonR build(String statusCode, String msg, Object data) {
        return new CommonR(statusCode, msg, data);
    }

    public static CommonR build(String statusCode, String msg) {
        return new CommonR(statusCode, msg, null);
    }

    public static CommonR build(ResponseEnum responseEnum, Object data) {
        return new CommonR(responseEnum.getCode(), responseEnum.getMsg(), data);
    }

    public static CommonR build(ResponseEnum responseEnum) {
        return new CommonR(responseEnum.getCode(), responseEnum.getMsg(), null);
    }

    //参数
    public static CommonR build(ResponseEnum responseEnum, String param) {
        return new CommonR(responseEnum.getCode(), param + responseEnum.getMsg(), null);
    }


    public static CommonR ok(Object data) {
        return new CommonR(data);
    }

    public static CommonR ok() {
        return new CommonR(null);
    }

    public CommonR() {

    }

    public CommonR(String statusCode, String msg, T data) {
        this.code = statusCode;
        this.msg = msg;
        this.data = data;
    }

    public CommonR(T data) {
        this.code = "200";
        this.msg = "success";
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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