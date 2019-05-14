# 阻塞队列：
    当队列是空时，从队列中获取元素的操作会被阻塞，
    当队列是满时，往队列里添加元素的操作会被阻塞
    
    产生场景：
    在concurrent包 发布之前，在多线程环境下，我们每个程序员都必须自己去控制这些细节，尤其还要兼顾效率和线程安全
    而这会给我们的程序带来很大的复杂度。
    因此 BlockingQueue 应运而生：其好处是 我们不再需要关心 什么时候要阻塞线程，什么时候要唤醒线程。
    因为这一切 BlockingQueue 给你封装好了，直接拿来用！
    
    
    
# JDK7提供了7个阻塞队列  分别是：
    
    ArrayBlockingQueue ：一个由数组结构组成的有界阻塞队列。
    LinkedBlockingQueue ：一个由链表结构组成的有界阻塞队列。
    PriorityBlockingQueue ：一个支持优先级排序的无界阻塞队列。
    DelayQueue：一个使用优先级队列实现的无界阻塞队列。
    SynchronousQueue：一个不存储元素的阻塞队列。
    LinkedTransferQueue：一个由链表结构组成的无界阻塞队列。
    LinkedBlockingDeque：一个由链表结构组成的双向阻塞队列。