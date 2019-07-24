
package com.goat.tiny.mybatis.binding;

import com.goat.tiny.mybatis.mapping.MappedStatement;
import com.goat.tiny.mybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;



public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final long serialVersionUID = -7861758496991319661L;
    private final SqlSession sqlSession;
    private final Class<T> mapperInterface;


    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    /**
     * 真正的执行方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        try {
            if (Object.class.equals(method.getDeclaringClass())) {
                return method.invoke(this, args);
            }
            return  this.execute(method, args);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据SQL指令执行对应操作
     */
    private Object execute(Method method,  Object[] args) {

        String statementId = this.mapperInterface.getName() + "." + method.getName();
        MappedStatement ms = this.sqlSession.getConfiguration().getMappedStatement(statementId);
        
        Object result = null;
        switch (ms.getSqlCommandType()){
            case SELECT:
                Class<?> returnType = method.getReturnType();
                // 如果返回的是list，应该调用查询多个结果的方法，否则只要查单条记录
                if (Collection.class.isAssignableFrom(returnType)){
                    //ID为mapper类全名+方法名
                    result = sqlSession.selectList(statementId, args);
                }
                else{
                    result = sqlSession.selectOne(statementId, args);
                }
                break;
            case UPDATE:
                sqlSession.update(statementId, args);
                break;
            default:
                //TODO 其他方法待实现
                break;
        }
        return result;
    }
    
}
