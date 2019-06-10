package com.goat.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataConfig {

    /**
     * @Description: @Bean 注解会告诉Spring 将该方法的返回值 添加到spring容器中 容器中该组件的默认id为函数名
     * @author: Goat
     * @Date:   2018/9/12
     *     出现如果下报错：
    sos　Establishing SSL connection without server's identity verification is not recommended.
    According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set
    可以使用  &useSSL=false 来解决
     */
    @Bean
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://172.16.163.135:3306/test2?Unicode=true&characterEncoding=utf8");
        ds.setUsername("root");
        ds.setPassword("12345");

        ds.setInitialSize(5);
        ds.setMinIdle(5);
        ds.setMaxActive(10);
        ds.setMaxWait(6000);
        ds.setValidationQuery("SELECT 1 FROM DUAL");
        return ds;
    }


}
