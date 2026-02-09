package com.zhurong.generator.sysEnum;

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