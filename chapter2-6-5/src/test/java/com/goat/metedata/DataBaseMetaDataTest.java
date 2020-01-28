package com.goat.metedata;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.Properties;

/**
 * 测试数据库元数据
 */
public class DataBaseMetaDataTest {

    private Connection connection;
    private DatabaseMetaData metaData;
    @Before
    public void init() throws Exception {
        String driver ="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://192.168.211.128:3306/test2?useUnicode=true&characterEncoding=utf8";

        Properties props = new Properties();
        props.put("remarksReporting","true");//获取数据库的备注信息
        props.put("user","root");
        props.put("password","12345");

        //1.获取连接
        Class.forName(driver);//注册驱动
        connection = DriverManager.getConnection(url,props);
        //2.获取元数据
        metaData = connection.getMetaData();
    }

    //获取数据库基本信息
    @Test
    public void test01() throws Exception {
        System.out.println(metaData.getUserName());  //3.获取数据库基本信息  root@192.168.211.1
        System.out.println(metaData.supportsTransactions());//是否支持事务  true
        System.out.println(metaData.getDatabaseProductName()); // MySQL
    }

    //获取所有数据库列表
    @Test
    public void test02() throws SQLException {
        //2.获取所有数据库列表
        ResultSet rs = metaData.getCatalogs();
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        rs.close();
        connection.close();
    }

    //获取指定数据库中的表信息
    @Test
    public void test03() throws Exception {
        //2.获取数据库中表信息
        /**
         * String catalog, String schemaPattern,String tableNamePattern, String types[]
         *
         *  catalog:当前操作的数据库
         *      mysql:
         *          :ihrm
         *          catalog
         *      oralce:
         *          xxx:1521:orcl
         *          catalog
         *   schema：
         *      mysql： null
         *      oracle： 用户名（大写）
         *
         *    tableNamePattern：
         *      null：查询所有表
         *      非空：查询目标表
         *
         *    types：类型
         *      TABLE：表
         *      VIEW：视图
         *
         */
        ResultSet rs = metaData.getTables(null, null, null, new String[]{"TABLE"});
        while (rs.next()) {
            System.out.println(rs.getString("TABLE_NAME"));
        }
    }

    //获取指定表中的字段信息
    @Test
    public void test04() throws Exception {
        //获取表中的字段信息
        /**
         *  catalog
         *  schema
         *  tableName
         *  columnName
         */
        ResultSet rs = metaData.getColumns(null, null, "book", null);
        while (rs.next()) {
            System.out.println(rs.getString("TYPE_NAME"));
        }
    }

    /**
     * 测试参数元数据（ParameterMetaData）
     *      通过PreparedStatement获取
     *      获取sql参数中的属性信息
     */
    @Test
    public void test() throws Exception {
        String sql = "select * from book where isbn=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, "1");
        //获取参数元数据
        ParameterMetaData metaData = pstmt.getParameterMetaData();
        int count = metaData.getParameterCount();
        System.out.println(count);
    }


    /**
     * 测试结果集元数据（ResultSetMetaData）
     *      通过ResultSet获取
     *      获取查询结果的信息
     */
    @Test
    public void test11() throws Exception {
        //sql
        String sql = "select * from book where isbn=?";
        //PreparedStatement
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, "1");
        //查询
        ResultSet rs = pstmt.executeQuery();
        //获取结果集元数据
        ResultSetMetaData metaData = rs.getMetaData();
        //获取查询字段个数
        int count = metaData.getColumnCount();
        for(int i =1;i<=count ;i++) {
            //获取列名
            String columnName = metaData.getColumnName(i);
            //获取字段类型 sql类型
            String columnType = metaData.getColumnTypeName(i);
            //获取java类型
            String columnClassName = metaData.getColumnClassName(i);
            System.out.println(columnName+"--"+columnType+"---"+columnClassName);
        }
    }

}
