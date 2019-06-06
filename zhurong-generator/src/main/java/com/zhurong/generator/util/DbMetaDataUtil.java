/**
 * @Title: DbMetaDataUtil.java
 * @Package: com.essence.edop.generator.util
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.generator.util;

import com.zhurong.db.persistence.domain.ProjectDataSource;
import com.zhurong.generator.config.TableConstant;
import com.zhurong.generator.domain.Column;
import com.zhurong.generator.domain.Table;
import com.zhurong.generator.sysEnum.DataSourceDBTypeEnum;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 封装元数据的工具类
 * @author LZG
 * @date 2019/3/28
 */
public class DbMetaDataUtil {

    /**
     * @Description: 获取表信息（包括字段、注释等）
     * @param tableName
     * @param dataSource
     * @return com.essence.edop.generator.domain.Table
     * @author LZG
     * @date 2019/3/28
     */
    public static Table getTable(String tableName, ProjectDataSource dataSource) {
        Table table = new Table();
        table.setTable(tableName);
        table.setColumnList(getColumns(tableName, dataSource));
        return table;
    }

    /**
     * @Description: 根据表名获取所有字段信息
     * @param tableName
     * @return java.util.List<com.essence.edop.generator.domain.Column>
     * @author LZG
     * @date 2019/3/28
     */
    public static List<Column> getColumns(String tableName, ProjectDataSource dataSource) {
        List<Column> columnList = new ArrayList<>();
        String PK = "";
        Connection connection = DbConnectUtil.getConnectionByDataSource(dataSource);

        DatabaseMetaData databaseMetaData;
        try {
            databaseMetaData = connection.getMetaData();
            ResultSet pkRSet = databaseMetaData.getPrimaryKeys(null, null, tableName);
            ResultSet resultSet = databaseMetaData.getColumns(null, "%", tableName, "%");
            //数据源的数据库类型
            DataSourceDBTypeEnum dbTypeEnum = DataSourceDBTypeEnum.getByValue(dataSource.getDbType());

            //获取主键
            while (pkRSet.next()) {
                PK = (String) pkRSet.getObject(4);
            }
            while (resultSet.next()) {
                Column column = new Column();
                //id字段略过
                if (resultSet.getString(TableConstant.COLUMN_NAME).equalsIgnoreCase(PK)) {
                    column.setPrimaryKey(true);
                } else {
                    column.setPrimaryKey(false);
                }
                //获取数据库原始字段名称
                column.setOriginalName(resultSet.getString(TableConstant.COLUMN_NAME));
                //获取字段名称
                column.setName(GeneratorUtil.replaceUnderLine(resultSet.getString(TableConstant.COLUMN_NAME).toLowerCase()));
                //转换字段名称，如 sys_name 变成 SysName
                column.setNameUp(GeneratorUtil.toUpperCase(resultSet.getString(TableConstant.COLUMN_NAME).toLowerCase()));
                //字段在数据库的注释
                column.setComment(resultSet.getString(TableConstant.REMARKS));

                //获取字段对应的JAVA类型
                switch (dbTypeEnum) {
                    case mysql:
                        column.setType(JdbcTypeConvertUtil.mysqlType2JavaType(resultSet.getString(TableConstant.TYPE_NAME)));
                        break;
                    case sqlserver:
                        column.setType(JdbcTypeConvertUtil.sqlserverType2JavaType(resultSet.getString(TableConstant.TYPE_NAME)));
                        break;
                    case oracle:
                        column.setType(JdbcTypeConvertUtil.oracleType2JavaType(resultSet.getString(TableConstant.TYPE_NAME)));
                        break;
                }

                //获取字段的jdbc类型
                column.setOriginalType(resultSet.getString(TableConstant.TYPE_NAME));

                columnList.add(column);
            }
        } catch (SQLException e) {
            System.out.println("获取表信息失败！");
        }
        return columnList;
    }

}