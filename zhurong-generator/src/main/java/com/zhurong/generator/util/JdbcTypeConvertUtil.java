package com.zhurong.generator.util;

/**
 * jdbcType 类型转换工具类
 * 2019/3/28
 */
public class JdbcTypeConvertUtil {

    /**
     * 数据库的字段类型转换成jdbc的类型（先从支持mysql开始）
     */
    public static String sqlType2JdbcType(String sqlType) {
        String jdbcType = "";
        switch (sqlType.toUpperCase()) {
            case "BIGINT":
                jdbcType = "BIGINT";
                break;
            case "TINYINT":
                jdbcType = "TINYINT";
                break;
            case "SMALLINT":
                jdbcType = "SMALLINT";
                break;
            case "MEDIUMINT":
                jdbcType = "INTEGER";
                break;
            case "INTEGER":
                jdbcType = "INTEGER";
                break;
            case "INT":
                jdbcType = "INTEGER";
                break;
            case "FLOAT":
                jdbcType = "REAL";
                break;
            case "DOUBLE":
                jdbcType = "DOUBLE";
                break;
            case "DECIMAL":
                jdbcType = "DECIMAL";
                break;
            case "CHAR":
                jdbcType = "CHAR";
                break;
            case "VARCHAR":
                jdbcType = "VARCHAR";
                break;
            case "TINYBLOB":
                jdbcType = "BINARY";
                break;
            case "TINYTEXT":
                jdbcType = "VARCHAR";
                break;
            case "BLOB":
                jdbcType = "BINARY";
                break;
            case "TEXT":
                jdbcType = "LONGVARCHAR";
                break;
            case "MEDIUMTEXT":
                jdbcType = "LONGVARCHAR";
                break;
            case "LONGTEXT":
                jdbcType = "LONGVARCHAR";
                break;
            case "LONGBLOB":
                jdbcType = "LONGVARBINARY";
                break;
            case "DATE":
                jdbcType = "DATE";
                break;
            case "YEAR":
                jdbcType = "DATE";
                break;
            case "TIME":
                jdbcType = "TIME";
                break;
            case "DATETIME":
                jdbcType = "TIMESTAMP";
                break;
            case "TIMESTAMP":
                jdbcType = "TIMESTAMP";
                break;
            default:
                jdbcType = null;
                break;
        }
        return jdbcType;
    }

    /**
     * mysql字段的类型转换成 java 的类型
     */
    public static String mysqlType2JavaType(String sqlType) {
        String javaType = "";
        switch (sqlType.toUpperCase()) {
            case "TEXT":
                javaType = "String";
                break;
            case "BIT":
                javaType = "Boolean";
                break;
            case "SMALLINT":
                javaType = "Integer";
                break;
            case "MEDIUMINT ":
                javaType = "Integer";
                break;
            case "INTEGER":
                javaType = "Integer";
                break;
            case "INT":
                javaType = "Integer";
                break;
            case "BIGINT UNSIGNED":
                javaType = "Long";
                break;
            case "FLOAT":
                javaType = "Float";
                break;
            case "DOUBLE":
                javaType = "Double";
                break;
            case "DECIMAL":
                javaType = "BigDecimal";
                break;
            case "TIMESTAMP":
                javaType = "Date";
                break;
            case "TIME":
                javaType = "Time";
                break;
            case "DATE":
                javaType = "Date";
                break;
            case "CHAR":
                javaType = "String";
                break;
            case "VARCHAR":
                javaType = "String";
                break;
            case "DATETIME":
                javaType = "Date";
                break;
            default:
                javaType = null;
                break;
        }
        return javaType;
    }

    /**
     * sqlserver字段的类型转换成 java 的类型
     */
    public static String sqlserverType2JavaType(String sqlType) {
        String javaType = "";
        switch (sqlType.toUpperCase()) {
            case "TEXT":
                javaType = "String";
                break;
            case "BIT":
                javaType = "Boolean";
                break;
            case "SMALLINT":
                javaType = "Integer";
                break;
            case "MEDIUMINT ":
                javaType = "Integer";
                break;
            case "INTEGER":
                javaType = "Integer";
                break;
            case "INT":
                javaType = "Integer";
                break;
            case "INT IDENTITY":
                javaType = "Integer";
                break;
            case "BIGINT UNSIGNED":
                javaType = "Long";
                break;
            case "FLOAT":
                javaType = "Float";
                break;
            case "DOUBLE":
                javaType = "Double";
                break;
            case "DECIMAL":
                javaType = "BigDecimal";
                break;
            case "TIMESTAMP":
                javaType = "Date";
                break;
            case "TIME":
                javaType = "Time";
                break;
            case "DATE":
                javaType = "Date";
                break;
            case "CHAR":
                javaType = "String";
                break;
            case "VARCHAR":
                javaType = "String";
                break;
            case "DATETIME":
                javaType = "Date";
                break;
            default:
                javaType = null;
                break;
        }
        return javaType;
    }

    /**
     * oracle字段的类型转换成 java 的类型
     */
    public static String oracleType2JavaType(String sqlType) {
        String javaType = "";
        switch (sqlType.toUpperCase()) {
            case "VARCHAR2":
                javaType = "String";
                break;
            case "CHAR":
                javaType = "String";
                break;
            case "NCHAR":
                javaType = "String";
                break;
            case "NVARCHAR2":
                javaType = "String";
                break;
            case "TIMESTAMP":
                javaType = "Date";
                break;
            case "TIME":
                javaType = "Time";
                break;
            case "DATE":
                javaType = "Date";
                break;
            case "DATETIME":
                javaType = "Date";
                break;
            case "LONG":
                javaType = "Long";
                break;
            case "INTEGER":
                javaType = "Integer";
                break;
            case "FLOAT":
                javaType = "Float";
                break;
            case "DECIMAL":
                javaType = "BigDecimal";
                break;
            case "NUMBER":
                javaType = "BigDecimal";
                break;

            default:
                javaType = null;
                break;
        }
        return javaType;
    }



}