
package com.goat.tiny.mybatis.session;



import com.goat.tiny.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;


public class SqlSessionFactoryBuilder {


    public SqlSessionFactory build(String fileName){
        InputStream inputStream =  this.getClass().getClassLoader().getResourceAsStream(fileName);
        return build(inputStream);
    }


    public SqlSessionFactory build(InputStream inputStream){
        try{
            Configuration.PROPS.load(inputStream);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return new DefaultSqlSessionFactory(new Configuration());
    }
}
