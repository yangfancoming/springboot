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

}
