分布式 面临的四大问题
要求：高可用  高并发  高性能

1. 客户端如何访问这么多的服务： API 网关
2. 服务于服务之间如何通信：
    同步通信：HTTP  Apache Http Client
    异步通信：消息队列 kafka RabbitMQ
3. 这么多服务，如何管理
    服务治理： 服务注册于发现
    基于客户端的服务注册于发现：Apache Zookeeper
    基于服务端的服务注册与发现： Netflix Eureka
4. 服务挂了，怎么办？
    重试机制
    服务熔断
    服务降级
    服务限流
    
    
    
    
Zookeeper 使用 顺序临时节点 来实现分布式锁和等待队列。Zookeeper设计初衷就是为了实现分布式锁服务。