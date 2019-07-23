
package com.goat.tiny.mybatis.executor.resultset;


import java.sql.ResultSet;
import java.util.List;

public interface ResultSetHandler {
    /**
     * 处理查询结果
     */
    <E> List<E> handleResultSets(ResultSet resultSet);

}
