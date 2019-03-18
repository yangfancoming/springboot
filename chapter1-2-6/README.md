#  参考 WebMvcAutoConfiguration   实现自定义 starter

    1. @Configuration 指定该类为一个配置类
    2. @ConditionalOnXXXXX 只有在指定条件成立的情况下 该自动配置类才生效
    3. @AutoConfigureAfter 指定该自动配置类的顺序
    4. @Bean 把该自动配置类 添加到spring容器中
    5. @ConfigurationProperties  绑定 xxxxproperties 相关配置文件
    6. @EnableConfigurationProperties({ WebMvcProperties.class, ResourceProperties.class }) 让 xxxxproperties 生效 并加入到spring容器中

    自动配置类要能加载
    将需要启动就加载的自动配置类，配置在META-INF/spring.factories
    org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
    org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration,\
    org.springframework.boot.autoconfigure.aop.AopAutoConfiguration,\