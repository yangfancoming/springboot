###  8542  eureka-server    为注册中心  所有微服务都像其 进行注册
http://localhost:8542/  查看注册中心页面 

### 8111 microservice-hi  为 微服务 
http://localhost:8111/hi 

### 8112 microservice-ha  为 微服务  是 microservice-hi 副本 只是端口号不同 来体现 ribbon 调用时的负载均衡机制 
http://localhost:8112/hi 


### 8222 mic-ribbon  为 微服务消费者  对 微服务进行调用  
    http://localhost:8222/test  ribbon 测试 负载均衡 地址
    每次刷新页面进行调用 会发现   在 http://localhost:8111/hi  和 http://localhost:8112/hi 之间 进行 轮循调用 
    
### 8333 mic-feign  为 微服务消费者  对 微服务进行调用     
    http://localhost:8333/test  feign 测试 负载均衡 地址
    Feign 默认集成了 Ribbon，并和 Eureka 结合，默认实现了负载均衡的效果
 
# 在微服务架构中，业务都会被拆分成一个独立的服务，服务与服务的通讯是基于 http restful 
Spring cloud 有两种服务调用方式：
    1. ribbon + restTemplate
    2. feign 


# 熔断器  Hystrix 
一般用在  RestTemplate + Ribbon 和 Feign 调用消费服务的项目中的  调用服务的方法上 

1.RestTemplate + Ribbon
在 启动类头部         增加 @EnableHystrix  注解 
在 service调用方法上  增加 @HystrixCommand 注解并指定 fallbackMethod 熔断方法

2.Feign
在 service接口方法上  增加 @FeignClient(value = "goat2234234234",fallback = SchedualServiceHiHystric.class) // 
新增 fallback 指定的类 实现 当前接口 并重写 接口中的方法  作为其 熔断方法

然后关闭服务提供者，再次请求 http://localhost:8222/test 会调用 @HystrixCommand 注解并指定的熔断方法