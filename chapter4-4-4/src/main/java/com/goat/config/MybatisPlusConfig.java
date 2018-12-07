package com.goat.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
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
public class MybatisPlusConfig {


    //  mybatis-plus分页插件
    //  加分页插件前：  Preparing: SELECT id,name,age,version FROM user WHERE age BETWEEN ? AND ? AND version = ?
    //  加分页插件后：  Preparing: SELECT id,name,age,version FROM user WHERE age BETWEEN ? AND ? AND version = ? LIMIT 0,3
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");//设置方言类型
        return page;
    }

    /**
     * 性能分析拦截器，不建议生产使用
     * 控制台可以看到：
         Time：9 ms - ID：com.goat.mapper.UserMapper.insert
         Execute SQL：INSERT INTO user ( name, age ) VALUES ( ?, ? )
     * 超过执行最大时间： 报异常  The SQL execution time is too large, please optimize !
     */
    @Bean
//    @Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //SQL 执行最大时长，超过自动停止该sql运行，有助于发现问题，单位ms
        //
        performanceInterceptor.setMaxTime(1000); // ms
        //SQL是否格式化  默认false  不建议开启格式化  否则控制台的sql会显得很乱
        // performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

    /**
     执行分析拦截器插件
     1) com.baomidou.mybatisplus.plugins.SqlExplainInterceptor
     2) SQL 执行分析拦截器，只支持 MySQL5.6.3 以上版本
     3) 该插件的作用是分析 DELETE  UPDATE 语句,防止小白 或者恶意进行 DELETE  UPDATE 全表操作
     4) 只建议在开发环境中使用，不建议在生产环境使用
     5) 在插件的底层 通过 SQL 语句分析命令:Explain 分析当前的 SQL 语句,根据结果集中的 Extra 列来断定当前是否全表操作。
    */
    @Bean
    public SqlExplainInterceptor sqlExplainInterceptor(){
        return new SqlExplainInterceptor();
    }
    /**
         * @Description:  乐观锁 插件
         * @author: 杨帆
         * @Param:  相当于 xml 中的 <bean class="com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor"/>
         * @Return:
         * @Date:   2018/12/7
     *
     * 使用 optimisticLoker  前
     * 1 调用test222222222222222222222   更改成功
     * 1---调用test11111111111111111111  更改成功
     *
     * 使用 optimisticLoker  后
     * 1 调用test222222222222222222222   更改成功
     * 0---调用test11111111111111111111  更改失败
    */
    @Bean
    public OptimisticLockerInterceptor optimisticLoker() {
        return new OptimisticLockerInterceptor();
    }

}