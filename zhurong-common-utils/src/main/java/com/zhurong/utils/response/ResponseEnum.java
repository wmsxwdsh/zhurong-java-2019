/**   
 * @Title: ResponseEnum.java
 * @Package: com.zhurong.utils.response
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.response;

/**
 * @description: 响应枚举（待完善）
 * @author LZG
 * @date 2018/11/6
 */
public enum ResponseEnum {

    success("200", "OK"),
    server_error("500", "服务器错误"),
    query_not_exist("IC0001", "查询不到此信息"),
    sign_fail("IC0002", "报文验签不通过"),
    param_blank("IC0003", "请求参数不能为空"),
    login_fail("IC0004", "请尝试重新登录！"),

    not_sufficient_funds("UN0001","余额不足，请先充值"),

    sms_code_error("MF0001", "验证码错误！"),
    update_gender("MF0002","已修改过性别，不可再次修改");

    private String code;
    private String msg;

    private ResponseEnum(String statusCode, String msg) {
        this.code = statusCode;
        this.msg = msg;
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
}
