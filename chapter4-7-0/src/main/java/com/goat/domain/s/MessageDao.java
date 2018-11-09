package com.goat.domain.s;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 使用 JdbcTemplate 操作数据源 1 
 */
@Repository
public class MessageDao {

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;


    @Transactional
    public void create(String content, String name) {
        jdbcTemplate.update("insert into message (content, name) values(?, ?)", content, name);
    }
}
