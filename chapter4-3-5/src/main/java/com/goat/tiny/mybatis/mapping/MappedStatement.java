
package com.goat.tiny.mybatis.mapping;
import com.goat.tiny.mybatis.constants.Constant.SqlType;

public final class MappedStatement {

    /** mapper文件的namespace */
    private String namespace;

    /** sql的id属性 */
    private String sqlId;

    /** sql语句，对应源码的sqlSource */
    private String sql;

    /** 返回类型 */
    private String resultType;

    /** sqlCommandType对应select/update/insert等 */
    private SqlType sqlCommandType;


    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getSqlId() {
        return sqlId;
    }

    public void setSqlId(String sqlId) {
        this.sqlId = sqlId;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public SqlType getSqlCommandType() {
        return sqlCommandType;
    }

    public void setSqlCommandType(SqlType sqlCommandType) {
        this.sqlCommandType = sqlCommandType;
    }

    @Override
    public String toString() {
        return "MappedStatement{" + "namespace='" + namespace + '\'' + ", sqlId='" + sqlId + '\'' + ", sql='" + sql + '\'' + ", resultType='" + resultType + '\'' + ", sqlCommandType=" + sqlCommandType + '}';
    }
}
