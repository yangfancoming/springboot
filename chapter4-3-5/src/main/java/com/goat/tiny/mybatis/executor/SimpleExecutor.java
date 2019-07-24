
package com.goat.tiny.mybatis.executor;




import com.goat.tiny.mybatis.constants.Constant;
import com.goat.tiny.mybatis.executor.parameter.DefaultParameterHandler;
import com.goat.tiny.mybatis.executor.parameter.ParameterHandler;
import com.goat.tiny.mybatis.executor.resultset.DefaultResultSetHandler;
import com.goat.tiny.mybatis.executor.resultset.ResultSetHandler;
import com.goat.tiny.mybatis.executor.statement.SimpleStatementHandler;
import com.goat.tiny.mybatis.executor.statement.StatementHandler;
import com.goat.tiny.mybatis.mapping.MappedStatement;
import com.goat.tiny.mybatis.session.Configuration;

import java.sql.*;
import java.util.List;


/**
 * mybatis执行器
 */
public class SimpleExecutor implements Executor {

    /** 数据库连接 */
    private static Connection connection;

    private Configuration conf;

    static {
        initConnect();
    }

    /**
     * 初始化方法
     */
    public SimpleExecutor(Configuration configuration) {
        this.conf = configuration;
    }

    /**
     * 根据参数查询数据库
     */
    @Override
    public <E> List<E> doQuery(MappedStatement ms, Object parameter) {
        try {
            //1.获取数据库连接
            Connection connection = getConnect();

            //2.获取MappedStatement信息，里面有sql信息
            MappedStatement mappedStatement = conf.getMappedStatement(ms.getSqlId());

            //3.实例化StatementHandler对象，
            StatementHandler statementHandler = new SimpleStatementHandler(mappedStatement);

            //4.通过StatementHandler和connection获取PreparedStatement
            PreparedStatement preparedStatement = statementHandler.prepare(connection);

            //5.实例化ParameterHandler，将SQL语句中？参数化
            ParameterHandler parameterHandler = new DefaultParameterHandler(parameter);
            parameterHandler.setParameters(preparedStatement);

            //6.执行SQL，得到结果集ResultSet
            ResultSet resultSet = statementHandler.query(preparedStatement);

            //7.实例化ResultSetHandler，通过反射将ResultSet中结果设置到目标resultType对象中
            ResultSetHandler resultSetHandler = new DefaultResultSetHandler(mappedStatement);
            return resultSetHandler.handleResultSets(resultSet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * doUpdate
     */
    @Override
    public void doUpdate(MappedStatement ms, Object parameter){
        try{
            //1.获取数据库连接
            Connection connection = getConnect();

            //2.获取MappedStatement信息，里面有sql信息
            MappedStatement mappedStatement = conf.getMappedStatement(ms.getSqlId());

            //3.实例化StatementHandler对象，
            StatementHandler statementHandler = new SimpleStatementHandler(mappedStatement);

            //4.通过StatementHandler和connection获取PreparedStatement
            PreparedStatement preparedStatement = statementHandler.prepare(connection);

            //5.实例化ParameterHandler，将SQL语句中？参数化
            ParameterHandler parameterHandler = new DefaultParameterHandler(parameter);
            parameterHandler.setParameters(preparedStatement);
            //6.执行SQL
            statementHandler.update(preparedStatement);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Connection getConnect() throws SQLException  {
        if (null != connection) {
            return connection;
        }
        else  {
            throw new SQLException("无法连接数据库，请检查配置");
        }
    }

    /**
     * 静态初始化数据库连接
     */
    private static void initConnect()  {

        String driver = Configuration.getProperty(Constant.DB_DRIVER_CONF);
        String url = Configuration.getProperty(Constant.DB_URL_CONF);
        String username = Configuration.getProperty(Constant.DB_USERNAME_CONF);
        String password = Configuration.getProperty(Constant.db_PASSWORD);

        try  {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("数据库连接成功");
        }
        catch (Exception e)  {
            e.printStackTrace();
        }
    }


}
