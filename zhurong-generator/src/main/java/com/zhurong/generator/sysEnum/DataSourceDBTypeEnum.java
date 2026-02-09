package com.zhurong.generator.sysEnum;

public enum DataSourceDBTypeEnum {

    mysql("mysql"),
    sqlserver("sqlserver"),
    oracle("oracle");

    private String value;

    private DataSourceDBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DataSourceDBTypeEnum getByValue(String value) {
        for (DataSourceDBTypeEnum dataSourceDBTypeEnum : values()) {
            if (dataSourceDBTypeEnum.getValue().equals(value)) {
                return dataSourceDBTypeEnum;
            }
        }
        return null;
    }

}