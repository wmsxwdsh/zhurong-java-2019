package com.zhurong.generator.domain;

import java.util.List;

/**
 * 表类
 * 2019/3/27
 */
public class Table {

    /**表名*/
    private String table;

    /**表的字段数据集合*/
    private List<Column> columnList = null;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<Column> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }

    @Override
    public String toString() {
        return "Table{" +
            "table='" + table + '\'' +
            ", columnList=" + columnList +
            '}';
    }

}