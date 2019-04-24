    
    1.ArrayDeque, （数组双端队列） 
    2.PriorityQueue, （优先级队列） 
    3.ConcurrentLinkedQueue, （基于链表的并发队列） 
    4.DelayQueue, （延期阻塞队列）（阻塞队列实现了BlockingQueue接口） 
    5.ArrayBlockingQueue, （基于数组的并发阻塞队列） 
    6.LinkedBlockingQueue, （基于链表的FIFO阻塞队列） 
    7.LinkedBlockingDeque, （基于链表的FIFO双端阻塞队列） 
    8.PriorityBlockingQueue, （带优先级的无界阻塞队列） 
    9.SynchronousQueue （并发同步阻塞队列）
    
        add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
    　　remove     移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
    　　element    返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
    　　offer      添加一个元素并返回true       如果队列已满，则返回false
    　　poll       移除并返问队列头部的元素    如果队列为空，则返回null
    　　peek       返回队列头部的元素             如果队列为空，则返回null
    　　put        添加一个元素                      如果队列满，则阻塞
    　　take       移除并返回队列头部的元素     如果队列为空，则阻塞