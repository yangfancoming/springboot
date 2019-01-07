#使用 redisTemplate  缓存 注解版 方法：
    1.Application 启动类中 增加 @EnableCaching 注解
    2.实体类User 需要实现序列化  implements Serializable 
    
    　　@Cacheable 将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key。
    　　@CachePut，指定key，将更新的结果同步到redis中
    　　@CacheEvict，指定key，删除缓存数据，allEntries=true,方法调用后将立即清除缓存