# streams分类
     可以从不同的数据源创建stream。
     java collection包中的Collections，Lists，Sets这些类中新增stream()和parallelStream()方法，
     通过这些方法可以创建一个顺序stream（sequential streams）或者一个并发的stream(Parallel streams)。
     并发stream(Parallel streams)更适合在多线程中使用，
     本文先介绍顺序流（sequential streams）在结尾会描述并发stream(Parallel streams)
     
     ArrayList 源码分析：
        在add() 操作时 导致底层的 Object[] 容量不够时，则动态扩容。
        默认情况下，扩容为原来的1.5倍，同时需要将原来的数组中的元素 复制到新的扩容后的数组中
        结论： 建议开发中 使用带参数的构造函数 来初始化 ArrayList 避免多次扩容
        
        在jdk7和8中的不同之处：
             ArrayList的构造函数做了调整  
             在jdk7中 new ArrayList() 就创建容量为10的数组 
             在jdk8中 new ArrayList() 创建容量为0的数组 只有在第一次add()时 才创建容量为10的数组 
             这样就节省了内存，7类似于 单例饿汉式  8类似于 单例懒汉式
     