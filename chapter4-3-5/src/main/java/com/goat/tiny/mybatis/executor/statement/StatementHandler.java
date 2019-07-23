
package com.goat.tiny.mybatis.executor.statement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public interface StatementHandler {

    /**
     * SQL预处理
     */
    PreparedStatement prepare(Connection paramConnection) throws SQLException;

    /**
     * 查询数据库
     */
    ResultSet query(PreparedStatement preparedStatement) throws SQLException;
    
    /**
     * update
     */
    void update(PreparedStatement preparedStatement) throws SQLException;
}
