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
 
在微服务架构中，业务都会被拆分成一个独立的服务，服务与服务的通讯是基于 http restful 
Spring cloud 有两种服务调用方式：
    1. ribbon + restTemplate
    2. feign 

