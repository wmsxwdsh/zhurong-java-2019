/**
 * @Title: ResponseEnum.java
 * @Package: com.zshy.infocoin.common.domain
 * @author LZG, liuzhongguochn@gmail.com
 * Copyright (c) 2018 北京中数合一科技有限公司
 */
package com.zhurong.utils.response.edop;

/**
 * @description: 响应枚举 1、待完善 2、响应码整理成册@author LZG
 * @author LZG
 * @date 2019/3/14
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