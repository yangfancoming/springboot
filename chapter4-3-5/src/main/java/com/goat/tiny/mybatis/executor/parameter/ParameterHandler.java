
package com.goat.tiny.mybatis.executor.parameter;


import java.sql.PreparedStatement;



public interface ParameterHandler {


    /**
     * 设置参数
     */
    void setParameters(PreparedStatement paramPreparedStatement);
}
