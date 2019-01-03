        注意三个模块的写法，
        api 来提供统一的接口,  
        provider 实现并作为提供者，
        consumer 使用提供的服务，
        这里引入了dubbo-admin管理界面,可自行去官网下载https://github.com/apache/incubator-dubbo/tree/2.5.x/dubbo-admin
        
       
        
        api      项目 打包方式  <packaging>jar</packaging>   api层暴露的接口，不需要写任何注解加任何配置。写个接口就可以了。
        provider 项目  引用 api 项目  需要 api项目 install 到本地仓库   或者 deploy 到私服 这样 provider 项目才可以引用到
        
         http://localhost:7531/sayHello/name=jack
         
 # 消费端 发起请求后台报错：       
    com.alibaba.dubbo.rpc.RpcException: No provider available from registry 172.16.163.135:2181
     for service com.goat.service.ITestService on consumer 172.16.163.1 use dubbo version 2.0.1, 
    please check status of providers(disabled, not registered or in blacklist).
    
    是由于：提供者没有启动起来。也就是你的server端没有启动。请检查是否在Tomcat中启动失败.