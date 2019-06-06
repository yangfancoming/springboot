package com.goat.doit.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by 64274 on 2018/12/7.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/7---11:05
 */
@Configuration
@MapperScan("com.goat.doit.mapper") // sos 不用在每个mapper上添加@Mapper注解
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");//设置方言类型
        return page;
    }

    @Bean
    @Profile({"dev","test"})
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(1000); // ms
        return performanceInterceptor;
    }


    @Bean
    public SqlExplainInterceptor sqlExplainInterceptor(){
        return new SqlExplainInterceptor();
    }

    @Bean
    public OptimisticLockerInterceptor optimisticLoker() {
        return new OptimisticLockerInterceptor();
    }

}