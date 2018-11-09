package com.goat.domain.p;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 使用 JdbcTemplate 操作数据源 1 
 */
@Repository
public class UserDao {

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;



    @Transactional("transactionManagerPrimary")
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into user (NAME, AGE) values(?, ?)", name, age);
    }
}
