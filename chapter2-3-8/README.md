# SpringBoot 整合 mina 

     1. 添加 mina 依赖 
                <dependency>
                    <groupId>org.apache.mina</groupId>
                    <artifactId>mina-core</artifactId>
                    <version>2.0.9</version>
                </dependency>
                <dependency>
                    <groupId>org.apache.mina</groupId>
                    <artifactId>mina-transport-apr</artifactId>
                    <version>2.0.9</version>
                </dependency>
                <dependency>
                    <groupId>org.apache.mina</groupId>
                    <artifactId>mina-transport-serial</artifactId>
                    <version>2.0.9</version>
                </dependency>
                
                
#(1.) IoService：
    最底层的是IOService，负责具体的IO相关工作。
    这一层的典型代表有IOSocketAcceptor和IOSocketChannel，分别对应TCP协议下的服务端和客户端的IOService。
    IOService的意义在于隐藏底层IO的细节，对上提供统一的基于事件的异步IO接口。每当有数据到达时，
    IOService会先调用底层IO接口读取数据，封装成IoBuffer，之后以事件的形式通知上层代码，从而将Java NIO的同步IO接口转化成了异步IO。
    所以从图上看，进来的low-level IO经过IOService层后变成IO Event。
    常用API：
    getFilterChain() 获取过滤器链
    setHandler() 设置 真正业务的 handler
    getSessionConfig() 获取会话配置信息
    dispose()
#(2.) IoProcessor：
    这个接口在另一个线程上，负责检查是否有数据在通道上读写，也就是说它也拥有自己的Selector，
    这是与我们使用JAVA NIO 编码时的一个不同之处，通常在JAVA NIO 编码中，我们都是使用一个Selector，
    也就是不区分IoService与IoProcessor 两个功能接口。另外，IoProcessor 负责调用注册在IoService 上的过滤器，并在过滤器链之后调用IoHandler。
#(3.) IoFilter：
    这个接口定义一组拦截器，这些拦截器可以包括日志输出、黑名单过滤、数据的编码（write 方向）与解码（read 方向）等功能，
    其中数据的encode 与decode是最为重要的、也是你在使用Mina 时最主要关注的地方。
#(4.) IoHandler：
    这个接口负责编写业务逻辑，也就是接收、发送数据的地方。需要有开发者自己来实现这个接口。
    IoHandler可以看成是Mina处理流程的终点，每个IoService都需要指定一个IoHandler。
#(5.) IoSession: 
    是对底层连接（服务器与客户端的特定连接，该连接由服务器地址、端口以及客户端地址、端口来决定）的封装，
    一个IoSession对应于一个底层的IO连接（在Mina中UDP也被抽象成了连接）。
    通过IoSession，可以获取当前连接相关的上下文信息，以及向远程peer发送数据。发送数据其实也是个异步的过程。
    发送的操作首先会逆向穿过IoFilterChain，到达IoService。但IoService上并不会直接调用底层IO接口来将数据发送出去，
    而是会将该次调用封装成一个WriteRequest，放入session的writeRequestQueue中，最后由IoProcessor线程统一调度flush出去。所以发送操作并不会引起上层调用线程的阻塞。




# 短连接
    在HTTP/1.0中默认使用短连接。
    也就是说，客户端和服务器每进行一次HTTP操作，就建立一次连接，任务结束就中断连接。
    当客户端浏览器访问的某个HTML或其他类型的Web页中包含有其他的Web资源（如JavaScript文件、图像文件、CSS文件等）
    每遇到这样一个Web资源，浏览器就会重新建立一个HTTP会话。
    eg： 服务器端 在 public void messageSent(IoSession session, Object message) 方法中 成功发送消息后 直接 session.closeNow(); 关闭连接 则为短连接！
    
# 长连接
    而从HTTP/1.1起，默认使用长连接，用以保持连接特性。使用长连接的HTTP协议，会在响应头加入这行代码：
    Connection:keep-alive
    在使用长连接的情况下，当一个网页打开完成后，客户端和服务器之间用于传输HTTP数据的TCP连接不会关闭，
    客户端再次访问这个服务器时，会继续使用这一条已经建立的连接。Keep-Alive不会永久保持连接，
    它有一个保持时间，可以在不同的服务器软件（如Apache）中设定这个时间。实现长连接需要客户端和服务端都支持长连接。
    HTTP协议的长连接和短连接，实质上是TCP协议的长连接和短连接。
    eg： 服务器端 在 public void messageReceived(IoSession session,Object message) 方法中 使用条件判断 来关闭连接   则为长连接！