# IO  与 NIO 的主要区别
    1.前者  面向流   后者  面向缓冲区     可以理解为： 通道是是铁路  缓冲区是火车  
    2.前者  阻塞IO   后者  非阻塞IO
    3.前者  无       后者  选择器
    
    
#
     四种主要的IO模型
    1.3. 同步阻塞IO（Blocking IO）   BIO
    1.4. 同步非阻塞NIO（None Blocking IO）  NIO
    1.5. IO多路复用模型(I/O multiplexing） 
    1.6. 异步IO模型（asynchronous IO）  AIO