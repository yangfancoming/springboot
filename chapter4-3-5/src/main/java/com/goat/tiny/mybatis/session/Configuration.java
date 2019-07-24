
package com.goat.tiny.mybatis.session;




import com.goat.tiny.mybatis.binding.MapperRegistry;
import com.goat.tiny.mybatis.mapping.MappedStatement;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * mybatis核心配置类
 */
public class Configuration {

    /**配置项*/
    public static Properties PROPS = new Properties();

    /** mapper代理注册器 */
    protected final MapperRegistry mapperRegistry = new MapperRegistry();
    
    /** mapper文件的select/update语句的id和SQL语句属性 **/
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();



    public <T> void addMapper(Class<T> type){
      this.mapperRegistry.addMapper(type);
    }
    
    public <T> T getMapper(Class<T> type, SqlSession sqlSession){
      return this.mapperRegistry.getMapper(type, sqlSession);
    }


    public void addMappedStatement(String key, MappedStatement mappedStatement){
        this.mappedStatements.put(key, mappedStatement);
    }

    /**
     * 获取MappedStatement
     * @param id xml文件标签的id属性
     */
    public MappedStatement getMappedStatement(String id){
        return this.mappedStatements.get(id);
    }

    /**
     * 获取字符型属性(默认值为空字符串)
     */
    public static String getProperty(String key) {
        return getProperty(key, "");
    }

    /**
     * 获取字符型属性(可指定默认值)
     * @param key
     * @param defaultValue
     */
    public static String getProperty(String key, String defaultValue) {
        return PROPS.containsKey(key) ? PROPS.getProperty(key) : defaultValue;
    }

}
