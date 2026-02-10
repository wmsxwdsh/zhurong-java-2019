package com.yuzhong.myspringboot.v1.echo;

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