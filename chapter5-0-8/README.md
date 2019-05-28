# 声明式缓存

    Spring 定义 CacheManager 和 Cache 接口用来统一不同的缓存技术。
    例如 JCache、 EhCache、 Hazelcast、 Guava、 Redis 等。在使用 Spring 集成 Cache 的时候，我们需要注册实现的 CacheManager 的 Bean。
    Spring Boot 为我们自动配置了 JcacheCacheConfiguration、 EhCacheCacheConfiguration、HazelcastCacheConfiguration、GuavaCacheConfiguration、RedisCacheConfiguration、SimpleCacheConfiguration 等。
    
    
    
    
    
# 默认使用 ConcurrenMapCacheManager
    在我们不使用其他第三方缓存依赖的时候，springboot自动采用基于内存map一种缓存方案ConcurrenMapCacheManager作为缓存管理器。