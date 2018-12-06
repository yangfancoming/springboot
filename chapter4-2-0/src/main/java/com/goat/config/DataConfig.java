package com.goat.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataConfig {

    /**
         * @Description: 功能描述：
         * @author: 杨帆
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
        ds.setUrl("jdbc:mysql://172.16.163.135:3306/jpaTest?Unicode=true&amp;characterEncoding=utf8&useSSL=false");
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
