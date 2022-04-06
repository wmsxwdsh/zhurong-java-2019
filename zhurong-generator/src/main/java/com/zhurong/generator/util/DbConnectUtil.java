package com.zhurong.generator.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.centit.support.database.DatabaseAccess;
import com.centit.support.database.QueryAndNamedParams;
import com.centit.support.database.QueryAndParams;
import com.centit.support.database.QueryUtils;
import com.zhurong.db.persistence.domain.ProjectDataSource;
import com.zhurong.generator.sysEnum.DataSourceDBTypeEnum;
import com.zhurong.generator.sysEnum.JdbcDriverEnum;
import com.zhurong.generator.sysEnum.JdbcUrlPrefixEnum;
import com.zhurong.utils.general.StringUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author NoBugNoCode
 *
 *         2019年3月20日 下午2:16:14
 */
public class DbConnectUtil implements Serializable {

    private static final long serialVersionUID = 1L;
    protected static final Logger logger = LoggerFactory.getLogger(DbConnectUtil.class);

    private DbConnectUtil() {
        throw new IllegalAccessError("Utility class");
    }

    /**
     * 测试数据源连接是否成功
     *
     * @param dbc
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static synchronized boolean testConnectionByDataSource(ProjectDataSource dbc) {
        if (null == dbc) {
            throw new RuntimeException("RuntimeException : dataSource is null");
        }

        // 数据库连接地址
        String url = urlHandler(dbc);
        // 用户名
        String username = dbc.getDbUser();
        // 密码
        String password = dbc.getDbPassword();
        // 获取驱动类
        String driver = driverHandler(dbc);

        Connection conn = null;
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, username, password);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn != null;
    }

    /**
     * 根据数据源获取数据库连接
     *
     * @param dbc
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static synchronized Connection getConnectionByDataSource(ProjectDataSource dbc) {
        if (null == dbc) {
            throw new RuntimeException("RuntimeException : dataSource is null");
        }

        // 数据库连接地址
        String url = urlHandler(dbc);
        // 用户名
        String username = dbc.getDbUser();
        // 密码
        String password = dbc.getDbPassword();
        // 获取驱动类
        String driver = driverHandler(dbc);
        Connection conn = null;
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, username, password);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (null != conn) {
            return conn;
        }
        return null;
    }

    /**
     * 关闭连接
     *
     * @param conn
     */
    public static void closeConnect(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    /**
     * 查询数据库表（所有表名称）
     *
     * @param dbc
     * @return
     */
    public static String queryDataSourceTables(ProjectDataSource dbc) {

        String dbTypeName = dbc.getDbType();
        String sql = null;
        switch (dbTypeName) {
            case "mysql":
                sql = "select table_name from information_schema.tables where table_schema='" + dbc.getSid().toUpperCase()
                    + "' and table_type='base table';";
                break;
            case "oracle":
                sql = "select table_name from user_tables";
                break;
            case "sqlserver":
                sql = "select name from sysobjects where xtype='" + "u'";
                break;
            default:
                break;
        }
        try {

            Connection conn = getConnectionByDataSource(dbc);
            JSONArray ja = DatabaseAccess.findObjectsByNamedSqlAsJSON(conn, sql, null);
            conn.close();
            return ja.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取数据库表（某表或全表）字段结构 如果tableName不为空或null则查询 该表表结构，否则查询全库表结构
     *
     * @param dbSource 数据源
     * @param tableName 查询表结构表名
     * @return
     */
    public static String getTableColumns(ProjectDataSource dbSource, String tableName) {
        Connection conn = null;
        try {
            // 重新创建对象不修改原来的对象属性
            ProjectDataSource dbc = new ProjectDataSource();
            BeanUtils.copyProperties(dbSource, dbc);
            conn = getConnectionByDataSource(dbc);
            String dbTypeName = dbc.getDbType();

            if ("mysql".equals(dbTypeName) || "oracle".equals(dbTypeName)) {
                dbc.setDbUser(dbc.getDbUser().toUpperCase());
                tableName = ("".equals(tableName) || tableName == null) ? "%" : tableName;
                if ("oracle".equals(dbTypeName)) {
                    tableName = tableName.toUpperCase();
                }
            } else {
                dbc.setDbUser("%");
            }
            JSONArray ja = DatabaseAccess.fetchResultSetToJSONArray(
                conn.getMetaData().getColumns(conn.getCatalog(), dbc.getDbUser(), tableName, null), null);
            return ja.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * @Description: 获取表的主键
     * @param conn 数据库连接
     * @param table 表名
     * @return java.util.List<java.lang.String>
     */
    public static List<String> getTablePrimaryKey(Connection conn, String table) {
        List<String> pkList = new ArrayList<>();
        try {
            DatabaseMetaData dbMetaData = conn.getMetaData();
            ResultSet rs = dbMetaData.getPrimaryKeys(conn.getCatalog(), null, table);
            while (rs.next()) {
                pkList.add(rs.getString("COLUMN_NAME") + "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pkList;
    }

    /**
     * 执行sql语句(查询使用)
     *
     * @param sql
     * @param values
     * @return
     */
    public static String excuteQuery(Connection conn, String sql, Map<String, Object> values) {
        try {
            JSONArray ja = DatabaseAccess.findObjectsByNamedSqlAsJSON(conn, sql, values);
            return ja.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过sql解析sql中查询的字段名称
     *
     * @param dbc
     * @param druidConfiguration
     * @param sql
     * @return
     */
    public static String[] querySqlColumn(Connection conn, String sql, Map<String, Object> values) {
        try {
            QueryAndParams qap = QueryAndParams.createFromQueryAndNamedParams(new QueryAndNamedParams(sql, values));
            PreparedStatement stmt = conn.prepareStatement(sql);
            DatabaseAccess.setQueryStmtParameters(stmt, qap.getParams());
            ResultSet rs = stmt.executeQuery();
            if (rs == null) {
                return new String[0];
            }
            String[] fns = null;
            if (ArrayUtils.isEmpty(fns)) {
                List<String> fields = QueryUtils.getSqlFiledNames(sql);
                // fns = DatabaseAccess.mapColumnsNameToFields(fields);
                if (fields == null || fields.size() == 0) {
                    fns = null;
                } else {
                    fns = new String[fields.size()];
                    for (int i = 0; i < fields.size(); i++) {
                        fns[i] = fields.get(i);
                    }
                }
            }
            int cc = rs.getMetaData().getColumnCount();
            int asFn = 0;
            if (fns != null) {
                asFn = fns.length;
            }
            String[] fieldNames = new String[cc];
            for (int i = 0; i < cc; i++) {
                if (i < asFn) {
                    fieldNames[i] = fns[i];
                } else
                // DatabaseAccess.mapColumnNameToField(rs.getMetaData().getColumnLabel(i + 1));
                {
                    fieldNames[i] = rs.getMetaData().getColumnLabel(i + 1);
                }
            }
            return fieldNames;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 执行sql语句(增删改使用)
     *
     * @param dbc
     * @param druidConfiguration
     * @param sql
     * @return
     */
    public static int excuteUpdate(Connection conn, String sql, Object[] values) {
        try {
            int doExecuteSql = DatabaseAccess.doExecuteSql(conn, sql, values);
            return doExecuteSql;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取对应数据库连接路径
     *
     * @param dataSource
     * @return
     */
    private static String urlHandler(ProjectDataSource dataSource) {
        String url = null;
        String dbType = dataSource.getDbType();
        if (dbType.equals(DataSourceDBTypeEnum.mysql.getValue())) {
            url = JdbcUrlPrefixEnum.prefix_mysql_url.getValue() + dataSource.getHost() + ":" + dataSource.getPort()
                + "/" + dataSource.getSid();
        }
        if (dbType.equals(DataSourceDBTypeEnum.sqlserver.getValue())) {
            url = JdbcUrlPrefixEnum.prefix_sqlserver_url.getValue() + dataSource.getHost() + ":" + dataSource.getPort()
                + ";DatabaseName=" + dataSource.getSid();
        }
        if (dbType.equals(DataSourceDBTypeEnum.oracle.getValue())) {
            url = JdbcUrlPrefixEnum.prefix_oracle_url.getValue() + dataSource.getHost() + ":" + dataSource.getPort()
                + ":" + dataSource.getSid();
        }

        if (null != url) {
            return url;
        }
        throw new RuntimeException("edop暂不支持的数据库类型");
    }

    /**
     * 获取数据库对应驱动
     *
     * @param dataSource
     * @return
     */
    private static String driverHandler(ProjectDataSource dataSource) {
        String driver = null;

        String dbType = dataSource.getDbType();
        if (dbType.equals(DataSourceDBTypeEnum.mysql.getValue())) {
            driver = JdbcDriverEnum.mysql_driver.getValue();
        }
        if (dbType.equals(DataSourceDBTypeEnum.sqlserver.getValue())) {
            driver = JdbcDriverEnum.sqlserver_driver.getValue();
        }
        if (dbType.equals(DataSourceDBTypeEnum.oracle.getValue())) {
            driver = JdbcDriverEnum.oracle_driver.getValue();
        }

        if (null != driver) {
            return driver;
        }
        throw new RuntimeException("edop暂不支持的数据库类型");
    }


    /**
     * @Description: 获取数据库的表名数组
     * @param connection
     * @return java.util.List<java.lang.String>
     * @author LZG
     * @date 2019/3/25
     */
    public static List<String> getTableNameByConnection(Connection connection) {
        List<String> tableNameList = new ArrayList<>();

        try {
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet rs = meta.getTables(connection.getCatalog(), "%", null, new String[]{"TABLE"});

            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                tableNameList.add(tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableNameList;
    }

    /**
     * @Description: 获取数据库列相关信息
     * @param connect
     * @param tableName
     * @return java.util.List<java.lang.String               [               ]>
     * @author LZG
     * @date 2019/3/25
     */
    public static List<String[]> getColumnByConnectionAndTableName(Connection connect, String tableName) {

        Statement stat = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;

        // 数据库列字段的List集合
        List<String[]> tableColumnList = new ArrayList<String[]>();

        try {
            stat = connect.createStatement();
            rs = stat.executeQuery("select * from " + tableName);
            rsmd = rs.getMetaData();

            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                // name type precision scale，其中precision和scale可以为空
                String[] columnArr = new String[4];

                String columnName = rsmd.getColumnName(i);
                columnArr[0] = columnName;
                String columnType = rsmd.getColumnTypeName(i);
                columnArr[1] = columnType;
                if ("TIMESTAMP".equals(columnType)) {
                    columnArr[2] = "0";
                } else {
                    int columnPrecision = rsmd.getPrecision(i);
                    columnArr[2] = String.valueOf(columnPrecision);
                }

                if ("DECIMAL".equals(columnType)) {
                    int columnScale = rsmd.getScale(i);
                    columnArr[3] = String.valueOf(columnScale);
                }

                tableColumnList.add(columnArr);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tableColumnList;
    }

    public static List<String[]> getIndexByConnectionAndTableName(Connection connect, String tableName) {

        List<String[]> resultList = new ArrayList<>();
        ResultSet rs = null;
        DatabaseMetaData dbmd = null;
        try {
            dbmd = connect.getMetaData();
            // 获取索引信息
            rs = dbmd.getIndexInfo(null, null, tableName, false, false);
            while (rs.next()) {
                String[] indexArr = new String[2];
                // 获取索引名
                String indexName = rs.getString("INDEX_NAME");

                // 获取列名
                String indexColumnName = rs.getString("COLUMN_NAME");

                if (StringUtil.isNotBlank(indexName) && StringUtil.isNotBlank(indexColumnName)) {
                    indexArr[0] = indexName;
                    indexArr[1] = indexColumnName;
                    resultList.add(indexArr);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * 将驼峰命名转下划线命名（实体对应数据库字段类型）
     *
     * @return
     */
    public static String strToLine(String clunmName) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] split = clunmName.toCharArray();// 将字符串转为char类型字符数组
        for (int i = 0; i < split.length; i++) {
            char cc = split[i];
            if (cc > 64 && cc < 91) {// 判断如果为大写字母则进入此方法
                // 方法2.一句代码转换
                cc = (char) ((int) cc + 32);
                stringBuffer.append("_" + cc);
            } else {
                stringBuffer.append(cc);
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 封装查询表的字段名称和字段类型映射关系
     */
    public static Map<Object, Object> getColumnNameType(String tableColumnsStr) {
        // 封装查询表的列字段
        Map<Object, Object> columnMap = new HashMap<>();
        List<Map<Object, Object>> displayColumns = (List<Map<Object, Object>>) JSON.parse(tableColumnsStr);
        // 加入字段列标题
        for (int i = 0; i < displayColumns.size(); i++) {
            Map<Object, Object> columnData = displayColumns.get(i);
            String type = columnData.get("typeName") + "";
            String fieldName = (columnData.get("columnName") + "");
            if (type.toUpperCase().contains("TIME") || type.toUpperCase().contains("DATE")) {
                type = "dateTime";
            }
            columnMap.put(fieldName, type);
        }
        return columnMap;
    }

    /**
     * @Description: 根据数据库连接和用户名获取oracle表名
     * @param connect
     * @param dbUser
     * @return java.util.List<java.lang.String>
     * @author LZG
     * @date 2019/4/1
     */
    public static List<String> getOracleTableNameByConnectionAndDbUser(Connection connection, String dbUser) {
        List<String> tableNameList = new ArrayList<>();

        try {
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet rs = meta.getTables(connection.getCatalog(), dbUser.toUpperCase(), null,
                new String[]{"TABLE"});

            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                tableNameList.add(tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableNameList;
    }

}
