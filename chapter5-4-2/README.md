@EnableEurekaClient  (服务提供者)

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
在 pom.xml 文件 中    增加 依赖
在 启动类头部         增加 @EnableHystrix  注解 
在 service调用方法上  增加 @HystrixCommand 注解并指定 fallbackMethod 熔断方法

2.Feign
由于 Feign 自带 Hystrix  不需要在 pom.xml 中增加依赖 
在 service接口方法上  增加 @FeignClient(value = "goat2234234234",fallback = SchedualServiceHiHystric.class) // 
新增 fallback 指定的类 实现 当前接口 并重写 接口中的方法  作为其 熔断方法

然后关闭服务提供者，再次请求 http://localhost:8222/test 会调用 @HystrixCommand 注解并指定的熔断方法


# 熔断器  Hystrix  仪表盘

1. 在 pom.xml 中增加依赖
2. 在 Application 中增加 @EnableHystrixDashboard 注解
3. 创建 hystrix.stream 的 Servlet 配置  (HystrixDashboardConfiguration)
4. 测试 Hystrix Dashboard 浏览器端访问 http://localhost:8333/hystrix 界面如下：
5. 在熔断页面 填写 http://localhost:8333/hystrix.stream  delay：监视时间间隔  Title： 随意

### 8444 网关  Zuul 
1. 在 pom.xml 中增加依赖
2. 在 Application 中增加 @EnableZuulProxy 注解
3. 在 application.yml 配置文件中 增加 网关配置 

# 配置网关路由 过滤器

继承 ZuulFilter 类并在类上增加 @Component 注解就可以使用服务过滤功能
两个测试地址都可以
http://localhost:8444/api/a/test
http://localhost:8444/api/b/test
测试结果：每次经过 Zuul 的请求 都会被 LoginFilter 拦截 

# 配置网关路由失败时的回调

增加 WebAdminFeignFallbackProvider 路由调用失败 回调提供者类
在 getRoute() 函数中 通过 serviceId (spring.application.name=mic-ribbon) 给指定 项目 提供回调服务 
配置好后 重启 Zuul 项目  干掉 提供微服务的项目 后  http://localhost:8444/api/b/test  测试
页面返回  {"message":"无法连接，请检查您的网络","status":200}  表明执行了  我们配置的回调 

# 8555 配置中心 
1. 在 pom.xml 中增加依赖
2. 在 Application 中增加 @EnableConfigServer 注解
3. 在 application.yml 配置文件中 增加 配置 


二、SpringCloud子项目介绍
　　Spring Cloud Config：配置管理开发工具包，可以让你把配置放到远程服务器，目前支持本地存储、Git以及Subversion。
            利用 Spring Cloud Bus 结合 RabibtMQ实现配置的自动刷新 
　　Spring Cloud Bus：事件、消息总线，用于在集群（例如，配置变化事件）中传播状态变化，可与Spring Cloud Config联合实现热部署。
　　Spring Cloud Netflix：针对多种Netflix组件提供的开发工具包，其中包括Eureka、Hystrix、Zuul、Archaius等。
　　Netflix Eureka：云端负载均衡，一个基于 REST 的服务，用于定位服务，以实现云端的负载均衡和中间层服务器的故障转移。
            服务注册中心、服务提供者、服务消费者、高可用服务发现机制
　　Netflix Hystrix：容错管理工具，旨在通过控制服务和第三方库的节点,从而对延迟和故障提供更强大的容错能力。
　　Netflix Zuul：边缘服务工具，是提供动态路由，监控，弹性，安全等的边缘服务。
　　Netflix Archaius：配置管理API，包含一系列配置管理API，提供动态类型化属性、线程安全配置操作、轮询框架、回调机制等功能。
　　Spring Cloud for Cloud Foundry：通过Oauth2协议绑定服务到CloudFoundry，CloudFoundry是VMware推出的开源PaaS云平台。
　　Spring Cloud Sleuth：日志收集工具包，封装了Dapper,Zipkin 和HTrace操作。 Sleuth 配合 Zipkin 实现服务追踪
　　Spring Cloud Data Flow：大数据操作工具，通过命令行方式操作数据流。
　　Spring Cloud Security：安全工具包，为你的应用程序添加安全控制，主要是指OAuth2。
　　Spring Cloud Consul：封装了Consul操作，consul是一个服务发现与配置工具，与Docker容器可以无缝集成。
　　Spring Cloud Zookeeper：操作Zookeeper的工具包，用于使用zookeeper方式的服务注册和发现。
　　Spring Cloud Stream：数据流操作开发包，封装了与Redis,Rabbit、Kafka等发送接收消息。
　　Spring Cloud CLI：基于 Spring Boot CLI，可以让你以命令行方式快速建立云组件。
　　Spring Cloud Ribbon： Feign 和 Ribbon 两种 通讯方法

三、微服务开发要素
　　1、Codebase：从一个代码库部署到多个环境。
　　2、Dependencies：使用显式的声明隔离依赖，即模块单独运行，并可以显式管理依赖。
　　3、Config：在系统外部存储配置信息。
　　4、Backing Services：把支持性服务看做是资源，支持性服务包括数据库、消息队列、缓冲服务器等。
　　5、Build, release, run：严格的划分编译、构建、运行阶段，每个阶段由工具进行管理。
　　6、Processes：应用作为无状态执行。
　　7、Port binding：经由端口绑定导出服务，优先选择 HTTP API 作为通用的集成框架。
　　8、Concurrency：并发性使用水平扩展实现，对于web就是水平扩展web应用实现。
　　9、Disposability：服务可处置性，任何服务可以随意终止或启动。
　　10、Dev/prod parity：开发和生产环境保持高度一致，一键式部署。
　　11、Logs：将日志看做是事件流来管理，所有参与的服务均使用该方式处理日志。
　　12、Admin processes：管理任务作为一次性的过程运行（使用脚本管理服务启动和停止）。

    