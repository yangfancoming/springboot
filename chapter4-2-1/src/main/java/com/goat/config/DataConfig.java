package com.goat.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataConfig {


    @Bean
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://172.16.163.135:3306/jpaTest?Unicode=true&amp;characterEncoding=utf8&useSSL=false");
//        ds.setUrl("jdbc:mysql://192.168.235.207:3306/jpaTest?Unicode=true&amp;characterEncoding=utf8&useSSL=false");
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
