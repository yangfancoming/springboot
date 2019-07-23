
package com.goat.tiny.mybatis.binding;



import com.goat.tiny.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;


/**
 * Mapper代理工厂
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    /**
     * 初始化方法
     */
    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    /**
     * 根据sqlSession创建一个代理
     */
    public T newInstance(SqlSession sqlSession) {
        MapperProxy<T> mapperProxy = new MapperProxy<T>(sqlSession, this.mapperInterface);
        return newInstance(mapperProxy);
    }

    /**
     * 根据mapper代理返回实例
     */
    @SuppressWarnings("unchecked")
    protected T newInstance(MapperProxy<T> mapperProxy) {
        return (T)Proxy.newProxyInstance(this.mapperInterface.getClassLoader(), new Class[] {this.mapperInterface}, mapperProxy);
    }
}
