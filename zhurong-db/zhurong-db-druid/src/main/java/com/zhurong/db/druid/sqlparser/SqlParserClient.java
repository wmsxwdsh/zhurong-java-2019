package com.zhurong.db.druid.sqlparser;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelectQuery;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.util.JdbcConstants;

public class SqlParserClient {

    public static void main(String[] args) {

        // sql 文本
        String sql = "SELECT id, merch_user_name, merch_user_email FROM tb_merch_user WHERE id = '741e37a2ee21467d9e8bb2cafb82f539'";

        // 解析成ast
        SQLStatement sqlStatement = SQLUtils.parseStatements(sql, JdbcConstants.MYSQL).get(0);

        // 查询语句做一个向下转型可以获得更多操作接口
        SQLSelectStatement sqlSelectStatement = (SQLSelectStatement) sqlStatement;

        // 获取queryBlock
        SQLSelectQuery sqlSelectQuery = sqlSelectStatement.getSelect().getQuery();
        // 转为实现类
        SQLSelectQueryBlock sqlSelectQueryBlock = (SQLSelectQueryBlock) sqlSelectQuery;

        // 拿到where条件
        System.out.println(sqlSelectQueryBlock.getWhere());
        // 拿到数据库类型，这里是mysql
        System.out.println(sqlSelectQueryBlock.getDbType());
        // 拿到from表名
        System.out.println(sqlSelectQueryBlock.getFrom());
        // 拿到select的字段列表
        System.out.println(sqlSelectQueryBlock.getSelectList());


        // 增强
        sqlSelectQueryBlock.addWhere(SQLUtils.toSQLExpr("merch_user_name is not null"));
        // 打印语句
        System.out.println(SQLUtils.toSQLString(sqlSelectStatement));

    }


}