
package com.goat.tiny.mybatis.executor;

import com.goat.tiny.mybatis.mapping.MappedStatement;

import java.util.List;


public interface Executor {


    /** 查询数据库 */
    <E> List<E> doQuery(MappedStatement ms, Object parameter);

    /** 更新操作 */
    void doUpdate(MappedStatement ms, Object parameter);
}
