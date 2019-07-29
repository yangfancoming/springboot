
package com.goat.tiny.mybatis.executor.statement;



import com.goat.tiny.mybatis.mapping.MappedStatement;
import com.goat.tiny.mybatis.utils.CommonUtis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class SimpleStatementHandler implements StatementHandler {

    /** #{}正则匹配 */
    private static Pattern param_pattern = Pattern.compile("#\\{([^\\{\\}]*)\\}");

    private MappedStatement mappedStatement;

    public SimpleStatementHandler(MappedStatement mappedStatement) {
        this.mappedStatement = mappedStatement;
    }

    @Override
    public PreparedStatement prepare(Connection paramConnection)  throws SQLException {
        String originalSql = mappedStatement.getSql();
        if (CommonUtis.isNotEmpty(originalSql)) {
            // 替换#{}，预处理，防止SQL注入
            return paramConnection.prepareStatement(parseSymbol(originalSql));
        }
        else {
            throw new SQLException("original sql is null.");
        }
    }


    @Override
    public ResultSet query(PreparedStatement preparedStatement)  throws SQLException {
        return preparedStatement.executeQuery();
    }

    @Override
    public void update(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.executeUpdate();
    }


    /** 将SQL语句中的#{}替换为?，源码中是在SqlSourceBuilder类中解析的 */
    private static String parseSymbol(String source) {
        source = source.trim();
        Matcher matcher = param_pattern.matcher(source);
        return matcher.replaceAll("?");
    }

}
