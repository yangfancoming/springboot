package com.goat.chapter759.config;

import com.bstek.ureport.definition.datasource.BuildinDatasource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@Component
public class UreportDataSource implements BuildinDatasource {

	private static final String NAME = "MyDataSource";

	private Logger log = LoggerFactory.getLogger(UreportDataSource.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public String name() {
		return NAME;
	}

	@Override
	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			log.error("Ureport 数据源 获取连接失败！");
			e.printStackTrace();
		}
		return null;
	}


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://192.168.136.128:3306/test2?useUnicode=true&characterEncoding=UTF-8");
        ds.setUsername("root");
        ds.setPassword("12345");
        return ds;
    }

}
