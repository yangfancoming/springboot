package com.goat.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");//设置方言类型
        return page;
    }

    /**
     * 性能分析拦截器，不建议生产使用
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor(){
        return new PerformanceInterceptor();
    }

    /**
         * @Description:  乐观锁 插件
         * @author: 杨帆
         * @Param:  相当于 xml 中的 <bean class="com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor"/>
         * @Return:
         * @Date:   2018/12/7
     *
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