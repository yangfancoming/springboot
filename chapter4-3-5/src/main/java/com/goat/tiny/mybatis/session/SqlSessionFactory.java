
package com.goat.tiny.mybatis.session;


public interface SqlSessionFactory {

    /** 开启数据库会话 */
    SqlSession openSession();
}
