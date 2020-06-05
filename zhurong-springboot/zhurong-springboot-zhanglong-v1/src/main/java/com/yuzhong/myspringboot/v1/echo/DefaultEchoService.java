/**
 * @Title: DefaultEchoService.java
 * @Package: com.yuzhong.myspringboot.echo
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.yuzhong.myspringboot.v1.echo;

/**
 * @description:
 * @author LZG
 * @date 2020年06月04日
 */
public class DefaultEchoService implements EchoServcie {

    private final String echoFormat;

    public DefaultEchoService(String echoFormat) {
        this.echoFormat = (null != echoFormat) ? echoFormat : "%s";
    }

    @Override
    public String getMessage(String message) {
        return String.format(echoFormat, message);
    }
}