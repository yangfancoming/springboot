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
//        ds.setUrl("jdbc:mysql://192.168.235.182/wms?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull"); // wms
        ds.setUsername("test_sim");
        ds.setPassword("sim@sim");
        ds.setInitialSize(5);
        ds.setMinIdle(5);
        ds.setMaxActive(10);
        ds.setMaxWait(6000);
        ds.setValidationQuery("SELECT 1 FROM DUAL");
        return ds;
    }



}
