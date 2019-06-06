/**   
 * @Title: Table.java
 * @Package: com.essence.edop.generator.domain
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.generator.domain;

import java.util.List;

/**
 * @description: 表类
 * @author LZG
 * @date 2019/3/27
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