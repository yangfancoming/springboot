# mybatis-plus  乐观锁
    spring xml: 方式
        <bean class="com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor"/>
    spring boot: 方式
        @Bean
        public OptimisticLockerInterceptor optimisticLockerInterceptor() {
            return new OptimisticLockerInterceptor();
        }
        
    2.注解实体字段 @Version 必须要!
    @Version
    private Integer version;
    
    
    
# 报错：