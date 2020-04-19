package com.goat.chapter404;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by 64274 on 2019/10/7.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/7---18:46
 */

@Configuration
public class AppConfig {

    /**
     * <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
     *         <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver" />
     *         <property name="url" value="jdbc:oracle:thin:@127.0.0.1:1521:orcl" />
     *         <property name="username" value="admin" />
     *         <property name="password" value="admin" />
     * </bean>
    */

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://192.168.136.128:3306/test2?Unicode=true&characterEncoding=utf8");
        ds.setUrl("jdbc:mysql://47.98.148.84:3306/test2?Unicode=true&characterEncoding=utf8");
        ds.setUsername("root");
        ds.setPassword("12345");
        return ds;
    }
}
