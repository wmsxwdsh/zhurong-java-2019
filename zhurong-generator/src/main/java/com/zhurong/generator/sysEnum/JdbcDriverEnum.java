/**   
 * @Title: JdbcDriverEnum.java
 * @Package: com.essence.edop.common.constant
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.generator.sysEnum;

/**
 * @description:
 * @author LZG
 * @date 2019/3/20
 */
public enum JdbcDriverEnum {

    mysql_driver("com.mysql.jdbc.Driver"),
    sqlserver_driver("com.microsoft.sqlserver.jdbc.SQLServerDriver"), //sqlserver2005
    oracle_driver("oracle.jdbc.OracleDriver");

    private String value;

    private JdbcDriverEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static JdbcDriverEnum getByValue(String value) {
        for (JdbcDriverEnum jdbcDriverEnum : values()) {
            if (jdbcDriverEnum.getValue().equals(value)) {
                return jdbcDriverEnum;
            }
        }
        return null;
    }

}