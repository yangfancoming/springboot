
package com.goat.tiny.mybatis.session.defaults;



import com.goat.tiny.mybatis.executor.Executor;
import com.goat.tiny.mybatis.executor.SimpleExecutor;
import com.goat.tiny.mybatis.mapping.MappedStatement;
import com.goat.tiny.mybatis.session.Configuration;
import com.goat.tiny.mybatis.session.SqlSession;
import com.goat.tiny.mybatis.utils.CommonUtis;

import java.util.List;


/**
 * 默认SQL会话实现类
 */
public class DefaultSqlSession implements SqlSession {

    private final Configuration configuration;

    private final Executor executor;


    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        this.executor = new SimpleExecutor(configuration);

    }


    @Override
    public <T> T selectOne(String statementId, Object parameter) {
        List<T> results = this.<T> selectList(statementId, parameter);
        return CommonUtis.isNotEmpty(results) ? results.get(0) : null;
    }

    /**
     * 查询多条记录
     * @param statementId ID为mapper类全名+方法名
     * @param parameter 参数列表
     * @return
     */
    @Override
    public <E> List<E> selectList(String statementId, Object parameter) {
        MappedStatement mappedStatement = this.configuration.getMappedStatement(statementId);
        return this.executor.<E> doQuery(mappedStatement, parameter);
    }


    @Override
    public void update(String statementId, Object parameter) {
        MappedStatement mappedStatement = this.configuration.getMappedStatement(statementId);
        this.executor.doUpdate(mappedStatement, parameter);
    }
    
    @Override
    public void insert(String statementId, Object parameter) {
        //TODO 待实现
    }
    
    /**
     * 获取Mapper
     */
    @Override
    public <T> T getMapper(Class<T> type){
        return configuration.getMapper(type, this);
    }


    @Override
    public Configuration getConfiguration(){
        return this.configuration;
    }

}
