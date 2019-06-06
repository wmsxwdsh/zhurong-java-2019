/**
 * @Title: DataSourceDBTypeEnum.java
 * @Package: com.essence.edop.common.db
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.generator.sysEnum;

/**
 * @description:
 * @author LZG
 * @date 2019/3/20
 */
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