#   nginx
    是一款轻量级，高性能，低内存，高并发，基于http的反向代理服务器
    特性：
    2.负载均衡
    3.动静分离
    
    正是由于nginx有反向代理的能力，又能拿到所有的用户请求，再此基础上，就可以进行负载均衡、动静分离的操作了。
    说白了 就是nginx把玩了用户的所有请求
    
    
#  正反向图解

    在正向代理中，Proxy和Client同属于一个LAN（图中方框内），隐藏了客户端信息； 用户(Client) 通过  梯子(Proxy)  访问 谷歌  (Server)  这种情况下，对谷歌来说 用户是被隐藏的，  因为谷歌并不知道梯子将请求后的信息，都转发给了谁。。。
    在反向代理中，Proxy和Server同属于一个LAN（图中方框内），隐藏了服务端信息； 用户(Client) 通过  nginx(Proxy) 访问 tomcat(Server)  这种情况下，对用户来说 tomcat是被隐藏的，因为用户并不知道他的请求被nginx转发到什么地方去了。。。
    实际上，Proxy在两种代理中做的事情都是替服务器代为收发请求和响应，不过从结构上看正好左右互换了一下，所以把后出现的那种代理方式称为反向代理了。
    
    
    
#  反向代理示例    本机输入 www.123.com  虚拟机经过nginx处理后 显示 tomcat默认页面
    虚拟机 docker启动 tomcat docker run --name tom -d  -p 8080:8080 a37b9783725c
    docker logs tom  可以看到tomcat启动成功的日志
    浏览器输入： http://192.168.211.128:8080/  可以看到tomcat默认页面
    
    
    本地域名映射：
    1. 打开  C:\Windows\System32\drivers\etc\hosts 文件  添加 192.168.211.128 www.123.com
    2. 浏览器输入：  http://www.123.com:8080/   可以看到 虚拟机中的tomcat默认页面
    
    
    配置好 nginx的配置文件后  docker启动nginx 
    docker run --name ng -p 8888:80  -v /home/goat/nginx/conf/nginx.conf:/etc/nginx/nginx.conf  -d e81eb098537d
     http://192.168.211.128:8888/ 
    
