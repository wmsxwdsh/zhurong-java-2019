/**   
 * @Title: JdbcUrlPrefixEnum.java
 * @Package: com.essence.edop.common.constant
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.generator.sysEnum;

/**
 * @description: prefix指ip前面所有
 * @author LZG
 * @date 2019/3/20
 */
public enum JdbcUrlPrefixEnum {

    prefix_mysql_url("jdbc:mysql://"),
    prefix_sqlserver_url("jdbc:sqlserver://"), //sqlserver2005
    prefix_oracle_url("jdbc:oracle:thin:@");

    private String value;

    private JdbcUrlPrefixEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static JdbcUrlPrefixEnum getByValue(String value) {
        for (JdbcUrlPrefixEnum jdbcUrlPrefixEnum : values()) {
            if (jdbcUrlPrefixEnum.getValue().equals(value)) {
                return jdbcUrlPrefixEnum;
            }
        }
        return null;
    }

}