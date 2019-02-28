package com.goat.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class CacheService  {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @CachePut(value = "cache", key = "#p.id")
    public void update(){
        jdbcTemplate.update("insert book values ('2','gg',30)");
//        System.out.println(i);
    }

    @Cacheable(value = "cache", key = "#p.id")
    public void select(){
        jdbcTemplate.update("insert book values ('2','gg',30)");
//        System.out.println(i);
    }

    @CacheEvict(value = "cache")
    public void remove(){
        jdbcTemplate.update("insert book values ('2','gg',30)");
//        System.out.println(i);
    }

}


