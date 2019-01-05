//package com.goat.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//
//    /**
//         * @ author: 杨帆
//         @ Bean 注解会告诉Spring 将该方法的返回值 添加到spring容器中 容器中该组件的默认id为函数名
//         * @ Date:   2018/8/24
//    */
//    @Bean
//    public DataSource dataSource() {
//        DruidDataSource ds = new DruidDataSource();
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://172.16.163.135:3306/authority?Unicode=true&amp;characterEncoding=utf8");
//        ds.setUsername("root");
//        ds.setPassword("12345");
//
//        ds.setInitialSize(5);
//        ds.setMinIdle(5);
//        ds.setMaxActive(10);
//        ds.setMaxWait(6000);
//        ds.setValidationQuery("SELECT 1 FROM DUAL");
//        return ds;
//    }
//
//
//}
