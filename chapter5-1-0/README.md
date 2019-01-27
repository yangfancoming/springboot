# 主要概念

    缓存接口：
    Cache
    CacheManager 缓存管理器，管理各种缓存组件
    
    缓存注解：
    @EnableCaching /**开启缓存功能*/ 使得一下3个注解生效 
    @CacheEvict 
    @CachePut 
    @Cacheable
    
    
    
    项目启动后报错：
        Description:
        The bean 'personServiceImpl' could not be injected as a 'com.goat.service.impl.PersonServiceImpl' because it is a JDK dynamic proxy that implements:
        com.goat.service.PersonService
        Action:
        Consider injecting the bean as one of its interfaces or forcing the use of CGLib-based proxies by setting proxyTargetClass=true on @EnableAsync and/or @EnableCaching.
        
     解决方法： 由于没有引入aop依赖。。。
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-aop</artifactId>
                </dependency>