    
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
    
    
    1.添加元素
            addFirst(E e)在数组前面添加元素
            addLast(E e)在数组后面添加元素
            offerFirst(E e) 在数组前面添加元素，并返回是否添加成功
            offerLast(E e) 在数组后天添加元素，并返回是否添加成功
    
      2.删除元素
            removeFirst()删除第一个元素，并返回删除元素的值,如果元素为null，将抛出异常
            pollFirst()删除第一个元素，并返回删除元素的值，如果元素为null，将返回null
               removeLast()删除最后一个元素，并返回删除元素的值，如果为null，将抛出异常
            pollLast()删除最后一个元素，并返回删除元素的值，如果为null，将返回null
               removeFirstOccurrence(Object o) 删除第一次出现的指定元素
            removeLastOccurrence(Object o) 删除最后一次出现的指定元素
       
    
       3.获取元素
            getFirst() 获取第一个元素,如果没有将抛出异常
            getLast() 获取最后一个元素，如果没有将抛出异常
       
    
        4.队列操作
            add(E e) 在队列尾部添加一个元素
            offer(E e) 在队列尾部添加一个元素，并返回是否成功
            remove() 删除队列中第一个元素，并返回该元素的值，如果元素为null，将抛出异常(其实底层调用的是removeFirst())
               poll()  删除队列中第一个元素，并返回该元素的值,如果元素为null，将返回null(其实调用的是pollFirst())
               element() 获取第一个元素，如果没有将抛出异常
            peek() 获取第一个元素，如果返回null
          
    
        5.栈操作
            push(E e) 栈顶添加一个元素
            pop(E e) 移除栈顶元素,如果栈顶没有元素将抛出异常
            
    
        6.其他
            size() 获取队列中元素个数
            isEmpty() 判断队列是否为空
            iterator() 迭代器，从前向后迭代
            descendingIterator() 迭代器，从后向前迭代
            contain(Object o) 判断队列中是否存在该元素
            toArray() 转成数组
            clear() 清空队列
            clone() 克隆(复制)一个新的队列
