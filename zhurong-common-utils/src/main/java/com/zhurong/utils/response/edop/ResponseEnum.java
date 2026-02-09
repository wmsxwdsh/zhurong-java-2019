package com.zhurong.utils.response.edop;

/**
 * 响应枚举 1、待完善 2、响应码整理成册
 * 2019/3/14
 */
public enum ResponseEnum {

    server_ok("ok"),
    server_error("error");

    private String code;

    private ResponseEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}