package com.goat.config;

import org.springframework.context.annotation.Configuration;

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

    //  javaConfig 配置方式
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//        ds.setUrl("jdbc:oracle:thin:@192.168.101.222:1521:ORCL");
//        ds.setUsername("jyt");
//        ds.setPassword("jyt2019");
//        return ds;
//    }
}
